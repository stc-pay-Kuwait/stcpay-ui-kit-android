package com.stcpay.uikit.language

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import java.util.*

val LocalAppLocale = staticCompositionLocalOf { Locale("en") }

@Composable
fun LocaleWrapper(viewModel: LanguageViewModel, content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalAppLocale provides viewModel.currentLocale.value) {
        content()
    }
}