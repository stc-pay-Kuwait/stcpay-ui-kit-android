package com.stcpay.uikit.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stcpay.uikit.R
import com.stcpay.uikit.theme.Dimensions
import com.stcpay.uikit.theme.StcPayTheme
import com.stcpay.uikit.theme.SelectStcCardTextColor

@Composable
fun TitleSubtitle(titleText: String, subtitleText: String, boldText: String? = null) {
    Column {
        Text(titleText, style = MaterialTheme.typography.headlineLarge)
        Spacer(Modifier.height(Dimensions.dp16))
        Text(
            buildAnnotatedString {
                append(subtitleText)
                if (!boldText.isNullOrBlank()) {
                    withStyle(SpanStyle(fontWeight = FontWeight.W500)) {
                        append(boldText)
                    }
                }
            },
            style = MaterialTheme.typography.titleMedium.copy(
                lineHeight = 24.sp,
                color = SelectStcCardTextColor
            )
        )
    }
}

@Composable
fun OutlinedTextRow(value: String = stringResource(R.string.welcome_to_stc_pay)) {
    Row(
        Modifier
            .border(
                1.dp,
                MaterialTheme.colorScheme.outline,
                shape = RoundedCornerShape(Dimensions.dp10)
            )
            .fillMaxWidth()
            .padding(Dimensions.dp16),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            value,
            style = MaterialTheme.typography.headlineMedium.copy(MaterialTheme.colorScheme.onSurface)
        )
    }
}

@Composable
fun CopyableTextRow(title: String, subtitle: String) {
    Column(
        Modifier
            .border(
                1.dp,
                MaterialTheme.colorScheme.outline,
                shape = RoundedCornerShape(Dimensions.dp10)
            )
            .fillMaxWidth()
            .padding(start = Dimensions.dp16, bottom = Dimensions.dp14),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium.copy(SelectStcCardTextColor)
            )
            Spacer(Modifier.weight(1f))
            IconButton(onClick = {}) {
                Image(
                    modifier = Modifier
                        .clipToBounds()
                        .size(Dimensions.dp14),
                    painter = painterResource(R.drawable.ic_copy),
                    contentDescription = stringResource(
                        R.string.copy
                    ),
                    contentScale = ContentScale.Fit
                )
            }
        }
        Text(
            subtitle,
            style = MaterialTheme.typography.titleMedium
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun TextComponentsPreview(modifier: Modifier = Modifier) {
    StcPayTheme {
        Column(
            Modifier.padding(Dimensions.dp16),
            verticalArrangement = Arrangement.spacedBy(Dimensions.dp16)
        ) {
            TitleSubtitle(
                stringResource(R.string.welcome_to_stc_pay),
                stringResource(R.string.log_in_or_sign_up_to_experience_the_future_of_mobile_wallet),
                stringResource(R.string._965_51234567)
            )
            OutlinedTextRow()
            CopyableTextRow(
                title = stringResource(R.string.your_stc_pay_number_is),
                subtitle = stringResource(R.string._965_51234567)
            )
        }
    }
}