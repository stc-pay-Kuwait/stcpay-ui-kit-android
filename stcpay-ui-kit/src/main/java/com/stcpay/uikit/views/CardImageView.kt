package com.stcpay.uikit.views

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stcpay.uikit.R
import com.stcpay.uikit.theme.Dimensions
import com.stcpay.uikit.theme.StcPayTheme


@Composable
fun CardImageView(
    modifier: Modifier = Modifier,
    @DrawableRes imageId: Int,
    imageShape: RoundedCornerShape = RoundedCornerShape(size = 8.dp)
) {
    Box(
        modifier = modifier
            .rotate(10f)
            .padding(vertical = Dimensions.dp16)
            .height(428.dp)
            .width(323.dp)
            .clipToBounds()
            .width(IntrinsicSize.Min)
            .clip(imageShape)
    ) {
        Image(
            modifier = Modifier
                .align(Alignment.Center)
                .clip(imageShape)
                .border(
                    width = 0.5.dp,
                    color = MaterialTheme.colorScheme.onPrimary,
                    shape = imageShape
                ),
            painter = painterResource(id = imageId),
            contentDescription = "",
            contentScale = ContentScale.FillHeight
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun CardImageViewPreview(modifier: Modifier = Modifier) {
    StcPayTheme {
        Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            CardImageView(imageId = R.drawable.ic_kuwait_mobile_id)
        }
    }
}