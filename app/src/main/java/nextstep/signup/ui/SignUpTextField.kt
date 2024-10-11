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
    value: String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onValueChange: (String) -> Unit,
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        maxLines = 1,
        placeholder = { Text(text = hint) },
        label = { Text(text = hint) },
        colors =
            TextFieldDefaults.colors(
                focusedIndicatorColor = Blue50,
                focusedLabelColor = Grey50,
            ),
        visualTransformation = visualTransformation,
    )
}

@Preview(showBackground = true)
@Composable
fun SignUpTextFieldPreview() {
    var value by remember { mutableStateOf("") }
    SignupTheme {
        SignUpTextField(
            Modifier,
            "텍스트 필드 힌트",
            value,
        ) {
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpTextFieldPreviewWithoutMask() {
    var value by remember { mutableStateOf("userPassword") }
    SignupTheme {
        SignUpTextField(
            Modifier,
            "텍스트 필드 힌트",
            value,
        ) {
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpTextFieldPreviewWithMask() {
    var value by remember { mutableStateOf("미리 보기 텍스트 값") }
    SignupTheme {
        SignUpTextField(
            Modifier,
            "텍스트 필드 힌트",
            value,
            PasswordVisualTransformation(),
        ) {
        }
    }
}
