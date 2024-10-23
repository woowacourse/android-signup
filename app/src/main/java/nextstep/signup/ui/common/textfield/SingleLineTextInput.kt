package nextstep.signup.ui.common.textfield

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import nextstep.signup.ui.theme.Typography

@Composable
fun SingleLineTextInput(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    inputType: InputType,
    supportingText: String? = null,
) {
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
        isError = supportingText.isNullOrBlank().not(),
        supportingText = {
            val errorMessage = supportingText ?: return@TextField
            Text(text = errorMessage)
        },
    )
}

@Composable
fun LabelText(label: String) {
    Text(
        text = label,
        style = Typography.labelMedium,
    )
}
