package com.stcpay.uikit.views

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stcpay.uikit.R
import com.stcpay.uikit.theme.Dimensions
import com.stcpay.uikit.theme.StcPayTheme

@Composable
fun CustomDropdown(
    label: String? = null,
    placeholder: String? = null,
    value: String = placeholder ?: "",
    @DrawableRes trailingImage: Int? = null,
    onTrailingImageClick: (() -> Unit)? = null,
    onDropdownClick: () -> Unit
) {
    Column {
        if (label != null) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(label, style = MaterialTheme.typography.titleSmall)
                if (trailingImage != null) {
                    Spacer(Modifier.width(Dimensions.dp2))
                    Image(
                        painter = painterResource(trailingImage),
                        contentDescription = stringResource(
                            R.string.help
                        ),
                        modifier = Modifier.clickable {
                            if (onTrailingImageClick != null) {
                                onTrailingImageClick()
                            }
                        }
                    )
                }
            }
            Spacer(Modifier.height(Dimensions.dp6))
            Row(
                Modifier
                    .border(
                        1.dp,
                        MaterialTheme.colorScheme.outline,
                        shape = RoundedCornerShape(Dimensions.dp10)
                    )
                    .fillMaxWidth()
                    .padding(horizontal = Dimensions.dp16, vertical = Dimensions.dp12)
                    .clickable(onClick = onDropdownClick),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    value,
                    style = MaterialTheme.typography.headlineMedium.copy(MaterialTheme.colorScheme.onSurface)
                )
                Spacer(Modifier.weight(1f))
                Icon(
                    Icons.Default.KeyboardArrowDown,
                    value,
                    tint = MaterialTheme.colorScheme.onSurface
                )

            }
        }

    }

}

@Preview(showSystemUi = true)
@Composable
private fun DropdownComponentsPreview(modifier: Modifier = Modifier) {
    StcPayTheme {
        Column(Modifier.padding(Dimensions.dp16)) {
            CustomDropdown(
                label = stringResource(id = R.string.business_industry),
                placeholder = stringResource(
                    R.string.select_business_industry
                ),
                trailingImage = R.drawable.ic_help
            ) {}
        }
    }
}