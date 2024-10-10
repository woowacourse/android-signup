package nextstep.signup.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nextstep.signup.ui.theme.SignupTheme

@Composable
fun SignUpTextField(
    modifier: Modifier = Modifier,
    hint: String,
) {
    val enteredValue = remember { mutableStateOf("") }
    TextField(
        value = enteredValue.value,
        onValueChange = { enteredValue.value = it },
        modifier = modifier.fillMaxWidth(),
        maxLines = 1,
        placeholder = { Text(hint) },
        label = { Text(hint) },
    )
}

@Preview(showBackground = true)
@Composable
fun SignUpTextFieldPreview() {
    SignupTheme {
        SignUpTextField(
            Modifier,
            "미리 보기 텍스트 필드",
        )
    }
}
