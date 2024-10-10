package nextstep.signup.presentation.signup

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import nextstep.signup.ui.theme.SignupTheme
import nextstep.signup.ui.theme.Typography

@Composable
fun SignUpButton(
    modifier: Modifier = Modifier,
    enable: () -> Boolean = { true },
    text: String = "Sign Up",
) {
    val enabled = remember { mutableStateOf(true) }
    Button(
        onClick = {
            enabled.value = !enabled.value
        },
        enabled = enable(),
        modifier = modifier,
    ) {
        Text(
            text = text,
            style = Typography.labelLarge,
            color = Color.White,
        )
    }
}

@Preview
@Composable
private fun SignUpButtonPreview() {
    SignupTheme {
        SignUpButton()
    }
}
