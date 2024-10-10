package nextstep.signup.ui.signupform

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import nextstep.signup.ui.theme.SignupTheme

@Composable
fun SignUpTextField(
    label: String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    modifier: Modifier = Modifier,
) {
    val text = remember { mutableStateOf("") }
    TextField(
        value = text.value,
        onValueChange = {
            text.value = it
        },
        label = { Text(text = label) },
        modifier = modifier.fillMaxWidth(),
        visualTransformation = visualTransformation,
    )
}

@Preview(showBackground = true)
@Composable
fun SignUpTextFieldPreview() {
    SignupTheme {
        SignUpTextField(
            "Preview",
        )
    }
}
