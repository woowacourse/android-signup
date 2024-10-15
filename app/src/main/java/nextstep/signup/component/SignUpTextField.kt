package nextstep.signup.component

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import nextstep.signup.R

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
    return when (label.contains(stringResource(R.string.input_hint_password), ignoreCase = true)) {
        true -> PasswordVisualTransformation()
        else -> VisualTransformation.None
    }
}
