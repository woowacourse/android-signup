package nextstep.signup.ui.signup

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import nextstep.signup.R
import nextstep.signup.model.validation.RegexValidation
import nextstep.signup.model.validation.Validation
import nextstep.signup.ui.theme.SignupTheme
import nextstep.signup.model.validation.ValidationResult

@Composable
fun EmailTextField(
    label: String,
    text: MutableState<String>,
    validation: Validation,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit = {},
){
    val validationResult = validation.validate(text.value)
    val isError = validationResult !is ValidationResult.Success
    val errorMessage = when (validationResult) {
        is ValidationResult.RegexError-> stringResource(R.string.email_form_error)
        else -> ""
    }
    SignUpTextField(
        modifier = modifier,
        label = label,
        text = text,
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email
        ),
        isError = isError,
        errorMessage = errorMessage,
    )
}

@Preview(showBackground = true)
@Composable
fun EmailTextFieldPreview() {
    val emailValidation =
        RegexValidation(
            regex = "[a-zA-Z0-9._-]+@[a-zA-Z]+\\.+[a-zA-Z]+".toRegex(),
        )
    SignupTheme {
        EmailTextField(
            label = "Email",
            text = remember { mutableStateOf("") },
            validation = emailValidation,
        )
    }
}
