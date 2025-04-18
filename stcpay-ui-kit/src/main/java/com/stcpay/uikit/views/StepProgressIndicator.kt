package com.stcpay.uikit.views

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.stcpay.uikit.theme.BorderDisabledSecondary
import com.stcpay.uikit.theme.Dimensions
import com.stcpay.uikit.theme.White

@Composable
fun SingleStepProgressIndicator(
    list: List<StepProgressIndicator> = listOf()
) {
    LazyColumn {
        items(list) {
            ConstraintLayout {
                val (circle, divider, titleText, descriptionText) = createRefs()
                Circle(modifier = Modifier.constrainAs(circle) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }, step = it.step)
                VerticalDivider(
                    modifier = Modifier
                        .height(40.dp)
                        .padding(Dimensions.dp4)
                        .constrainAs(divider) {
                            top.linkTo(circle.bottom)
                            start.linkTo(circle.start)
                            end.linkTo(circle.end)
                        }, thickness = 2.dp, color = BorderDisabledSecondary
                )
                Text(
                    modifier = Modifier
                        .padding(start = Dimensions.dp12)
                        .constrainAs(titleText) {
                            top.linkTo(circle.top)
                            bottom.linkTo(circle.bottom)
                            start.linkTo(circle.end)
                        },
                    text = it.title,
                    maxLines = 1,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color =
                        if (it.step == Step.STARTED) MaterialTheme.colorScheme.onBackground else MaterialTheme.colorScheme.onSurface
                    )
                )
                Text(
                    modifier = Modifier
                        .padding(horizontal = Dimensions.dp12, vertical = Dimensions.dp16)
                        .constrainAs(descriptionText) {
                            top.linkTo(titleText.bottom)
                            start.linkTo(circle.end)
                        },
                    text = it.description,
                    maxLines = 2,
                    style = MaterialTheme.typography.headlineMedium.copy(
                        color =
                        if (it.step == Step.STARTED) MaterialTheme.colorScheme.onBackground else MaterialTheme.colorScheme.onSurface
                    )
                )
            }
        }
    }
}


@Composable
private fun Circle(
    modifier: Modifier = Modifier,
    step: Step = Step.NOT_STARTED,
    size: Dp = 30.dp,
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unselectedColor: Color = BorderDisabledSecondary,
    strokeDP: Dp = 2.dp
) {
    val painter = rememberVectorPainter(Icons.Default.Check)
    val tickDifference = 15
    Canvas(
        modifier = modifier
            .size(size)
            .padding(2.dp)
    ) {
        val canvasWidth = this.size.width
        val canvasHeight = this.size.height
        if (step == Step.COMPLETED) {
            drawCircle(
                color = selectedColor,
                center = Offset(x = canvasWidth / 2, y = canvasHeight / 2),
                radius = this.size.minDimension / 2,
            )
            with(painter) {
                draw(
                    size = Size(size.toPx() - tickDifference, size.toPx() - tickDifference),
                    alpha = 1f,
                    colorFilter = ColorFilter.tint(White)
                )
            }
        } else {
            drawCircle(
                color = if (step == Step.STARTED) selectedColor else unselectedColor,
                center = Offset(x = canvasWidth / 2, y = canvasHeight / 2),
                radius = this.size.minDimension / 2,
                style = Stroke(width = strokeDP.toPx()) // Add a stroke with a width of 5dp
            )

            if (step == Step.NOT_STARTED) drawCircle(
                color = unselectedColor,
                center = Offset(x = canvasWidth / 2, y = canvasHeight / 2),
                radius = this.size.minDimension / 6,
            )
        }
    }
}

enum class Step {
    NOT_STARTED, STARTED, COMPLETED
}

data class StepProgressIndicator(
    val title: String,
    val description: String,
    val step: Step
)

//@Preview(showSystemUi = true)
//@Composable
//fun StepProgressIndicatorPreview(modifier: Modifier = Modifier) {
//    LocalStcKuwaitTheme {
//        Column(
//            Modifier
//                .padding(Dimensions.dp16)
//                .fillMaxSize(),
//            verticalArrangement = Arrangement.Center
//        ) {
//            SingleStepProgressIndicator(
//                listOf(
//                    StepProgressIndicator(
//                        title = stringResource(R.string.create_your_account),
//                        description = stringResource(R.string.verify_phone_number_set_passcode),
//                        step = Step.STARTED
//                    ),
//                    StepProgressIndicator(
//                        title = stringResource(R.string.verify_your_identity),
//                        description = stringResource(R.string.upload_your_id_take_a_selfie),
//                        step = Step.NOT_STARTED
//                    ),
//                    StepProgressIndicator(
//                        title = stringResource(R.string.answer_simple_questions),
//                        description = stringResource(R.string.provide_further_details_about_yourself_details),
//                        step = Step.NOT_STARTED
//                    ),
//                )
//            )
//        }
//    }
//}
