package woowacourse.signup.ui.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.signup.R
import woowacourse.signup.ui.component.SignupButton
import woowacourse.signup.ui.component.SignupTextField
import woowacourse.signup.ui.theme.SignupTheme
import woowacourse.signup.ui.theme.Typography

@Composable
fun SignupScreen() {
    var userName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordConfirm by remember { mutableStateOf("") }

    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp),
    ) {
        Text(
            text = stringResource(id = R.string.sign_up_title),
            style = Typography.titleLarge,
            modifier =
                Modifier
                    .padding(top = 60.dp, bottom = 14.dp)
                    .fillMaxWidth(),
        )
        SignupTextField(
            modifier = Modifier.padding(top = 16.dp),
            labelText = stringResource(id = R.string.username_input),
            inputValue = userName,
            isError = false,
            errorText = "",
        ) {
            userName = it
        }
        SignupTextField(
            modifier = Modifier.padding(top = 16.dp),
            labelText = stringResource(id = R.string.email_input),
            inputValue = email,
            isError = false,
            errorText = "",
        ) {
            email = it
        }
        SignupTextField(
            modifier = Modifier.padding(top = 16.dp),
            labelText = stringResource(id = R.string.password_input),
            inputValue = password,
            visualTransformation = PasswordVisualTransformation(),
            isError = false,
            errorText = "",
        ) {
            password = it
        }
        SignupTextField(
            modifier = Modifier.padding(top = 16.dp),
            labelText = stringResource(id = R.string.password_confirm_input),
            inputValue = passwordConfirm,
            visualTransformation = PasswordVisualTransformation(),
            isError = false,
            errorText = "",
        ) {
            passwordConfirm = it
        }
        SignupButton(
            modifier = Modifier.padding(32.dp),
            text = stringResource(id = R.string.sign_up_button),
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
