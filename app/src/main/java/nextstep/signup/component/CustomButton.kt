package nextstep.signup.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    shapes: RoundedCornerShape = RoundedCornerShape(25.dp),
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    buttonText: String
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(start = 32.dp, top = 0.dp, end = 32.dp, bottom = 0.dp),
        shape = shapes,
        colors = colors
    ) {
        Text(
            text = buttonText,
            fontSize = 14.sp
        )
    }
}

@Preview
@Composable
private fun CustomButtonPreview() {
    CustomButton(
        onClick = {},
        buttonText = "Button"
    )
}
