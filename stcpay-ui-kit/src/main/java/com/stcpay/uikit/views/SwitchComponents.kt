package com.stcpay.uikit.views

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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

@Preview(showSystemUi = true)
@Composable
fun SwitchComponentsPreview(modifier: Modifier = Modifier) {
    StcPayTheme {
        SwitchComponent(true)
    }
}