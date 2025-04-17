package com.stcpay.uikit.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.fromHtml
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.stcpay.uikit.theme.BorderDisabledSecondary
import com.stcpay.uikit.theme.Dimensions
import com.stcpay.uikit.theme.StcPayTheme

@Composable
fun RoundedCheckBox(
    size: Dp = 50.dp,
    tickSize: Dp = 50.dp,
    radius: Dp = 50.dp,
    checked: Boolean,
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unselectedColor: Color = MaterialTheme.colorScheme.background,
    onCheckedChange: (Boolean) -> Unit
) {
    val getColor: () -> Color = { if (checked) selectedColor else unselectedColor }
    Box(
        modifier = Modifier
            .toggleable(
                value = checked,
                role = Role.Checkbox,
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                onCheckedChange(!checked)
            }
            .size(size)
            .clip(RoundedCornerShape(radius))
            .background(getColor())
            .border(width = Dimensions.dp2, SolidColor(selectedColor), RoundedCornerShape(radius)),
        contentAlignment = Alignment.Center
    ) {
        if (checked) {
            Icon(
                modifier = Modifier.size(tickSize),
                imageVector = Icons.Default.Check,
                contentDescription = "",
                tint = unselectedColor
            )
        }
    }
}


@Composable
fun TermsAndConditionsCheckBox(
    htmlText: String,
    size: Dp = Dimensions.dp20,
    checkSize: Dp = Dimensions.dp40,
    radius: Dp = Dimensions.dp4,
    checked: Boolean = false,
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unselectedColor: Color = MaterialTheme.colorScheme.background,
    onCheckedChange: (Boolean) -> Unit
) {
    Row {
        RoundedCheckBox(
            size = size,
            radius = radius,
            checked = checked,
            onCheckedChange = onCheckedChange,
            selectedColor = selectedColor,
            tickSize = checkSize,
            unselectedColor = unselectedColor,
        )
        Spacer(Modifier.width(Dimensions.dp8))
        Text(
            AnnotatedString.fromHtml(
                htmlText.trimIndent(),
                linkStyles = TextLinkStyles(
                    style = SpanStyle(
                        fontWeight = FontWeight.W500,
                        color = MaterialTheme.colorScheme.primary
                    )
                )
            ), style = MaterialTheme.typography.titleSmall
        )
    }
}

@Composable
fun CheckBoxList(
    map: Map<String, Boolean>
) {

    val checkStates = remember {
        mutableStateListOf(*map.values.toTypedArray())
    }
    Column(Modifier.selectableGroup()) {
        map.entries.forEachIndexed { ind, item ->
            Row(
                Modifier
                    .padding(vertical = Dimensions.dp8)
                    .fillMaxWidth()
                    .border(
                        width = Dimensions.dp1,
                        color = BorderDisabledSecondary,
                        shape = RoundedCornerShape(Dimensions.dp8)
                    )
                    .padding(Dimensions.dp16),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = item.key,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = Dimensions.dp16)
                )
                Spacer(Modifier.weight(1f))
                RoundedCheckBox(
                    size = Dimensions.dp20,
                    radius = Dimensions.dp4,
                    checked = checkStates[ind]
                ) {
                    checkStates[ind] = it
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun CheckboxComponentsPreview(modifier: Modifier = Modifier) {
    StcPayTheme {
        Column(
            modifier = Modifier.padding(Dimensions.dp16),
            verticalArrangement = Arrangement.spacedBy(Dimensions.dp16)
        ) {
            RoundedCheckBox(
                checked = false
            ) { }
            RoundedCheckBox(
                checked = true
            ) { }
            RoundedCheckBox(
                size = 40.dp,
                radius = 10.dp,
                checked = false
            ) { }
//            TermsAndConditionsCheckBox(
//                checked = true,
//                htmlText = stringResource(R.string.by_providing_the_mobile_number_i_hereby_agree_and_accept_the_a_href_https_www_android_com_terms_and_conditions_a_and_a_href_https_www_android_com_privacy_policy_a),
//                onCheckedChange = {}
//            )
        }
    }
}
