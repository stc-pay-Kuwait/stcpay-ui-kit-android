package com.stcpay.uikit.views

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stcpay.uikit.theme.Dimensions.dp20
import com.stcpay.uikit.theme.Dimensions.dp24
import com.stcpay.uikit.theme.StcPayTheme
import com.stcpay.uikit.R
import com.stcpay.uikit.theme.Dimensions.dp12
import com.stcpay.uikit.theme.Dimensions.dp16
import com.stcpay.uikit.theme.Dimensions.dp56
import com.stcpay.uikit.theme.Dimensions.dp8

@Composable
fun ApproveRequestBottomSheet(
    @DrawableRes img : Int,
    @StringRes heading : Int,
    @StringRes subHeading : Int,
    @StringRes buttonText : Int
){

    val configuration = LocalConfiguration.current

    val screenHeight = configuration.screenHeightDp.dp

    Column(
        modifier = Modifier
            .heightIn(max = screenHeight * 0.6f)
            .background(MaterialTheme.colorScheme.background)
            .padding(vertical = dp24, horizontal = dp20),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Image(
                painter = painterResource(img),
                contentDescription = null,
                modifier = Modifier.width(dp56),
                contentScale = ContentScale.FillWidth
            )
            Icon(
                painter = painterResource(R.drawable.ic_close),
                contentDescription = null,
                modifier = Modifier.size(dp12)
            )
        }
        Spacer(modifier = Modifier.height(dp16))
        Text(
            text = stringResource(heading),
            style = MaterialTheme.typography.headlineSmall.copy(
                fontSize = 18.sp,
                lineHeight = 28.sp
            )
        )
        Spacer(modifier = Modifier.height(dp8))
        Text(
            text = stringResource(subHeading),
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(dp20))
        PrimaryButton(
            text = stringResource(buttonText)
        ) {  }
        Spacer(modifier = Modifier.height(dp24))
        OtpTimerButtonsView(
            mElapsedTime = 30,
            text = R.string.remaining_time,
            textAlignment = Alignment.Start
        ) { }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ShowBottomSheet(){
   StcPayTheme {
       Column(
           modifier = Modifier.fillMaxSize(),
           verticalArrangement = Arrangement.Bottom
       ) {
           ApproveRequestBottomSheet(
               img = R.drawable.ic_kuwait_mobile_id,
               heading = R.string.approve_the_request_on_kuwait_mobile_id,
               subHeading = R.string.login_to_the_kuwait_mobile_id_app_and_approve_the_verification_request,
               buttonText = R.string.ok
           )
       }
   }
}