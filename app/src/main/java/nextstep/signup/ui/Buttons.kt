package nextstep.signup.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DefaultButton(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            disabledContainerColor = Color.Gray,
        ),
        contentPadding = PaddingValues(vertical = 16.dp),
    ) {
        Text(
            text = text,
            fontSize = fontSize,
        )
    }
}

@Preview
@Composable
private fun DefaultButtonPreview() {
    DefaultButton(
        modifier =
            Modifier
                .fillMaxWidth(),
        text = "Sign Up",
        fontSize = 14.sp,
        onClick = {},
    )
}
