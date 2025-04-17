package com.stcpay.uikit.views

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stcpay.uikit.theme.Dimensions
import com.stcpay.uikit.theme.StcPayTheme


@Composable
fun SwitchComponent(checked: Boolean = false, onCheckedChange: ((Boolean) -> Unit)? = null) {
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        colors = SwitchDefaults.colors(
            checkedThumbColor = MaterialTheme.colorScheme.background,
            checkedTrackColor = MaterialTheme.colorScheme.primary,
            uncheckedBorderColor = MaterialTheme.colorScheme.background,
            uncheckedThumbColor = MaterialTheme.colorScheme.background
        )
    )
}

@Composable
fun SwitchTextRow(text: String, checked: Boolean) {
    Row(
        Modifier
            .border(
                1.dp,
                MaterialTheme.colorScheme.outline,
                shape = RoundedCornerShape(Dimensions.dp10)
            )
            .fillMaxWidth()
            .padding(Dimensions.dp16),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text, style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.weight(1f))
        SwitchComponent(checked)
    }

}

@Preview(showSystemUi = true)
@Composable
fun SwitchComponentsPreview(modifier: Modifier = Modifier) {
    StcPayTheme {
        SwitchComponent(true)
    }
}