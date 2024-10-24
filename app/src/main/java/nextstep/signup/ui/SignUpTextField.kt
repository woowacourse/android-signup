package nextstep.signup.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import nextstep.signup.ui.theme.SignupTheme

@Composable
fun SignUpTextField(
    value: String,
    hint: String,
    modifier: Modifier = Modifier,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    errorMessage: String = "",
    onValueChange: (String) -> Unit,
) {
    val isError = errorMessage.isNotEmpty() && value.isNotEmpty()
    Column {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier.fillMaxWidth(),
            maxLines = 1,
            isError = isError,
            placeholder = { Text(text = hint) },
            label = { Text(text = hint) },
            visualTransformation = visualTransformation,
            supportingText = {
                if (isError) {
                    Text(text = errorMessage)
                }
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpTextFieldPreview() {
    SignupTheme {
        SignUpTextField(
            value = "",
            modifier = Modifier,
            hint = "텍스트 필드 힌트",
        ) {
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpTextFieldPreviewWithoutMask() {
    SignupTheme {
        SignUpTextField(
            value = "userPassword",
            hint = "텍스트 필드 힌트",
            modifier = Modifier,
        ) {
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpTextFieldPreviewWithMask() {
    SignupTheme {
        SignUpTextField(
            value = "미리 보기 텍스트",
            hint = "텍스트 필드 힌트",
            modifier = Modifier,
            visualTransformation = PasswordVisualTransformation(),
        ) {
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InvalidSignUpTextFieldPreview() {
    SignupTheme {
        SignUpTextField(
            value = "미리 보기 텍스트 ",
            modifier = Modifier,
            hint = "텍스트 필드 힌트",
            visualTransformation = PasswordVisualTransformation(),
            errorMessage = "에러 메시지",
        ) {
        }
    }
}
