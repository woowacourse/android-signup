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
import nextstep.signup.model.validation.Validation
import nextstep.signup.ui.theme.SignupTheme
import nextstep.signup.model.validation.ValidationResult

@Composable
fun PasswordTextField(
    label: String,
    text: MutableState<String>,
    validation: Validation,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit = {},
) {
    val validationResult = validation.validate(text.value)
    val isError = validationResult !is ValidationResult.Success
    val errorMessage = when (validationResult) {
        is ValidationResult.CompositeError -> validationResult.errors.map { it.toPasswordErrorMessage() }
            .joinToString("\n")
        else -> ""
    }
    SignUpTextField(
        label = label,
        text = text,
        onValueChange = onValueChange,
        visualTransformation = PasswordVisualTransformation(),
        modifier = modifier,
        isError = isError,
        errorMessage = errorMessage,
    )
}

@Composable
fun ValidationResult.toPasswordErrorMessage(): String =
    when (this) {
        is ValidationResult.LengthError -> stringResource(R.string.password_length_error)
        is ValidationResult.RegexError -> stringResource(R.string.password_character_error)
        else -> ""
    }

@Preview(showBackground = true)
@Composable
fun PasswordTextFieldPreview() {
    val lengthValidation = LengthValidation(
        range = 8..16,
    )
    val regex = "^(?=.*[a-zA-Z])(?=.*[0-9]).+\$".toRegex()
    val regexValidation = RegexValidation(
        regex = regex,
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
