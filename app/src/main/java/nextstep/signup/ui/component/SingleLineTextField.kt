package nextstep.signup.ui.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import nextstep.signup.ui.theme.Blue50
import nextstep.signup.ui.theme.BlueGray20
import nextstep.signup.ui.theme.Gray50
import nextstep.signup.ui.theme.Red

@Composable
fun SingleLineTextField(
    text: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    label: String? = null,
    errorMessage: String? = null,
    keyBoardType: KeyboardType = KeyboardType.Text,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    TextField(
        value = text,
        onValueChange = onTextChange,
        modifier = modifier.fillMaxWidth(),
        colors = TextFieldDefaults.colors(
            focusedLabelColor = Blue50,
            unfocusedLabelColor = Gray50,
            unfocusedContainerColor = BlueGray20,
            focusedContainerColor = BlueGray20,
            focusedIndicatorColor = Blue50,
            unfocusedIndicatorColor = Gray50,
        ),
        isError = isError,
        singleLine = true,
        label = {
            label?.let {
                Text(text = it, fontSize = 16.sp)
            }
        },
        textStyle = TextStyle(
            color = Gray50,
            fontSize = 16.sp,
        ),
        supportingText = {
            errorMessage?.let {
                Text(text = it, fontSize = 12.sp, color = Red)
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyBoardType,
        ),
        visualTransformation = if (keyBoardType == KeyboardType.Password)
            PasswordVisualTransformation() else visualTransformation
    )
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
)
@Composable
private fun SingleLineTextFieldPreview() {
    SingleLineTextField("테스트", {})
}
