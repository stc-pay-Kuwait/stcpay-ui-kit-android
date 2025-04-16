package com.stcpay.uikit.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.stcpay.uikit.R

val stcFontFamily =
    FontFamily(
        Font(R.font.stc_forward_bold, weight = FontWeight.Bold),
        Font(R.font.stc_forward_light, weight = FontWeight.Light),
        Font(R.font.stc_forward_extra_bold, weight = FontWeight.ExtraBold),
        Font(R.font.stc_forward_medium, weight = FontWeight.Medium),
        Font(R.font.stc_forward_thin, weight = FontWeight.Thin),
        Font(R.font.stc_forward_regular),
        Font(R.font.stc_forward, weight = FontWeight.W400)
    )

// Set of Material typography styles to start with
val Typography = Typography(
    headlineLarge = TextStyle(
        color = TextPrimaryColor ,
        fontFamily = stcFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp
    ),
    headlineMedium = TextStyle(
        color = TextPrimaryColor ,
        fontFamily = stcFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),
    headlineSmall = TextStyle(
        color = TextColor,
        fontFamily = stcFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = stcFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),
    titleSmall = TextStyle(
        color = TextColor,
        fontFamily = stcFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp
    ),
    titleMedium = TextStyle(
        color = TextColor,
        fontFamily = stcFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp
    ),
)