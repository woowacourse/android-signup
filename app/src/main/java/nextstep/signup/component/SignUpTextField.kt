package nextstep.signup.component

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun SignUpTextField(
    modifier: Modifier = Modifier,
    label: String
) {
    var text by remember { mutableStateOf("") }

    TextField(
        modifier = modifier,
        value = text,
        onValueChange = { text = it },
        label = { Text(label) },
        visualTransformation = VisualTransformation(label)
    )
}

@Composable
fun VisualTransformation(label: String): VisualTransformation {
    return when (label.contains("Password")) {
        true -> PasswordVisualTransformation()
        else -> VisualTransformation.None
    }
}
