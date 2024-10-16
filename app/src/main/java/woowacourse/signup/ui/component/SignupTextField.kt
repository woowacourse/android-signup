package woowacourse.signup.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import woowacourse.signup.ui.theme.Blue50
import woowacourse.signup.ui.theme.SignupTheme
import woowacourse.signup.ui.theme.Typography

@Composable
fun SignupTextField(
    modifier: Modifier = Modifier,
    labelText: String,
    inputValue: String,
    isError: Boolean,
    errorText: String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onValueChange: (String) -> Unit,
) {
    val textFieldColor = if (isError) Color.Red else Blue50
    val supportingText = if (inputValue.isBlank()) "" else errorText
    Column {
        TextField(
            label = {
                Text(
                    text = labelText,
                    fontWeight = FontWeight.W400,
                )
            },
            value = inputValue,
            onValueChange = onValueChange,
            textStyle =
            TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.W400,
            ),
            singleLine = true,
            colors =
            TextFieldDefaults.colors(
                focusedIndicatorColor = textFieldColor,
                focusedLabelColor = textFieldColor,
                cursorColor = textFieldColor,
            ),
            visualTransformation = visualTransformation,
            supportingText = {
                Text(
                    text = supportingText,
                    style = Typography.bodySmall,
                    color = Color.Red,
                )
            },
            modifier = modifier.fillMaxWidth(),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SignupTextFieldPreview() {
    SignupTheme {
        SignupTextField(
            labelText = "라벨",
            inputValue = "하이루",
            isError = true,
            errorText = "에러메시지",
            onValueChange = {},
        )
    }
}
