package com.stcpay.uikit.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stcpay.uikit.theme.Dimensions
import com.stcpay.uikit.theme.StcPayTheme

//TODO Improve this code
@Composable
fun RadioButtonSingleSelection(list: List<String>, selectedIndex: Int = 0) {
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(list[selectedIndex]) }
    Column(Modifier.selectableGroup()) {
        list.forEach { text ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = { onOptionSelected(text) },
                        role = Role.RadioButton
                    )
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = null
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun RadioButtonComponentsPreview(modifier: Modifier = Modifier) {
    StcPayTheme {
        Column(
            modifier = Modifier.padding(Dimensions.dp16),
            verticalArrangement = Arrangement.spacedBy(Dimensions.dp16)
        ) {
            RadioButtonSingleSelection(listOf("Calls", "Missed", "Friends"))
        }
    }
}