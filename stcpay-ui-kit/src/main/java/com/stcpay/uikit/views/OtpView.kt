package com.stcpay.uikit.views

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stcpay.uikit.theme.Dimensions
import com.stcpay.uikit.theme.StcPayTheme
import com.stcpay.uikit.theme.White
import com.stcpay.uikit.theme.gray
import com.stcpay.uikit.theme.onSurface
import com.stcpay.uikit.theme.secondaryDarkColor


const val OTP_VIEW_TYPE_UNDERLINE = 1
const val OTP_VIEW_TYPE_BORDER = 2

val PIN_VIEW_CONTAINER_SIZE = 60.dp

@Composable
fun OtpView(
    modifier: Modifier = Modifier,
    otpText: String = "",
    borderColor: Color = secondaryDarkColor,
    charColor: Color = White,
    charBackground: Color = secondaryDarkColor,
    charSize: TextUnit = 16.sp,
    containerSize: Dp = PIN_VIEW_CONTAINER_SIZE,
    spacing: Dp = 2.dp,
    otpCount: Int = 4,
    type: Int = OTP_VIEW_TYPE_BORDER,
    enabled: Boolean = true,
    password: Boolean = false,
    passwordChar: String = "•",
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    onFocusChanged: (FocusState) -> Unit = {},
    isFocused: Boolean = false,
    onOtpTextChange: (String) -> Unit,
) {

    BasicTextField(
        modifier = modifier.onFocusChanged {
            onFocusChanged(it)
        },
        value = otpText,
        onValueChange = {
            val length = it.length
            if (length <= otpCount) {
                onOtpTextChange.invoke(it)
            }
        },
        enabled = enabled,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        decorationBox = {
            //           LtrLayout {
            Row(horizontalArrangement = Arrangement.SpaceAround) {
                repeat(otpCount) { index ->
                    Spacer(modifier = Modifier.width(spacing))
                    CharView(
                        isFocusedState = isFocused,
                        enabled = enabled,
                        index = index,
                        text = otpText,
                        borderColor = borderColor,
                        charColor = charColor,
                        charSize = charSize,
                        containerSize = containerSize,
                        type = type,
                        charBackground = charBackground,
                        password = password,
                        passwordChar = passwordChar,
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                }
            }
        })
}


@Composable
private fun CharView(
    isFocusedState: Boolean,
    enabled: Boolean,
    index: Int,
    text: String,
    borderColor: Color,
    charColor: Color,
    charSize: TextUnit = 20.sp,
    containerSize: Dp,
    type: Int = OTP_VIEW_TYPE_UNDERLINE,
    charBackground: Color,
    password: Boolean = false,
    passwordChar: String = ""
) {

    val hasCursor = (index == text.length)

    val char = when {
        index >= text.length -> ""
        password -> passwordChar
        else -> text[index].toString()
    }

    val modifier = if (type == OTP_VIEW_TYPE_BORDER) {
        Modifier
            .border(
                width = 1.dp,
                color = if (enabled) borderColor else gray,
                shape = RoundedCornerShape(Dimensions.dp4)
            )
            .clip(RoundedCornerShape(Dimensions.dp4))
            .background(
                if (char.isEmpty() ||
                    char == "|"
                ) Color.Transparent else charBackground
            )
            .size(containerSize)
    } else Modifier
        .width(containerSize)
        .background(charBackground)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        var textModifier = modifier.wrapContentHeight()
        var textChar = char
        var textColor = charColor
        if (hasCursor && isFocusedState) {
            val infiniteTransition = rememberInfiniteTransition(label = "OtpTransition")
            val scale by infiniteTransition.animateFloat(
                initialValue = 1f,
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = keyframes {
                        durationMillis = 1000
                        1f at 0
                        1f at 499
                        0f at 500
                        0f at 999
                    }
                ), label = "OtpTransition"
            )
            textModifier = textModifier.scale(scale)
            textChar = "|"
            textColor = charBackground
        }

        Text(
            text = textChar,
            color = textColor,
            modifier = textModifier,
            style = MaterialTheme.typography.headlineMedium,
            fontSize = if (password) 20.sp else charSize,
            textAlign = TextAlign.Center,
        )
        if (type == OTP_VIEW_TYPE_UNDERLINE) {
            Spacer(modifier = Modifier.height(2.dp))
            Box(
                modifier = Modifier
                    .background(borderColor)
                    .height(1.dp)
                    .width(containerSize)
            )
        }
    }
}


//@Preview(showSystemUi = true)
//@Composable
//fun ShowOtpView() {
//    StcPayTheme {
//        OtpView(
//            otpText = "123",
//            isFocused = true
//        ) {}
//    }
//}