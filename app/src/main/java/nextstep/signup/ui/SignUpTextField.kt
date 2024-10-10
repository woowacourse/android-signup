package nextstep.signup.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import nextstep.signup.R
import nextstep.signup.ui.theme.SignupTheme

@Composable
fun SignUpTextField(
    modifier: Modifier = Modifier,
    hint: String,
    isPassword: Boolean,
) {
    val enteredValue = remember { mutableStateOf("") }
    TextField(
        value = enteredValue.value,
        onValueChange = { enteredValue.value = it },
        modifier = modifier.fillMaxWidth(),
        maxLines = 1,
        placeholder = { Text(text = hint) },
        label = { Text(text = hint) },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = colorResource(id = R.color.blue_50),
            focusedLabelColor = colorResource(id = R.color.blue_50),
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