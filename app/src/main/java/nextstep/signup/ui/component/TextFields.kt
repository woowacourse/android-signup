package nextstep.signup.ui.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.signup.R
import nextstep.signup.ui.ValidationResult
import nextstep.signup.ui.ValidationResult.Companion.DEFAULT_RESULT
import nextstep.signup.ui.theme.BlueGrey20

@Composable
fun InputText(
    @StringRes title: Int,
    content: String,
    onContentChange: (String) -> Unit,
    validate: (String) -> ValidationResult = { DEFAULT_RESULT },
    keyBoardType: KeyboardType = KeyboardType.Text,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    val (isError, errorMessage) = if (content.isNotEmpty()) validate(content) else DEFAULT_RESULT
    TextField(
        value = content,
        label = { Text(text = stringResource(title)) },
        onValueChange = onContentChange,
        keyboardOptions = KeyboardOptions(keyboardType = keyBoardType, imeAction = ImeAction.Done),
        visualTransformation = visualTransformation,
        colors =
            TextFieldDefaults.colors(
                unfocusedContainerColor = BlueGrey20,
                focusedContainerColor = BlueGrey20,
            ),
        isError = isError,
        supportingText = { errorMessage?.let { Text(it) } },
    )
    Spacer(Modifier.height(36.dp))
}

@Preview(showBackground = true)
@Composable
private fun InputTextPreview() {
    var userName: String by remember { mutableStateOf("") }
    InputText(R.string.sign_up_user_name_title, userName, { userName = it })
}
