package woowacourse.signup.ui.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import woowacourse.signup.R
import woowacourse.signup.ui.theme.Typography
import woowacourse.signup.ui.theme.Blue50
import woowacourse.signup.ui.theme.SignupTheme

@Composable
fun SignupScreen() {
    var userName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordConfirm by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = stringResource(id = R.string.sign_up_title),
            style = Typography.titleLarge,
            modifier = Modifier
                .padding(top = 60.dp)
                .fillMaxWidth()
        )
        SignUpTextField(
            modifier = Modifier.padding(top = 18.dp),
            labelText = stringResource(id = R.string.username_input),
            inputText = userName,
        ) {
            userName = it
        }
        SignUpTextField(
            labelText = stringResource(id = R.string.email_input),
            inputText = email,
        ) {
            email = it
        }
        SignUpTextField(
            labelText = stringResource(id = R.string.password_input),
            inputText = password,
            visualTransformation = PasswordVisualTransformation(),
        ) {
            password = it
        }
        SignUpTextField(
            modifier = Modifier.padding(bottom = 24.dp),
            labelText = stringResource(id = R.string.password_confirm_input),
            inputText = passwordConfirm,
            visualTransformation = PasswordVisualTransformation(),
        ) {
            passwordConfirm = it
        }
        SignUpButton(
            text = stringResource(id = R.string.sign_up_button),
        )
    }
}

@Composable
private fun SignUpTextField(
    modifier: Modifier = Modifier,
    labelText: String,
    inputText: String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onValueChange: (String) -> Unit,
) {
    TextField(
        label = {
            Text(
                text = labelText,
                fontWeight = FontWeight.W400,
            )
        },
        value = inputText,
        onValueChange = onValueChange,
        textStyle = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.W400,
        ),
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Blue50,
            focusedLabelColor = Blue50,
            cursorColor = Blue50,
        ),
        visualTransformation = visualTransformation,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp, vertical = 18.dp),
    )
}

@Composable
private fun SignUpButton(
    text: String,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = {
            // TODO
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Blue50,
        ),
        modifier =
        modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
    ) {
        Text(
            text = text,
            fontSize = 14.sp,
            fontWeight = FontWeight.W500,
            modifier = Modifier.padding(vertical = 15.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MainActivityPreview() {
    SignupTheme {
        SignupScreen()
    }
}
