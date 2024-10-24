package nextstep.signup.presentation.component

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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.signup.R
import nextstep.signup.model.fieldtype.PasswordInputFieldType
import nextstep.signup.model.inputvalidity.InputValidity
import nextstep.signup.model.inputvalidity.PasswordConfirmInputValidity
import nextstep.signup.model.inputvalidity.PasswordConfirmInputValidity.Companion.password
import nextstep.signup.model.inputvalidity.PasswordConfirmInputValidity.Companion.passwordConfirm
import nextstep.signup.model.inputvalidity.PasswordInputValidity

@Composable
fun PasswordInputField(
    label: String,
    value: String,
    onValueChange: (String, Boolean) -> Unit,
    paddingBottom: Dp = 0.dp,
    type: PasswordInputFieldType,
) {
    val defaultValidity = initInputValidity(type)
    var inputValidity: InputValidity by remember { mutableStateOf(defaultValidity) }

    TextField(
        modifier =
            Modifier
                .fillMaxWidth(),
        value = value,
        onValueChange = { input ->
            when (type) {
                PasswordInputFieldType.PASSWORD -> password = input
                PasswordInputFieldType.PASSWORD_CONFIRM -> passwordConfirm = input
            }
            inputValidity = validityOf(type, input)
            val isSubmitOk = isSubmitOk(type, input, inputValidity)
            onValueChange(input, isSubmitOk)
        },
        label = { Text(label) },
        keyboardOptions =
            KeyboardOptions(
                keyboardType = KeyboardType.Password,
            ),
        visualTransformation = PasswordVisualTransformation(),
    )

    Text(
        modifier =
            Modifier.padding(
                start = 16.dp,
                top = 4.dp,
                bottom = paddingBottom,
            ),
        text =
            when (type) {
                PasswordInputFieldType.PASSWORD_CONFIRM ->
                    passwordConfirmErrorMessage(
                        password,
                        passwordConfirm,
                    )

                else -> errorMessageOf(type, inputValidity)
            },
        fontSize = 12.sp,
        color = MaterialTheme.colorScheme.error,
        style = MaterialTheme.typography.bodySmall,
    )
}

private fun initInputValidity(type: PasswordInputFieldType): InputValidity {
    return when (type) {
        PasswordInputFieldType.PASSWORD -> PasswordInputValidity.VALID
        PasswordInputFieldType.PASSWORD_CONFIRM -> PasswordConfirmInputValidity.VALID
    }
}

private fun validityOf(
    type: PasswordInputFieldType,
    input: String,
): InputValidity {
    return when (type) {
        PasswordInputFieldType.PASSWORD -> PasswordInputValidity.of(input)
        PasswordInputFieldType.PASSWORD_CONFIRM -> PasswordConfirmInputValidity.of()
    }
}

private fun isSubmitOk(
    type: PasswordInputFieldType,
    input: String,
    inputValidity: InputValidity,
): Boolean {
    Log.d("alsong", "$inputValidity")
    return when (type) {
        PasswordInputFieldType.PASSWORD -> input.isNotEmpty() && inputValidity == PasswordInputValidity.VALID
        PasswordInputFieldType.PASSWORD_CONFIRM -> input.isNotEmpty() && inputValidity == PasswordConfirmInputValidity.VALID
    }
}

@Composable
private fun passwordErrorMessageOf(validity: PasswordInputValidity): String {
    return when (validity) {
        PasswordInputValidity.INVALID_FORMAT -> stringResource(R.string.invalid_password_format)
        PasswordInputValidity.INVALID_LENGTH -> stringResource(R.string.invalid_password_length)
        PasswordInputValidity.VALID -> stringResource(R.string.valid)
    }
}

@Composable
private fun passwordConfirmErrorMessageOf(validity: PasswordConfirmInputValidity): String {
    return when (validity) {
        PasswordConfirmInputValidity.DOES_NOT_MATCH -> stringResource(R.string.password_confirm_does_not_match)
        PasswordConfirmInputValidity.VALID -> stringResource(R.string.valid)
    }
}

@Composable
private fun errorMessageOf(
    type: PasswordInputFieldType,
    validity: InputValidity,
): String {
    return when (type) {
        PasswordInputFieldType.PASSWORD -> passwordErrorMessageOf(validity as PasswordInputValidity)
        PasswordInputFieldType.PASSWORD_CONFIRM -> passwordConfirmErrorMessageOf(validity as PasswordConfirmInputValidity)
    }
}

@Composable
private fun passwordConfirmErrorMessage(
    password: String,
    passwordConfirm: String,
): String {
    return when (password == passwordConfirm) {
        true -> stringResource(R.string.valid)
        false -> stringResource(R.string.password_confirm_does_not_match)
    }
}
