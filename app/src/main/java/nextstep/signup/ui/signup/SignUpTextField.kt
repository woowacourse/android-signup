package nextstep.signup.ui.signup

import android.inputmethodservice.Keyboard
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import nextstep.signup.ui.theme.SignupTheme

@Composable
fun SignUpTextField(
    modifier: Modifier = Modifier,
    label: String,
    text: MutableState<String>,
    onValueChange: (String) -> Unit = {},
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    errorMessage: String = ""
) {
    TextField(
        modifier = modifier.fillMaxWidth(),
        value = text.value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        isError = isError,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        supportingText = {
            if (isError) {
                Text(text = errorMessage)
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun SignUpTextFieldPreview() {
    SignupTheme {
        SignUpTextField(
            label = "Preview",
            text = remember { mutableStateOf("") },
        )
    }
}
