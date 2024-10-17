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
import nextstep.signup.model.UsernameInputResult

@Composable
fun InputField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    isPasswordInputField: Boolean,
    keyboardType: KeyboardType = KeyboardType.Text,
    paddingBottom: Dp = 0.dp,
) {
    var errorType by remember { mutableStateOf(UsernameInputResult.NO_ERROR) }

    TextField(
        value = value,
        onValueChange = { input ->
            onValueChange(input)
            errorType = UsernameInputResult.of(input)
        },
        label = { Text(label) },
        modifier =
        Modifier
            .fillMaxWidth(),
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
        text = errorMessageOf(errorType),
        fontSize = 12.sp,
        color = MaterialTheme.colorScheme.error,
        style = MaterialTheme.typography.bodySmall,
    )
}


private fun visualTransformationOf(isPasswordInputField: Boolean): VisualTransformation {
    return when (isPasswordInputField) {
        true -> PasswordVisualTransformation()
        false -> VisualTransformation.None
    }
}

@Composable
fun errorMessageOf(result: UsernameInputResult): String {
    return when (result) {
        UsernameInputResult.INVALID_FORMAT -> stringResource(R.string.invalid_format)
        UsernameInputResult.INVALID_LENGTH -> stringResource(R.string.invalid_length)
        UsernameInputResult.NO_ERROR -> stringResource(R.string.no_error)
    }
}
