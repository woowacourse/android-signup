package nextstep.signup.ui.common.textfield

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import nextstep.signup.ui.theme.Typography

@Composable
fun LabelText(label: String) {
    Text(
        text = label,
        style = Typography.labelMedium,
    )
}

@Composable
fun SingleLineTextInput(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    inputType: InputType,
    validateInput: @Composable ((String) -> String)? = null,
) {
    val supportingText = validateInput?.let { it(value) }

    TextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        label = {
            LabelText(label = label)
        },
        singleLine = true,
        visualTransformation = inputType.visualTransformation,
        keyboardOptions = inputType.keyboardOptions,
        textStyle = Typography.bodyMedium,
        colors =
            TextFieldDefaults.colors(
                focusedIndicatorColor = MaterialTheme.colorScheme.secondary,
                focusedLabelColor = MaterialTheme.colorScheme.secondary,
            ),
        isError = !supportingText.isNullOrBlank(),
        supportingText = {
            if (!supportingText.isNullOrBlank()) {
                Text(supportingText)
            }
        },
    )
}
