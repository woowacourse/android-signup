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
import nextstep.signup.ui.validation.CompositeValidation
import nextstep.signup.ui.validation.LengthValidation
import nextstep.signup.ui.validation.RegexValidation
import nextstep.signup.ui.validation.Validation
import nextstep.signup.ui.theme.SignupTheme

@Composable
fun PasswordTextField(
    label: String,
    text: MutableState<String>,
    validation: Validation,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit = {},
){
    SignUpTextField(
        label = label,
        text = text,
        onValueChange = onValueChange,
        visualTransformation = PasswordVisualTransformation(),
        modifier = modifier,
        isError = !validation.validate(text.value),
        errorMessage = validation.errorMessage(text.value),
    )
}

@Preview(showBackground = true)
@Composable
fun PasswordTextFieldPreview() {
    val lengthValidation = LengthValidation(
        range = 8..16,
        errorMessage = stringResource(R.string.password_length_error)
    )
    val regex = "^(?=.*[a-zA-Z])(?=.*[0-9]).+\$".toRegex()
    val regexValidation = RegexValidation(
        regex = regex,
        errorMessage = stringResource(R.string.password_character_error)
    )
    val passwordValidation = CompositeValidation(lengthValidation, regexValidation)
    SignupTheme {
        PasswordTextField(
            label = "Password",
            validation = passwordValidation,
            text = remember { mutableStateOf("aaaa12345") },
        )
    }
}
