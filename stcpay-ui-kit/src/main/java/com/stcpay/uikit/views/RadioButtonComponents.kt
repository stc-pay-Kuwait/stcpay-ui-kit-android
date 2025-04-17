package com.stcpay.uikit.views

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.stcpay.uikit.theme.BorderDisabledSecondary
import com.stcpay.uikit.theme.Dimensions
import com.stcpay.uikit.theme.StcPayTheme

//TODO Improve this code
@Composable
fun RadioButtonSingleSelection(
    list: List<String>,
    selectedIndex: Int = 0,
    onSelect: () -> Unit = {}
) {
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(list[selectedIndex]) }
    Column(Modifier.selectableGroup()) {
        list.forEach { text ->
            Row(
                modifier = Modifier
                    .padding(vertical = Dimensions.dp8)
                    .fillMaxWidth()
                    .border(
                        width = Dimensions.dp1,
                        color = BorderDisabledSecondary,
                        shape = RoundedCornerShape(Dimensions.dp8)
                    )
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = { onOptionSelected(text) },
                        role = Role.RadioButton
                    )
                    .padding(Dimensions.dp16),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = Dimensions.dp16)
                )
                Spacer(Modifier.weight(1f))
                CustomRadioButton(selected = (text == selectedOption), onSelect = onSelect)
            }
        }
    }
}

@Composable
fun CustomRadioButton(
    modifier: Modifier = Modifier,
    text: String = "",
    selected: Boolean = false,
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unselectedColor: Color = MaterialTheme.colorScheme.outline,
    onSelect: () -> Unit = {},
    radioSize: Dp = Dimensions.dp24
) {
    Row(
        modifier = modifier
            .clickable(onClick = onSelect),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .size(radioSize)
                .background(Color.Transparent)
        ) {
            Canvas(modifier = Modifier.size(radioSize)) {
                val canvasWidth = size.width
                val canvasHeight = size.height

                if (selected) {
                    drawCircle(
                        color = selectedColor,
                        center = Offset(x = canvasWidth / 2, y = canvasHeight / 2),
                        radius = size.minDimension / 2,
                    )
                    drawCircle(
                        color = Color.White,
                        center = Offset(x = canvasWidth / 2, y = canvasHeight / 2),
                        radius = size.minDimension / 4,
                    )
                } else {
                    drawCircle(
                        color = unselectedColor,
                        center = Offset(x = canvasWidth / 2, y = canvasHeight / 2),
                        radius = size.minDimension / 2,
                        style = Stroke(width = 2f)
                    )
                }

            }
        }
        Text(text = text)
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