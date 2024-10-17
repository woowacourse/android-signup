package nextstep.signup.component

import android.util.Log
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
import nextstep.signup.model.InputFieldType
import nextstep.signup.model.inputresult.EmailInputValidity
import nextstep.signup.model.inputresult.InputValidity
import nextstep.signup.model.inputresult.PasswordConfirmInputValidity
import nextstep.signup.model.inputresult.PasswordInputValidity
import nextstep.signup.model.inputresult.UsernameInputValidity

var password: String = ""
var passwordConfirm: String = ""

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
    val defaultValidity = initInputValidity(type)
    var inputValidity: InputValidity by remember { mutableStateOf(defaultValidity) }

    TextField(
        modifier =
        Modifier
            .fillMaxWidth(),
        value = value,
        onValueChange = { input ->
            onValueChange(input)
            inputValidity = validityOf(type, input)
            when (type) {
                InputFieldType.PASSWORD -> password = input
                InputFieldType.PASSWORD_CONFIRM -> passwordConfirm = input
                else -> {}
            }
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
        text = when (type) {
            InputFieldType.PASSWORD_CONFIRM -> passwordConfirmErrorMessage(password, passwordConfirm)
            else -> errorMessageOf(type, inputValidity)
        },
        fontSize = 12.sp,
        color = MaterialTheme.colorScheme.error,
        style = MaterialTheme.typography.bodySmall,
    )
}

private fun initInputValidity(type: InputFieldType): InputValidity {
    return when (type) {
        InputFieldType.USER_NAME -> UsernameInputValidity.NO_ERROR
        InputFieldType.EMAIL -> EmailInputValidity.NO_ERROR
        InputFieldType.PASSWORD -> PasswordInputValidity.NO_ERROR
        InputFieldType.PASSWORD_CONFIRM -> PasswordConfirmInputValidity.NO_ERROR
    }
}

private fun validityOf(type: InputFieldType, input: String): InputValidity {
    return when (type) {
        InputFieldType.USER_NAME -> UsernameInputValidity.of(input)
        InputFieldType.EMAIL -> EmailInputValidity.of(input)
        InputFieldType.PASSWORD -> PasswordInputValidity.of(input)
        InputFieldType.PASSWORD_CONFIRM -> PasswordConfirmInputValidity.of(input)
    }
}

@Composable
private fun usernameErrorMessageOf(validity: UsernameInputValidity): String {
    return when (validity) {
        UsernameInputValidity.INVALID_FORMAT -> stringResource(R.string.invalid_username_format)
        UsernameInputValidity.INVALID_LENGTH -> stringResource(R.string.invalid_username_length)
        UsernameInputValidity.NO_ERROR -> stringResource(R.string.no_error)
    }
}

@Composable
private fun emailErrorMessageOf(validity: EmailInputValidity): String {
    return when (validity) {
        EmailInputValidity.INVALID_FORMAT -> stringResource(R.string.invalid_email_format)
        EmailInputValidity.NO_ERROR -> stringResource(R.string.no_error)
    }
}

@Composable
private fun passwordErrorMessageOf(validity: PasswordInputValidity): String {
    return when (validity) {
        PasswordInputValidity.INVALID_FORMAT -> stringResource(R.string.invalid_password_format)
        PasswordInputValidity.INVALID_LENGTH -> stringResource(R.string.invalid_password_length)
        PasswordInputValidity.NO_ERROR -> stringResource(R.string.no_error)
    }
}

@Composable
private fun passwordConfirmErrorMessageOf(validity: PasswordConfirmInputValidity): String {
    return when (validity) {
        PasswordConfirmInputValidity.DOES_NOT_MATCH -> stringResource(R.string.password_confirm_does_not_match)
        PasswordConfirmInputValidity.NO_ERROR -> stringResource(R.string.no_error)
    }
}

@Composable
private fun errorMessageOf(type: InputFieldType, validity: InputValidity): String {
    return when (type) {
        InputFieldType.USER_NAME -> usernameErrorMessageOf(validity as UsernameInputValidity)
        InputFieldType.EMAIL -> emailErrorMessageOf(validity as EmailInputValidity)
        InputFieldType.PASSWORD -> passwordErrorMessageOf(validity as PasswordInputValidity)
        InputFieldType.PASSWORD_CONFIRM -> passwordConfirmErrorMessageOf(validity as PasswordConfirmInputValidity)
    }
}

@Composable
private fun passwordConfirmErrorMessage(password: String, passwordConfirm: String): String {
    return when (password == passwordConfirm) {
        true -> stringResource(R.string.no_error)
        false -> stringResource(R.string.password_confirm_does_not_match)
    }
}

private fun visualTransformationOf(isPasswordInputField: Boolean): VisualTransformation {
    return when (isPasswordInputField) {
        true -> PasswordVisualTransformation()
        false -> VisualTransformation.None
    }
}