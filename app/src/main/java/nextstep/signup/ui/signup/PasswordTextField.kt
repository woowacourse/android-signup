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
import nextstep.signup.model.validation.CompositeValidation
import nextstep.signup.model.validation.LengthValidation
import nextstep.signup.model.validation.RegexValidation
import nextstep.signup.ui.theme.SignupTheme

@Composable
fun PasswordTextField(
    modifier: Modifier = Modifier,
    label: String,
    text: MutableState<String>,
    onValueChange: (String) -> Unit = {},
){

    val lengthValidation = LengthValidation(8..16, stringResource(R.string.password_length_error))
    val regex = "^(?=.*[a-zA-Z])(?=.*[0-9]).+\$".toRegex()
    val regexValidation = RegexValidation(regex, stringResource(R.string.password_character_error))
    val passwordValidation = CompositeValidation(lengthValidation, regexValidation)
    SignUpTextField(
        label = label,
        text = text,
        onValueChange = onValueChange,
        visualTransformation = PasswordVisualTransformation(),
        modifier = modifier,
        isError = !passwordValidation.validate(text.value),
        errorMessage = passwordValidation.errorMessage(text.value),
    )
}

@Preview(showBackground = true)
@Composable
fun PasswordTextFieldPreview() {
    SignupTheme {
        PasswordTextField(
            label = "Password",
            text = remember { mutableStateOf("aaaa12345") },
        )
    }
}
