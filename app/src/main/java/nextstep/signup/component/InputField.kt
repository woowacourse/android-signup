package nextstep.signup.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
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
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(bottom = paddingBottom),
        keyboardOptions =
            KeyboardOptions(
                keyboardType = keyboardType,
            ),
        visualTransformation = visualTransformation(isPasswordInputField),
    )
}

@Composable
private fun visualTransformation(isPasswordInputField: Boolean): VisualTransformation {
    return if (isPasswordInputField) {
        PasswordVisualTransformation()
    } else {
        VisualTransformation.None
    }
}
