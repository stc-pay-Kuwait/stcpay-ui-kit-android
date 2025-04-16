package com.stcpay.uikit.language

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LanguageBottomSheet(
    onDismiss: () -> Unit,
    onLanguageSelected: (String) -> Unit
) {
    val languages = listOf(
        "en" to "English",
        "ar" to "Arabic",
        "fr" to "French",
        "es" to "Spanish"
    )

    ModalBottomSheet(onDismissRequest = onDismiss) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Select Language", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            languages.forEach { (code, name) ->
                Text(
                    text = name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onLanguageSelected(code) }
                        .padding(8.dp)
                )
            }
        }
    }
}