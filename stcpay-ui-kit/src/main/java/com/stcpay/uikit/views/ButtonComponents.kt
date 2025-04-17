package com.stcpay.uikit.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stcpay.uikit.theme.Dimensions
import com.stcpay.uikit.theme.StcPayTheme
import com.stcpay.uikit.theme.PrimaryButtonBorderColor
import com.stcpay.uikit.R
import com.stcpay.uikit.theme.White


@Composable
private fun TextForButtons(color : Color = White,text: String) {
    Text(
        modifier = Modifier.padding(Dimensions.dp12),
        text = text,
        style = MaterialTheme.typography.bodyMedium.copy(color = color),
    )
}

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String = "",
    containerColor: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = Color.White,
    borderColor: Color = PrimaryButtonBorderColor,
    isEnabled : Boolean = true,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        enabled = isEnabled,
        elevation = ButtonDefaults.filledTonalButtonElevation(0.dp),
        onClick = onClick,
        shape = RoundedCornerShape(Dimensions.dp8),
        border = BorderStroke(1.dp, borderColor),
        colors = ButtonDefaults.filledTonalButtonColors(
            containerColor = containerColor, contentColor = contentColor
        )
    ) {
        TextForButtons(contentColor,text)
    }
}

@Composable
fun SecondaryButton(
    modifier: Modifier = Modifier,
    text: String = "",
    color: Color = MaterialTheme.colorScheme.primary,
    onClick: () -> Unit
) {
    TextButton(
        shape = RoundedCornerShape(Dimensions.dp8),
        modifier = modifier.fillMaxWidth(),
        elevation = ButtonDefaults.filledTonalButtonElevation(0.dp),
        border = BorderStroke(1.dp, color), onClick = onClick
    ) {
        TextForButtons(color,text)
    }
}

@Composable
fun ColumnScope.WrappedPrimaryButton(
    modifier: Modifier = Modifier,
    text: String = stringResource(R.string.Continue),
    containerColor: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = Color.White,
    borderColor: Color = PrimaryButtonBorderColor,
    isEnabled : Boolean = true,
    onClick: () -> Unit
) {
    Spacer(Modifier.weight(1f))
    PrimaryButton(
        modifier = modifier,
        text = text,
        containerColor = containerColor,
        contentColor = contentColor,
        borderColor = borderColor,
        onClick = onClick,
        isEnabled = isEnabled
    )
    Spacer(Modifier.height(Dimensions.dp4))
}

@Preview(showSystemUi = true)
@Composable
private fun ButtonComponentsPreview(modifier: Modifier = Modifier) {
    StcPayTheme {
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            PrimaryButton(text = "Primary Button") {}
            SecondaryButton(text = "Secondary Button") {}
        }
    }
}