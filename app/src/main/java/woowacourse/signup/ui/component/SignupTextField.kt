package woowacourse.signup.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import woowacourse.signup.ui.theme.Blue50
import woowacourse.signup.ui.theme.Red
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
                    focusedIndicatorColor = Blue50,
                    focusedLabelColor = Blue50,
                    cursorColor = Blue50,
                ),
            isError = isError,
            visualTransformation = visualTransformation,
            modifier = modifier.fillMaxWidth(),
        )
        if (isError) {
            Text(
                text = errorText,
                style = Typography.bodySmall,
                color = Red,
                modifier =
                    Modifier.padding(top = 4.dp, start = 16.dp),
            )
        } else {
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SignupTextFieldPreview() {
    SignupTheme {
        SignupTextField(
            labelText = "라벨",
            inputValue = "",
            isError = true,
            errorText = "에러메시지",
            onValueChange = {},
        )
    }
}
