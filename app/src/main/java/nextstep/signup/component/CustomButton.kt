package nextstep.signup.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
    buttonHeight: Int = 50,
    shapes: RoundedCornerShape = RoundedCornerShape(25.dp),
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    buttonText: String
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(buttonHeight.dp),
        onClick = onClick,
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
