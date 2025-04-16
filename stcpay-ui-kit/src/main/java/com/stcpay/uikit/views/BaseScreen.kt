package com.stcpay.uikit.views

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.stcpay.uikit.language.LocalAppLocale
import com.stcpay.uikit.language.LocaleManager
import com.stcpay.uikit.theme.Dimensions
import com.stcpay.uikit.theme.StcPayTheme
import com.stcpay.uikit.theme.White
import java.util.Locale

@Composable
fun BaseScreen(comp: (@Composable ColumnScope.(context: Context, locale: Locale, localizedContext: Context) -> Unit)) {

    val context = LocalContext.current
    val locale = LocalAppLocale.current
    val localizedContext = remember(locale) {
        LocaleManager.updateResources(context, locale.language)
    }

    Column(
        Modifier
            .background(White)
            .padding(Dimensions.dp16)) {
        comp(context, locale, localizedContext)
    }
}

@Preview(showSystemUi = true)
@Composable
private fun BaseScreenComponentsPreview(modifier: Modifier = Modifier) {
    StcPayTheme {
//        BaseScreen(context, locale, localizedContext) { Text("ASDF") }
    }
}