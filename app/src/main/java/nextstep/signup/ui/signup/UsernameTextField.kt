package nextstep.signup.ui.signup

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.signup.R
import nextstep.signup.ui.validation.CompositeValidation
import nextstep.signup.ui.validation.LengthValidation
import nextstep.signup.ui.validation.RegexValidation
import nextstep.signup.ui.validation.Validation
import nextstep.signup.ui.validation.ValidationResult

@Composable
fun UsernameTextField(
    username: MutableState<String>,
    validation: Validation,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit = {},
) {
    val validationResult = validation.validate(username.value)
    val isError = validationResult !is ValidationResult.Success
    val errorMessage = when (validationResult) {
        is ValidationResult.CompositeError -> validationResult.errors.map { it.toUsernameErrorMessage() }
            .joinToString("\n")
        else -> ""
    }
    SignUpTextField(
        modifier = modifier,
        label = stringResource(R.string.username),
        text = username,
        onValueChange = onValueChange,
        isError = isError,
        errorMessage = errorMessage,
    )
}

@Composable
fun ValidationResult.toUsernameErrorMessage(): String =
    when (this) {
        is ValidationResult.LengthError -> stringResource(R.string.username_length_error)
        is ValidationResult.RegexError -> stringResource(R.string.username_character_error)
        else -> ""
    }

@Preview(showBackground = true)
@Composable
fun UsernameTextFieldPreview() {
    val lengthValidation = LengthValidation(
        range = 2..5,
    )
    val characterValidation = RegexValidation(
        regex = "[a-zA-Z가-힣]+".toRegex(),
    )
    val userNameValidation = CompositeValidation(lengthValidation, characterValidation)
    UsernameTextField(
        username = remember { mutableStateOf("") },
        validation = userNameValidation,
        )
}
