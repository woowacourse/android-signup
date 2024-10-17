package nextstep.signup.presentation.component

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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.signup.R
import nextstep.signup.model.fieldtype.InputFieldType
import nextstep.signup.model.inputvalidity.EmailInputValidity
import nextstep.signup.model.inputvalidity.InputValidity
import nextstep.signup.model.inputvalidity.UsernameInputValidity

@Composable
fun InputField(
    label: String,
    value: String,
    onValueChange: (String, Boolean) -> Unit,
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
            inputValidity = validityOf(type, input)
            val isSubmitOk = isSubmitOk(type, input, inputValidity)
            onValueChange(input, isSubmitOk)
        },
        label = { Text(label) },
        keyboardOptions =
        KeyboardOptions(
            keyboardType = keyboardType,
        ),
    )

    Text(
        modifier =
        Modifier.padding(
            start = 16.dp,
            top = 4.dp,
            bottom = paddingBottom,
        ),
        text = errorMessageOf(type, inputValidity),
        fontSize = 12.sp,
        color = MaterialTheme.colorScheme.error,
        style = MaterialTheme.typography.bodySmall,
    )
}

private fun initInputValidity(type: InputFieldType): InputValidity {
    return when (type) {
        InputFieldType.USER_NAME -> UsernameInputValidity.NO_ERROR
        InputFieldType.EMAIL -> EmailInputValidity.NO_ERROR
    }
}

private fun validityOf(
    type: InputFieldType,
    input: String,
): InputValidity {
    return when (type) {
        InputFieldType.USER_NAME -> UsernameInputValidity.of(input)
        InputFieldType.EMAIL -> EmailInputValidity.of(input)
    }
}

private fun isSubmitOk(
    type: InputFieldType,
    input: String,
    inputValidity: InputValidity,
): Boolean {
    return when (type) {
        InputFieldType.USER_NAME -> input.isNotEmpty() && inputValidity == UsernameInputValidity.NO_ERROR
        InputFieldType.EMAIL -> input.isNotEmpty() && inputValidity == EmailInputValidity.NO_ERROR
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
private fun errorMessageOf(
    type: InputFieldType,
    validity: InputValidity,
): String {
    return when (type) {
        InputFieldType.USER_NAME -> usernameErrorMessageOf(validity as UsernameInputValidity)
        InputFieldType.EMAIL -> emailErrorMessageOf(validity as EmailInputValidity)
    }
}
