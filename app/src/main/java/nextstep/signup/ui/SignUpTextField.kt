package nextstep.signup.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.signup.ui.theme.Red
import nextstep.signup.ui.theme.SignupTheme

@Composable
fun SignUpTextField(
    value: String,
    hint: String,
    modifier: Modifier = Modifier,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    getErrorMessage: @Composable (String) -> String = { "" },
    onValueChange: (String) -> Unit,
) {
    val isError = getErrorMessage(value).isNotEmpty() && value.isNotEmpty()
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
        )
        if (isError) {
            ErrorText(value, getErrorMessage)
        }
    }
}

@Composable
fun ErrorText(
    value: String,
    getErrorMessage: @Composable (String) -> String,
) {
    Text(
        modifier = Modifier.padding(start = 16.dp),
        text = getErrorMessage(value),
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        color = Red,
    )
}

@Preview(showBackground = true)
@Composable
fun SignUpTextFieldPreview() {
    var value by remember { mutableStateOf("") }
    SignupTheme {
        SignUpTextField(
            value = value,
            modifier = Modifier,
            hint = "텍스트 필드 힌트",
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
            value = value,
            hint = "텍스트 필드 힌트",
            Modifier,
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
            value = value,
            hint = "텍스트 필드 힌트",
            Modifier,
            PasswordVisualTransformation(),
        ) {
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InvalidSignUpTextFieldPreview() {
    var value by remember { mutableStateOf("미리 보기 텍스트 값") }
    SignupTheme {
        SignUpTextField(
            value = value,
            modifier = Modifier,
            hint = "텍스트 필드 힌트",
            visualTransformation = PasswordVisualTransformation(),
            getErrorMessage = { "에러 메시지" },
        ) {
        }
    }
}
