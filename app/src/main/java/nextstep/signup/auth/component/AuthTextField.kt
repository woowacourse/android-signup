package nextstep.signup.auth.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import nextstep.signup.ui.theme.SignupTheme

@Composable
internal fun AuthTextField(
    modifier: Modifier = Modifier,
    label: String,
    text: String,
    isValid: (String) -> Boolean,
    imeAction: ImeAction,
    keyboardType: KeyboardType = KeyboardType.Text,
    onTextChange: (String) -> Unit,
    onNext: () -> Unit = {},
    onDone: () -> Unit = {}
) {
    val focusManager = LocalFocusManager.current
    val visualTransformation =
        if (keyboardType == KeyboardType.Password) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        }

    AuthTextField(
        modifier = modifier,
        label = label,
        text = text,
        isValid = isValid,
        keyboardOptions = KeyboardOptions(
            imeAction = imeAction,
            keyboardType = keyboardType
        ),
        keyboardActions = KeyboardActions(
            onNext = {
                focusManager.moveFocus(FocusDirection.Next)
                onNext()
            },
            onDone = {
                focusManager.clearFocus()
                onDone()
            }
        ),
        visualTransformation = visualTransformation,
        onTextChange = onTextChange
    )
}

@Composable
internal fun AuthTextField(
    modifier: Modifier = Modifier,
    label: String,
    text: String,
    isValid: (String) -> Boolean = { true },
    errorMessage: String? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    onTextChange: (String) -> Unit
) {
    Column {
        TextField(
            modifier = modifier,
            value = text,
            onValueChange = onTextChange,
            label = { Text(label) },
            isError = isValid(text).not(),
            singleLine = true,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions
        )
        val shouldShowErrorMsg = isValid(text).not() && errorMessage.isNullOrBlank().not()
        if (shouldShowErrorMsg) {
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
        AuthTextField(
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
        AuthTextField(
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
        AuthTextField(
            label = "ㅎㅇ",
            text = "나 오둥",
            onTextChange = {},
            isValid = { false }
        )
    }
}

@Preview(name = "onError + errorMsg")
@Composable
private fun Preview4() {
    SignupTheme {
        AuthTextField(
            label = "ㅎㅇ",
            text = "나 오둥",
            onTextChange = {},
            errorMessage = "오류가 발생했습니다.",
            isValid = { false }
        )
    }
}
