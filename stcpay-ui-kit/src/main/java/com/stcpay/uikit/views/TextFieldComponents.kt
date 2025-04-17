package com.stcpay.uikit.views

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.stcpay.uikit.R
import com.stcpay.uikit.theme.Dimensions
import com.stcpay.uikit.theme.StcPayTheme
import com.stcpay.uikit.theme.onSurface

@Composable
fun InputTextField(
    value: String,
    label: String? = null,
    placeholder: String? = null,
    leadingComposable: @Composable (() -> Unit)? = null,
    trailingComposable: @Composable (() -> Unit)? = null,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    Column {
        if (label != null) {
            Text(label, style = MaterialTheme.typography.titleSmall)
            Spacer(Modifier.height(Dimensions.dp8))
        }
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    border = BorderStroke(Dimensions.dp1, MaterialTheme.colorScheme.outline),
                    shape = RoundedCornerShape(
                        Dimensions.dp8,
                    )
                ),
            placeholder = {
                if (placeholder != null) {
                    Text(
                        placeholder,
                        style = MaterialTheme.typography.headlineMedium.copy(color = MaterialTheme.colorScheme.onSurface)
                    )
                }
            },
            leadingIcon = leadingComposable,
            trailingIcon = trailingComposable,
            value = value,
            onValueChange = onValueChange,
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
            ),
            textStyle = MaterialTheme.typography.headlineMedium.copy(
                color = MaterialTheme.colorScheme.onSurface
            ),
            keyboardOptions = keyboardOptions
        )
    }
}

@Composable
fun PhoneNumberTextField(
    value: String,
    label: String = stringResource(R.string.phone_number),
    placeholder: String? = null,
    @DrawableRes id: Int? = R.drawable.kw,
    countryCode: String? = null,
    onValueChange: (String) -> Unit
) {
    InputTextField(
        value = value,
        label = label,
        placeholder = placeholder,
        onValueChange = onValueChange,
        leadingComposable = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(
                    horizontal = Dimensions.dp16, vertical = Dimensions.dp12
                ), horizontalArrangement = Arrangement.spacedBy(Dimensions.dp8)
            ) {
                if (id != null) {
                    Image(
                        painter = painterResource(id),
                        contentDescription = stringResource(R.string.kuwait_flag)
                    )
                }
                if (countryCode != null) {
                    Text(
                        countryCode,
                        style = MaterialTheme.typography.titleSmall.copy(MaterialTheme.colorScheme.onSurface)
                    )
                }
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Phone,
            imeAction = ImeAction.Done
        )
    )
}

@Composable
fun EmailTextField(
    value: String,
    label: String = stringResource(R.string.email),
    placeholder: String = stringResource(R.string.johndoe_stcpay_com_bh),
    onValueChange: (String) -> Unit
) {
    InputTextField(
        value = value,
        label = label,
        placeholder = placeholder,
        onValueChange = onValueChange,
        leadingComposable = {
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(
                    horizontal = Dimensions.dp16, vertical = Dimensions.dp12
                ), horizontalArrangement = Arrangement.spacedBy(Dimensions.dp8)
            ) {
                Icon(
                    Icons.Outlined.Email,
                    contentDescription = stringResource(R.string.email),
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Done
        )
    )
}

@Composable
fun CivilIdField(
    value: String,
    label: String = stringResource(R.string.civil_id_number),
    placeholder: String = "XXXX XXXX XXXX",
    onValueChange: (String) -> Unit
) {
    InputTextField(
        value = value,
        label = label,
        placeholder = placeholder,
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        )
    )
}
@Composable
fun AmountTextField(
    value: String,
    label: String? = stringResource(R.string.average_monthly_remittances),
    placeholder: String? = stringResource(R.string.enter_amount_here),
    currencyString: String = stringResource(R.string.kwd),
    onValueChange: (String) -> Unit
) {
    Column {
        if (label != null) {
            Text(label, style = MaterialTheme.typography.titleSmall)
            Spacer(Modifier.height(Dimensions.dp8))
        }
        TextField(modifier = Modifier
            .fillMaxWidth()
            .border(
                border = BorderStroke(Dimensions.dp1, MaterialTheme.colorScheme.outline),
                shape = RoundedCornerShape(
                    Dimensions.dp8,
                )
            )
            .padding(
                horizontal = Dimensions.dp16
            ), placeholder = {
            if (placeholder != null) {
                Text(
                    placeholder,
                    style = MaterialTheme.typography.headlineMedium.copy(color = MaterialTheme.colorScheme.onSurface)
                )
            }
        }, leadingIcon = {
            Text(currencyString, style = MaterialTheme.typography.headlineMedium)
        }, value = value, onValueChange = onValueChange, colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
        ), textStyle = MaterialTheme.typography.headlineMedium.copy(
            color = MaterialTheme.colorScheme.onSurface
        ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            )
        )
    }
}



@Preview(showSystemUi = true)
@Composable
fun TextFieldsPreview(modifier: Modifier = Modifier) {
    StcPayTheme {
        Column(Modifier.padding(Dimensions.dp12)) {
            InputTextField(value = "", label = stringResource(R.string.normal_text), onValueChange = {})
            PhoneNumberTextField(
                value = "",
                id = R.drawable.kw,
                countryCode = "+965"
            ) {}
        }
    }
}