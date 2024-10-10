package nextstep.signup.ui.signupform

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import nextstep.signup.ui.theme.SignupTheme

@Composable
fun SignUpPasswordTextField(
    label: String,
    modifier: Modifier = Modifier,
) = SignUpTextField(
    label = label,
    visualTransformation = PasswordVisualTransformation(),
    modifier = modifier,
)

@Preview(showBackground = true)
@Composable
fun SignUpPasswordTextFieldPreview() {
    SignupTheme {
        SignUpPasswordTextField("Preview")
    }
}
