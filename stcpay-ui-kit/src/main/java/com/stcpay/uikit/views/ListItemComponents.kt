package com.stcpay.uikit.views

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.stcpay.uikit.theme.BorderDisabledSecondary
import com.stcpay.uikit.theme.Dimensions

@Composable
fun ImageTitleDescriptionItem(
    @DrawableRes image: Int,
    title: String? = null,
    description: String? = null
) {
    Row(
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
        modifier = Modifier
            .border(
                BorderStroke(Dimensions.dp1, BorderDisabledSecondary),
                shape = RoundedCornerShape(Dimensions.dp10)
            )
            .padding(Dimensions.dp16)
            .fillMaxWidth()
    ) {
        Image(painter = painterResource(image), contentDescription = null)
        Spacer(Modifier.width(Dimensions.dp12))
        Column {
            if (title != null) {
                Text(title, style = MaterialTheme.typography.bodyMedium)
            }
            Spacer(Modifier.height(Dimensions.dp8))
            if (description != null) {
                Text(description, style = MaterialTheme.typography.titleSmall)
            }
        }
    }

}

