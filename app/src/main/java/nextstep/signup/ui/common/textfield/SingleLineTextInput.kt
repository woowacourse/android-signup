package nextstep.signup.ui.common.textfield

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
    onValueChange: (String) -> String,
    label: String,
    inputType: InputType,
) {
    var value by rememberSaveable { mutableStateOf("") }

    TextField(
        modifier = modifier,
        value = value,
        onValueChange = {
            value = onValueChange(it)
        },
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
    )
}
