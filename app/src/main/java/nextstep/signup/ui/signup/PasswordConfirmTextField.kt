package nextstep.signup.ui.signup

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import nextstep.signup.R
import nextstep.signup.ui.theme.SignupTheme

@Composable
fun PasswordConfirmTextField(
    password: MutableState<String>,
    passwordConfirm: MutableState<String>,
    modifier: Modifier = Modifier,
    label: String,
    onValueChange: (String) -> Unit = {},
){
    val isError = password.value != passwordConfirm.value
    SignUpTextField(
        label = label,
        text = passwordConfirm,
        onValueChange = onValueChange,
        visualTransformation = PasswordVisualTransformation(),
        modifier = modifier,
        isError = isError,
        errorMessage = stringResource(R.string.password_confirm_error),
    )
}

@Preview(showBackground = true)
@Composable
fun PasswordConfirmTextFieldPreview() {
    SignupTheme {
        PasswordConfirmTextField(
            label = "PasswordConfirm",
            password = remember { mutableStateOf("aaaa12345") },
            passwordConfirm = remember { mutableStateOf("aaaa12345") },
        )
    }
}
