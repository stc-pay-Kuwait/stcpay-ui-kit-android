package com.stcpay.uikit.views

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.stcpay.uikit.theme.Dimensions.dp0
import com.stcpay.uikit.theme.Dimensions.dp1
import com.stcpay.uikit.theme.Dimensions.dp10
import com.stcpay.uikit.theme.Dimensions.dp16
import com.stcpay.uikit.theme.StcPayTheme
import com.stcpay.uikit.theme.White
import com.stcpay.uikit.R
import com.stcpay.uikit.theme.Dimensions.dp2
import com.stcpay.uikit.theme.Dimensions.dp20
import com.stcpay.uikit.theme.Dimensions.dp24
import com.stcpay.uikit.theme.Dimensions.dp4
import com.stcpay.uikit.theme.Dimensions.dp6
import com.stcpay.uikit.theme.Dimensions.dp64
import com.stcpay.uikit.theme.Dimensions.dp8
import com.stcpay.uikit.theme.PrimaryColor
import com.stcpay.uikit.theme.SelectStcCardTextColor
import com.stcpay.uikit.theme.TextPrimaryColor

@Composable
fun SelectStcPayCardView(
    @StringRes tagText : Int? = null,
    @DrawableRes cardImg : Int,
    @StringRes heading : Int,
    @StringRes cashback : Int,
    isSelected : Boolean
){
    Box{
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = if (tagText != null) dp16 else dp0),
            shape = RoundedCornerShape(dp10),
            border = BorderStroke(dp1, MaterialTheme.colorScheme.outline),
            colors = CardDefaults.cardColors(containerColor = White)
        ){
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(dp16),
                verticalAlignment = Alignment.Top
            ) {

                Image(
                    painter = painterResource(cardImg),
                    contentDescription = null,
                    modifier = Modifier
                        .width(dp64)
                        .clip(RoundedCornerShape(dp8)),
                    contentScale = ContentScale.FillWidth
                )

                Spacer(modifier = Modifier.width(dp16))

                Column{
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = stringResource(heading),
                            style = MaterialTheme.typography.bodyMedium.copy(
                                color = TextPrimaryColor
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                        )
                        Spacer(modifier = Modifier.width(dp4))

                        RadioButton(
                            onClick = {},
                            selected = isSelected,
                            modifier = Modifier.size(dp20)
                        )
                    }
                    Spacer(modifier = Modifier.height(dp6))

                    TextWithStartIcon(
                        img = R.drawable.img_coin,
                        text = cashback
                    )
                    Spacer(modifier = Modifier.height(dp2))
                    TextWithStartIcon(
                        img = R.drawable.img_airplane,
                        text = R.string.airport_lounge_access
                    )
                    Spacer(modifier = Modifier.height(dp2))
                    TextWithStartIcon(
                        img = R.drawable.ic_down,
                        text = R.string.view_all_benefits,
                        textColor = PrimaryColor
                    )



                }

            }
        }
        if (tagText != null){
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.End
            ) {
                TopTag(tagText)
            }

        }


    }
}


@Composable
fun TextWithStartIcon(
    @DrawableRes img : Int,
    @StringRes text : Int,
    textColor : Color = SelectStcCardTextColor,
    onCLick : (() -> Unit)? = null
){
    val interactionSource = remember { MutableInteractionSource() }
    Row(
        modifier = Modifier.clickable(
            indication = null,
            interactionSource = interactionSource,
            onClick = {
                if(onCLick != null){
                    onCLick()
                }
            }
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(img),
            contentDescription = null,
            modifier = Modifier.size(dp24)
        )
        Spacer(modifier = Modifier.width(dp6))
        Text(
            text = stringResource(text),
            style = MaterialTheme.typography.titleMedium.copy(
                lineHeight = 24.sp,
                color = textColor
            )
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun ShowSelectStcPayCardView(){
    StcPayTheme {
        Column(Modifier.fillMaxSize().padding(dp16),
            verticalArrangement = Arrangement.Center) {
            SelectStcPayCardView(
                tagText = R.string.best_value,
                heading = R.string.elite_card,
                cardImg = R.drawable.ic_kuwait_mobile_id,
                isSelected = true,
                cashback = R.string.upto_five_percent_cashback
            )

            Spacer(modifier = Modifier.height(dp20))
            SelectStcPayCardView(
                heading = R.string.elite_card,
                cardImg = R.drawable.ic_kuwait_mobile_id,
                isSelected = false,
                cashback = R.string.upto_five_percent_cashback
            )
        }
    }
}