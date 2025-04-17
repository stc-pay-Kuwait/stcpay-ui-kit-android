package com.stcpay.uikit.views

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.stcpay.uikit.theme.StcPayTheme
import com.stcpay.uikit.R

@Composable
fun ColumnScope.OtpTimerButtonsView(
    mElapsedTime: Long,
    @StringRes text : Int = R.string.request_a_new_code_in,
    textAlignment: Alignment.Horizontal = Alignment.Start,
    onClick: () -> Unit
) {
    if (mElapsedTime == 0L) {
        Text(
            modifier = Modifier.clickable(onClick = onClick),
            text = buildAnnotatedString {
                append(stringResource(R.string.didn_t_get_a_code))

                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.W500
                    )
                ) {
                    append(" $mElapsedTime ")
                }
                append(stringResource(R.string.resend))
            },
            style = MaterialTheme.typography.titleSmall
        )
    } else {
        Text(
            modifier = Modifier.align(textAlignment), text = buildAnnotatedString {
                append(stringResource(text))

                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.W500
                    )
                ) {
                    append(" $mElapsedTime s")
                }
            }, style = MaterialTheme.typography.titleSmall
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun OtpTimerButtonPreview(modifier: Modifier = Modifier) {
    StcPayTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OtpTimerButtonsView(10) { }
        }
    }
}