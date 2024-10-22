package nextstep.signup.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import getErrorMessageResId
import nextstep.signup.model.Name
import nextstep.signup.ui.InputFieldConfig
import nextstep.signup.ui.theme.Red50

@Composable
fun InputField(
    config: InputFieldConfig,
    modifier: Modifier = Modifier.fillMaxWidth(),
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    showError: Boolean = false,
    isPassword: Boolean = false,
    errorColor: Color = Red50
) {
    TextField(
        modifier = modifier,
        value = config.value,
        onValueChange = config.onValueChange,
        label = { Text(text = config.label) },
        isError = showError && config.model.isInvalid(),
        supportingText = {
            if (showError) {
                config.model.getValidationError().getErrorMessageResId()?.let { errorMsgId ->
                    Text(text = stringResource(id = errorMsgId), color = errorColor)
                }
            }
        },
        keyboardOptions = keyboardOptions,
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None
    )
}

@Preview
@Composable
private fun InputFieldPreview() {
    InputField(config = InputFieldConfig("Username", onValueChange = {}, model = Name("d"), label = "Username"))
}
