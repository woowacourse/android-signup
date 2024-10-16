package nextstep.signup.ui.common.textfield

import androidx.compose.foundation.layout.fillMaxWidth
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
fun SingleLineTextInput(
    label: String,
    inputType: InputType,
) {
    var value by rememberSaveable { mutableStateOf("") }
    TextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = value,
        onValueChange = { value = it },
        label = {
            LabelText(label = label)
        },
        singleLine = true,
        visualTransformation = inputType.visualTransformation,
        keyboardOptions = inputType.keyboardOptions,
        textStyle = Typography.bodyMedium,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = MaterialTheme.colorScheme.secondary,
            focusedLabelColor = MaterialTheme.colorScheme.secondary,
        ),
    )
}

@Composable
fun LabelText(label: String) {
    Text(
        text = label,
        style = Typography.labelMedium,
    )
}
