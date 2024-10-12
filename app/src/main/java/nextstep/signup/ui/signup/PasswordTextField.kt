package nextstep.signup.ui.signup

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import nextstep.signup.ui.theme.SignupTheme

@Composable
fun PasswordTextField(
    modifier: Modifier = Modifier,
    label: String,
    text: MutableState<String>,
    onValueChange: (String) -> Unit = {},
) = SignUpTextField(
    label = label,
    text = text,
    onValueChange = onValueChange,
    visualTransformation = PasswordVisualTransformation(),
    modifier = modifier,
)

@Preview(showBackground = true)
@Composable
fun PasswordTextFieldPreview() {
    SignupTheme {
        PasswordTextField(
            label = "Password",
            text = remember { mutableStateOf("") },
        )
    }
}
