package com.stcpay.uikit.utils

import java.util.Locale

fun Long.formatMillisecondsToMMSS(): String {
    val totalSeconds = this / 1000
    val minutes = totalSeconds / 60
    val remainingSeconds = totalSeconds % 60
    return String.format(Locale.getDefault(), "%02d:%02d", minutes, remainingSeconds)
}