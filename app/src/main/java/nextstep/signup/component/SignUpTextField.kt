package nextstep.signup.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import nextstep.signup.ui.theme.SignupTheme

@Composable
fun SignUpTextField(
    modifier: Modifier = Modifier,
    label: String,
    text: String,
    isError: (String) -> Boolean = { false },
    errorMessage: String? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    onTextChange: (String) -> Unit,
) {
    Column {
        TextField(
            modifier = modifier,
            value = text,
            onValueChange = onTextChange,
            label = { Text(label) },
            isError = isError(text),
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
        )
        val isInValid = isError(text) && errorMessage.isNullOrBlank().not()
        if (isInValid) {
            Text(
                text = errorMessage.orEmpty(),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}

@Preview(name = "onClearFocus")
@Composable
private fun Preview() {
    SignupTheme {
        SignUpTextField(
            label = "ㅎㅇ",
            text = "나 오둥",
            onTextChange = {}
        )
    }
}

@Preview(name = "onFocus")
@Composable
private fun Preview2() {
    SignupTheme {
        SignUpTextField(
            label = "ㅎㅇ",
            text = "나 오둥",
            onTextChange = {}
        )
    }
}

@Preview(name = "onError")
@Composable
private fun Preview3() {
    SignupTheme {
        SignUpTextField(
            label = "ㅎㅇ",
            text = "나 오둥",
            onTextChange = {},
            isError = { true },
        )
    }
}

@Preview(name = "onError + errorMsg")
@Composable
private fun Preview4() {
    SignupTheme {
        SignUpTextField(
            label = "ㅎㅇ",
            text = "나 오둥",
            onTextChange = {},
            errorMessage = "오류가 발생했습니다.",
            isError = { true },
        )
    }
}