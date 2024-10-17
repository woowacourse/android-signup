package nextstep.signup.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.signup.R
import nextstep.signup.model.inputresult.EmailInputResult
import nextstep.signup.model.InputFieldType
import nextstep.signup.model.inputresult.InputResult
import nextstep.signup.model.inputresult.PasswordConfirmInputResult
import nextstep.signup.model.inputresult.PasswordInputResult
import nextstep.signup.model.inputresult.UsernameInputResult

@Composable
fun InputField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    isPasswordInputField: Boolean,
    keyboardType: KeyboardType = KeyboardType.Text,
    paddingBottom: Dp = 0.dp,
    type: InputFieldType,
) {
    var inputResult by remember { mutableStateOf(UsernameInputResult.NO_ERROR) }

    TextField(
        modifier =
        Modifier
            .fillMaxWidth(),
        value = value,
        onValueChange = { input ->
            onValueChange(input)
            inputResult = UsernameInputResult.of(input)
        },
        label = { Text(label) },
        keyboardOptions =
        KeyboardOptions(
            keyboardType = keyboardType,
        ),
        visualTransformation = visualTransformationOf(isPasswordInputField),
    )

    Text(
        modifier = Modifier.padding(
            start = 16.dp,
            top = 4.dp,
            bottom = paddingBottom
        ),
        text = errorMessageOf(type, inputResult),
        fontSize = 12.sp,
        color = MaterialTheme.colorScheme.error,
        style = MaterialTheme.typography.bodySmall,
    )
}

@Composable
private fun usernameErrorMessageOf(result: UsernameInputResult): String {
    return when (result) {
        UsernameInputResult.INVALID_FORMAT -> stringResource(R.string.invalid_username_format)
        UsernameInputResult.INVALID_LENGTH -> stringResource(R.string.invalid_username_length)
        UsernameInputResult.NO_ERROR -> stringResource(R.string.no_error)
    }
}

@Composable
private fun emailErrorMessageOf(result: EmailInputResult): String {
    return when (result) {
        EmailInputResult.INVALID_FORMAT -> stringResource(R.string.invalid_email_format)
        EmailInputResult.NO_ERROR -> stringResource(R.string.no_error)
    }
}

@Composable
private fun passwordErrorMessageOf(result: PasswordInputResult): String {
    return when (result) {
        PasswordInputResult.INVALID_FORMAT -> stringResource(R.string.invalid_password_format)
        PasswordInputResult.INVALID_LENGTH -> stringResource(R.string.invalid_password_length)
        PasswordInputResult.NO_ERROR -> stringResource(R.string.no_error)
    }
}

@Composable
private fun passwordConfirmErrorMessageOf(result: PasswordConfirmInputResult): String {
    return when (result) {
        PasswordConfirmInputResult.DOES_NOT_MATCH -> stringResource(R.string.password_confirm_does_not_match)
        PasswordConfirmInputResult.NO_ERROR -> stringResource(R.string.no_error)
    }
}

@Composable
private fun errorMessageOf(inputFieldType: InputFieldType, result: InputResult): String {
    return when (inputFieldType) {
        InputFieldType.USER_NAME -> usernameErrorMessageOf(result as UsernameInputResult)
        InputFieldType.EMAIL -> emailErrorMessageOf(result as EmailInputResult)
        InputFieldType.PASSWORD -> passwordErrorMessageOf(result as PasswordInputResult)
        InputFieldType.PASSWORD_CONFIRM -> passwordConfirmErrorMessageOf(result as PasswordConfirmInputResult)
    }
}

private fun visualTransformationOf(isPasswordInputField: Boolean): VisualTransformation {
    return when (isPasswordInputField) {
        true -> PasswordVisualTransformation()
        false -> VisualTransformation.None
    }
}