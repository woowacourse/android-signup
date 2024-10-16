package nextstep.signup.ui.component

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import nextstep.signup.ui.theme.Blue50
import nextstep.signup.ui.theme.BlueGray

@Composable
fun SignUpTextField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    isValid: Boolean,
    errorMessage: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    TextField(
        modifier = modifier,
        label = { Text(label) },
        value = value,
        onValueChange = onValueChange,
        isError = value.isNotEmpty() && !isValid,
        supportingText = { if (value.isNotEmpty()) Text(errorMessage) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        visualTransformation = visualTransformation,
        colors =
            TextFieldDefaults.colors(
                focusedContainerColor = BlueGray,
                unfocusedContainerColor = BlueGray,
                focusedIndicatorColor = Blue50,
                focusedLabelColor = Blue50,
                cursorColor = Blue50,
            ),
    )
}
