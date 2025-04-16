package com.stcpay.uikit.bottomsheet

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetHost() {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val sheetQueue = remember { mutableStateListOf<BottomSheetData>() }

    val currentSheet = sheetQueue.lastOrNull()

    LaunchedEffect(Unit) {
        BottomSheetManager.sheetFlow.collectLatest {
            sheetQueue.add(it)
        }
    }

    if (currentSheet != null) {
        ModalBottomSheet(
            onDismissRequest = {
                sheetQueue.removeLast()
            },
            sheetState = sheetState
        ) {
            StandardBottomSheet(
                data = currentSheet,
                onDismiss = {
                    sheetQueue.removeLast()
                }
            )
        }
    }
}