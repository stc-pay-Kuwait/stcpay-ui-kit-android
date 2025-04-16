package com.stcpay.uikit.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.stcpay.uikit.R
import com.stcpay.uikit.theme.Dimensions
import com.stcpay.uikit.theme.StcPayTheme
import com.stcpay.uikit.theme.SelectStcCardTextColor

@Composable
fun TitleSubtitle(titleText: String, subtitleText: String) {
    Column {
        Text(titleText, style = MaterialTheme.typography.headlineLarge)
        Spacer(Modifier.height(Dimensions.dp8))
        Text(subtitleText,
            style = MaterialTheme.typography.titleMedium.copy(
                lineHeight = 24.sp,
                color = SelectStcCardTextColor
            )
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun TextComponentsPreview(modifier: Modifier = Modifier) {
    StcPayTheme {
        Column {
            TitleSubtitle(
                stringResource(R.string.welcome_to_stc_pay),
                stringResource(R.string.log_in_or_sign_up_to_experience_the_future_of_mobile_wallet)
            )
        }
    }
}