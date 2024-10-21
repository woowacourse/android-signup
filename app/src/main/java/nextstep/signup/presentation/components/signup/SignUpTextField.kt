package nextstep.signup.presentation.components.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import nextstep.signup.ui.theme.BlueGrey20

@Composable
fun SignUpTextField(
    value: String = "",
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String = "",
    isPassword: Boolean = false,
    errorMessage: String? = null
) {
    Column {
        TextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(text = label) },
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
            isError = !errorMessage.isNullOrEmpty(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = BlueGrey20,
                unfocusedContainerColor = BlueGrey20,
                errorContainerColor = BlueGrey20
            ),
            modifier = modifier
        )
        if (errorMessage != null) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 16.dp, top = 4.dp)
            )
        }
    }
}
