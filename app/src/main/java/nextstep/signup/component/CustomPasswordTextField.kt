package nextstep.signup.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import nextstep.signup.ui.theme.Red50

@Composable
fun CustomPasswordTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    isError: Boolean = false,
    errorMessage: String? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    TextField(
        modifier = modifier
            .fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = label
            )
        },
        keyboardOptions = keyboardOptions,
        singleLine = true,
        isError = isError,
        supportingText = {
            errorMessage?.let {
                Text(
                    text = it,
                    color = Red50
                )
            }
        },
        visualTransformation = PasswordVisualTransformation()
    )
}

@Preview
@Composable
private fun CustomTextFieldPreview() {
    CustomPasswordTextField(
        value = "",
        onValueChange = {},
        label = "Label"
    )
}
