package nextstep.signup.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import nextstep.signup.ui.theme.Blue50
import nextstep.signup.ui.theme.Grey50
import nextstep.signup.ui.theme.SignupTheme

@Composable
fun SignUpTextField(
    modifier: Modifier = Modifier,
    hint: String,
    isPassword: Boolean,
) {
    var enteredValue by remember { mutableStateOf("") }
    TextField(
        value = enteredValue,
        onValueChange = { enteredValue = it },
        modifier = modifier.fillMaxWidth(),
        maxLines = 1,
        placeholder = { Text(text = hint) },
        label = { Text(text = hint) },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Blue50,
            focusedLabelColor = Grey50,
        ),
        visualTransformation = setVisualTransformation(isPassword),
    )
}

@Composable
private fun setVisualTransformation(isPassword: Boolean) =
    if (isPassword) PasswordVisualTransformation() else VisualTransformation.None

@Preview(showBackground = true)
@Composable
fun SignUpTextFieldPreview() {
    SignupTheme {
        SignUpTextField(
            Modifier,
            "미리 보기 텍스트 필드",
            true,
        )
    }
}
