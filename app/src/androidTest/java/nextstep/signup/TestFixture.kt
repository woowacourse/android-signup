package nextstep.signup

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.TextFieldValue

@Composable
fun FakeSignUpField(
    textValue: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    validateField: ((String) -> ValidationResult)? = null,
) {
    val validationResult =
        validateField?.invoke(textValue.text) ?: ValidationResult(isValid = true)

    TextField(
        value = textValue,
        onValueChange = { onValueChange(it) },
        supportingText = {
            Text(text = validationResult.warningMessage)
        },
    )
}
