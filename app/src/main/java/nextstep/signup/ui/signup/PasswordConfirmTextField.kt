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
import nextstep.signup.ui.validation.EqualValidation
import nextstep.signup.ui.validation.ValidationResult

@Composable
fun PasswordConfirmTextField(
    label: String,
    text: MutableState<String>,
    validation: Validation,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit = {},
){
    val validationResult = validation.validate(text.value)
    val isError = validationResult !is ValidationResult.Success
    val errorMessage = when (validationResult) {
        is ValidationResult.EqualError -> stringResource(R.string.password_confirm_error)
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

@Preview(showBackground = true)
@Composable
fun PasswordConfirmTextFieldPreview() {
    val passwordConfirmValidation = EqualValidation("aaaa12342")
    SignupTheme {
        PasswordTextField(
            label = "Password",
            validation = passwordConfirmValidation,
            text = remember { mutableStateOf("aaaa12345") },
        )
    }
}
