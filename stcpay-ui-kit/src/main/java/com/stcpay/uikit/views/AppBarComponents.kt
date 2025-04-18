package com.stcpay.uikit.views

import androidx.annotation.DrawableRes
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.stcpay.uikit.R
import com.stcpay.uikit.language.LanguageBottomSheet
import com.stcpay.uikit.language.LanguageViewModel
import com.stcpay.uikit.language.LocalAppLocale
import com.stcpay.uikit.language.LocaleManager
import com.stcpay.uikit.theme.BorderDisabledSecondary
import com.stcpay.uikit.theme.Dimensions
import com.stcpay.uikit.theme.SelectStcCardTextColor
import com.stcpay.uikit.theme.StcPayTheme

@Composable
fun BaseAppBar(
    title: String = "",
    subtitle: String = "",
    boldText: String? = null,
    leadingComposable: @Composable ((modifier: Modifier) -> Unit)? = null,
    trailingComposable: @Composable ((modifier: Modifier) -> Unit)? = null,
    onClickLeading: (() -> Unit)? = null,
    onClickTrailing: (() -> Unit)? = null,
    space: Dp = Dimensions.dp40
) {
    Column {
        Spacer(Modifier.height(Dimensions.dp24))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            if (leadingComposable != null) {
                leadingComposable(Modifier.clickable {
                    if (onClickLeading != null) {
                        onClickLeading()
                    }
                })
            }
            if (trailingComposable != null) {
                trailingComposable(Modifier.clickable {
                    if (onClickTrailing != null) {
                        onClickTrailing()
                    }
                })
            }
        }
        Spacer(modifier = Modifier.height(space))
        TitleSubtitle(title, subtitle, boldText)
    }
}

@Composable
fun WelcomeScreenAppBar(languageViewModel: LanguageViewModel) {

    val context = LocalContext.current
    val locale = LocalAppLocale.current
    val localizedContext = remember(locale) {
        LocaleManager.updateResources(context, locale.language)
    }

    var showSheet by remember { mutableStateOf(false) }

    if (showSheet) {
        LanguageBottomSheet(
            onDismiss = { showSheet = false },
            onLanguageSelected = {
                languageViewModel.changeLanguage(it)
                showSheet = false
            }
        )
    }

    BaseAppBar(
        title = localizedContext.getString(R.string.welcome_to_stc_pay),
        subtitle = localizedContext.getString(R.string.log_in_or_sign_up_to_experience_the_future_of_mobile_wallet),
        leadingComposable = {
            TextButton(onClick = {
                showSheet = true
            }) {
                Text(
                    "العربية",
                    style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.primary)
                )
            }

        },
        onClickLeading = {},
        onClickTrailing = {}
    )
}

@Composable
fun CommonAppBar(
    title: String,
    subtitle: String,
    boldText: String? = null,
    leadingIcon: ImageVector? = Icons.AutoMirrored.Default.ArrowBack,
    trailingIcon: ImageVector? = Icons.Default.MoreVert,
    onClickLeading: (() -> Unit)? = null
) {
    BaseAppBar(
        title = title,
        subtitle = subtitle,
        boldText = boldText,
        leadingComposable = {
            if (leadingIcon != null) {
                Icon(
                    leadingIcon,
                    stringResource(R.string.back),
                    tint = SelectStcCardTextColor,
                    modifier = Modifier.clickable {
                        if (onClickLeading != null)
                            onClickLeading()
                    }
                )
            }
        },
        trailingComposable = {
            if(trailingIcon != null){
                Icon(
                    trailingIcon,
                    stringResource(R.string.back),
                    tint = SelectStcCardTextColor
                )
            }
        },
        onClickLeading = onClickLeading,
        onClickTrailing = {}
    )
}


@Composable
fun SelectStcPayCardAppBar(
    title: String,
    subtitle: String,
    @DrawableRes leadingIcon: Int = R.drawable.ic_card_topbar,
) {
    BaseAppBar(
        title = title,
        subtitle = subtitle,
        leadingComposable = {

            Column(
                modifier = Modifier
                    .size(Dimensions.dp48)
                    .clip(RoundedCornerShape(Dimensions.dp5))
                    .border(
                        width = Dimensions.dp1,
                        color = BorderDisabledSecondary,
                        shape = RoundedCornerShape(Dimensions.dp6)
                    )
                    .padding(vertical = Dimensions.dp16),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(leadingIcon),
                    contentDescription = null,
                    modifier = Modifier.width(Dimensions.dp20),
                )
            }


        },
        onClickLeading = {},
        space = Dimensions.dp24
    )

}

@Composable
fun AppBarSpacer() {
    Spacer(Modifier.height(Dimensions.dp40))
}


@Preview(showSystemUi = true)
@Composable
private fun AppBarComponentsPreview(modifier: Modifier = Modifier) {
    StcPayTheme {
        Column(Modifier.padding(Dimensions.dp16)) {
//            WelcomeScreenAppBar()
            CommonAppBar(
                stringResource(R.string.let_s_get_started),
                stringResource(R.string.set_up_your_stc_pay_account_in_three_simple_steps)
            )
//            SelectStcPayCardAppBar(
//                stringResource(R.string.let_s_get_started),
//                stringResource(R.string.set_up_your_stc_pay_account_in_three_simple_steps)
//            )
        }
    }
}