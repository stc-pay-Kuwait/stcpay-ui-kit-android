package com.stcpay.uikit.language

import android.content.Context
import android.content.res.Configuration
import java.util.*

object LocaleManager {
    private const val LANGUAGE_KEY = "app_language"

    fun setLocale(context: Context, languageCode: String): Context {
        persistLanguage(context, languageCode)
        return updateResources(context, languageCode)
    }

    fun getPersistedLanguage(context: Context): String {
        val prefs = context.getSharedPreferences("app_settings", Context.MODE_PRIVATE)
        return prefs.getString(LANGUAGE_KEY, Locale.getDefault().language) ?: "en"
    }

    private fun persistLanguage(context: Context, language: String) {
        val prefs = context.getSharedPreferences("app_settings", Context.MODE_PRIVATE)
        prefs.edit().putString(LANGUAGE_KEY, language).apply()
    }

    fun updateResources(context: Context, language: String): Context {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = Configuration(context.resources.configuration)
        config.setLocale(locale)
        config.setLayoutDirection(locale)
        return context.createConfigurationContext(config)
    }
}