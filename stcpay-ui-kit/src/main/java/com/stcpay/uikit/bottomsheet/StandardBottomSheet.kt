package com.stcpay.uikit.bottomsheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StandardBottomSheet(
    data: BottomSheetData,
    onDismiss: () -> Unit
) {
    val defaultColor = when (data.type) {
        BottomSheetType.SUCCESS -> Color(0xFF4CAF50)
        BottomSheetType.ERROR -> Color(0xFFF44336)
        BottomSheetType.INFO -> Color(0xFF2196F3)
        BottomSheetType.WARNING -> Color(0xFFFF9800)
        BottomSheetType.CONFIRMATION -> Color(0xFF607D8B)
    }

    val defaultIcon = when (data.type) {
        BottomSheetType.SUCCESS -> Icons.Default.CheckCircle
        BottomSheetType.ERROR -> Icons.Default.Home
        BottomSheetType.INFO -> Icons.Default.Info
        BottomSheetType.WARNING -> Icons.Default.Warning
        BottomSheetType.CONFIRMATION -> Icons.Default.Settings
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = data.icon ?: defaultIcon,
            contentDescription = null,
            tint = data.color ?: defaultColor,
            modifier = Modifier.size(48.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = data.title ?: "", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = data.message ?: "", fontSize = 16.sp)
        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            data.secondaryButton?.let { button ->
                OutlinedButton(
                    onClick = {
                        button.onClick()
                        onDismiss()
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(button.label)
                }
            }

            Button(
                onClick = {
                    data.primaryButton.onClick()
                    onDismiss()
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(data.primaryButton.label)
            }
        }
    }
}