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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun InputField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    isPasswordInputField: Boolean,
    keyboardType: KeyboardType = KeyboardType.Text,
    paddingBottom: Dp = 0.dp,
) {
    var errorMessage by remember { mutableStateOf(NO_ERROR_MESSAGE) }

    TextField(
        value = value,
        onValueChange = { newValue ->
            onValueChange(newValue)
            errorMessage = errorMessage(newValue)
        },
        label = { Text(label) },
        modifier =
            Modifier
                .fillMaxWidth(),
        keyboardOptions =
            KeyboardOptions(
                keyboardType = keyboardType,
            ),
        visualTransformation = visualTransformation(isPasswordInputField),
    )

    Text(
        text = errorMessage,
        color = MaterialTheme.colorScheme.error,
        style = MaterialTheme.typography.bodySmall,
        modifier = Modifier.padding(bottom = paddingBottom),
    )
}

private fun errorMessage(newValue: String): String {
    return when (!newValue.matches(USERNAME_REGEX.toRegex())) {
        true -> INVALID_USERNAME_FORMAT_MESSAGE
        false -> NO_ERROR_MESSAGE
    }
}

private fun visualTransformation(isPasswordInputField: Boolean): VisualTransformation {
    return when (isPasswordInputField) {
        true -> PasswordVisualTransformation()
        false -> VisualTransformation.None
    }
}

private const val USERNAME_REGEX = "^[a-zA-Z가-힣]+$"
private const val NO_ERROR_MESSAGE = ""
private const val INVALID_USERNAME_FORMAT_MESSAGE = "이름에는 숫자나 기호가 포함될 수 없습니다."
private const val INVALID_USERNAME_LENGTH_MESSAGE = "이름은 2~5자여야 합니다."
