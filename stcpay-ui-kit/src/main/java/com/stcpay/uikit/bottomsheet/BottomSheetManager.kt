package com.stcpay.uikit.bottomsheet

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

object BottomSheetManager {
    private val _sheetFlow = MutableSharedFlow<BottomSheetData>()
    val sheetFlow: SharedFlow<BottomSheetData> = _sheetFlow

    suspend fun show(sheet: BottomSheetData) {
        _sheetFlow.emit(sheet)
    }
}