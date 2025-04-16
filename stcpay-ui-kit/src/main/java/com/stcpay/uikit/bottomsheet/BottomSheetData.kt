package com.stcpay.uikit.bottomsheet

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.Color
import com.stcpay.uikit.bottomsheet.BottomSheetButton

data class BottomSheetData(
    val type: BottomSheetType,
    val title: String?,
    val message: String?,
    val primaryButton: BottomSheetButton,
    val secondaryButton: BottomSheetButton? = null,
    val icon: ImageVector? = null,
    val color: Color? = null
)