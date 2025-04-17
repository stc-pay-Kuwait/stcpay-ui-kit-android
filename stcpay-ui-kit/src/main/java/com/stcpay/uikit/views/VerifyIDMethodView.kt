package com.stcpay.uikit.views

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stcpay.uikit.R
import com.stcpay.uikit.theme.AppVersionColor
import com.stcpay.uikit.theme.Dimensions
import com.stcpay.uikit.theme.PrimaryColor
import com.stcpay.uikit.theme.StcPayTheme
import com.stcpay.uikit.theme.TagBorderColor
import com.stcpay.uikit.theme.TextColor
import com.stcpay.uikit.theme.TextPrimaryColor
import com.stcpay.uikit.theme.White

@Composable
fun VerifyIDMethodView(
    @DrawableRes img: Int,
    @StringRes title: Int,
    @StringRes subTitle: Int,
    @StringRes tagText : Int? = null,
    onClick : ()->Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    Box(modifier = Modifier)
    {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable (
                    indication = null,
                    interactionSource = interactionSource,
                    onClick = {
                        onClick()
                    }
                )
                .padding(top = if (tagText != null) Dimensions.dp16 else Dimensions.dp0)
                .align(Alignment.TopStart),
            shape = RoundedCornerShape(Dimensions.dp10),
            border = BorderStroke(Dimensions.dp1, MaterialTheme.colorScheme.outline),
            colors = CardDefaults.cardColors(
                containerColor = White
            )

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Dimensions.dp20),
                verticalAlignment = Alignment.Top
            ) {

                Image(
                    painter = painterResource(img),
                    contentDescription = null,
                    modifier = Modifier.width(Dimensions.dp64),
                    contentScale = ContentScale.Fit
                )


                Spacer(modifier = Modifier.width(Dimensions.dp16))
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = stringResource(title),
                            style = MaterialTheme.typography.headlineMedium.copy(
                                color = TextPrimaryColor,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.W500
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                        )
                        Spacer(modifier = Modifier.width(Dimensions.dp4))

                        Icon(
                            painter = painterResource(R.drawable.ic_forward),
                            contentDescription = null,
                            tint = PrimaryColor
                        )
                    }
                    Spacer(modifier = Modifier.height(Dimensions.dp8))
                    Text(
                        text = stringResource(subTitle),
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight.W400,
                            fontSize = 15.sp,
                            color = TextColor
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )

                }

            }

        }
        if (tagText != null) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.End
            ) {
                TopTag(
                    text = tagText,
                    borderColor = AppVersionColor,
                    backgroundColor = AppVersionColor,
                    textColor = White,
                    radius = Dimensions.dp5
                )
            }
        }
    }
}

@Composable
fun TopTag(
    @StringRes text: Int,
    borderColor: Color = AppVersionColor,
    backgroundColor: Color = AppVersionColor,
    textColor: Color = White,
    radius: Dp = Dimensions.dp5
) {
    Box(
        Modifier
            .padding(end = Dimensions.dp16)
            .border(BorderStroke(Dimensions.dp1, borderColor), shape = RoundedCornerShape(radius)),
    ) {
        Text(
            text = stringResource(text),
            style = MaterialTheme.typography.headlineSmall.copy(
                fontSize = 11.sp,
                lineHeight = 18.sp
            ),
            color = textColor,
            modifier = Modifier
                .background(backgroundColor, RoundedCornerShape(radius))
                .padding(horizontal = Dimensions.dp10, vertical = Dimensions.dp7),
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ShowKuwaitMobileIDCard(modifier: Modifier = Modifier) {
    StcPayTheme {
        Column(
            Modifier
                .fillMaxSize()
                .padding(Dimensions.dp16),
            verticalArrangement = Arrangement.Center
        ) {
            VerifyIDMethodView(
                R.drawable.ic_kuwait_mobile_id,
                R.string.kuwait_mobile_id,
                R.string.use_your_kuwait_mobile_id_app,
                R.string.faster,
                {}
            )

            Spacer(Modifier.height(30.dp))

            VerifyIDMethodView(
                R.drawable.img_civil_id,
                R.string.kuwait_mobile_id,
                R.string.use_your_kuwait_mobile_id_app,
                null,
                {}
                )
        }
    }
}