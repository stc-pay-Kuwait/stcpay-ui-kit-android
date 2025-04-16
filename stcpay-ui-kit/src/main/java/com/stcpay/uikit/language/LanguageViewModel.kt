package com.stcpay.uikit.language

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.AndroidViewModel
import java.util.*

class LanguageViewModel(application: Application) : AndroidViewModel(application) {
    private val _currentLocale = mutableStateOf(Locale(LocaleManager.getPersistedLanguage(application)))
    val currentLocale: State<Locale> = _currentLocale

    fun changeLanguage(languageCode: String) {
        LocaleManager.setLocale(getApplication(), languageCode)
        _currentLocale.value = Locale(languageCode)
    }
}