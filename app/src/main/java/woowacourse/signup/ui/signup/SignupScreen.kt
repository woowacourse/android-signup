package woowacourse.signup.ui.signup

import android.util.Log
import androidx.annotation.StringRes
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
import woowacourse.signup.ui.signup.model.EmailUiModel
import woowacourse.signup.ui.signup.model.PasswordConfirmUiModel
import woowacourse.signup.ui.signup.model.PasswordUiModel
import woowacourse.signup.ui.signup.model.UserNameUiModel
import woowacourse.signup.ui.theme.SignupTheme
import woowacourse.signup.ui.theme.Typography

@Composable
fun SignupScreen() {
    var userName by remember { mutableStateOf(UserNameUiModel()) }
    var email by remember { mutableStateOf(EmailUiModel()) }
    var password by remember { mutableStateOf(PasswordUiModel()) }
    var passwordConfirm by remember { mutableStateOf(PasswordConfirmUiModel()) }

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
            inputValue = userName.value,
            isError = userName.isError(),
            errorText = errorText(userName.errorMessage()),
        ) {
            userName = UserNameUiModel(it)
        }
        SignupTextField(
            modifier = Modifier.padding(top = 16.dp),
            labelText = stringResource(id = R.string.email_input),
            inputValue = email.value,
            isError = email.isError(),
            errorText = errorText(email.errorMessage().also { Log.e("TEST", "$it")}),
        ) {
            email = EmailUiModel(it)
        }
        SignupTextField(
            modifier = Modifier.padding(top = 16.dp),
            labelText = stringResource(id = R.string.password_input),
            inputValue = password.value,
            isError = password.isError(),
            errorText = errorText(password.errorMessage()),
            visualTransformation = PasswordVisualTransformation(),
        ) {
            password = PasswordUiModel(it)
        }
        SignupTextField(
            modifier = Modifier.padding(top = 16.dp),
            labelText = stringResource(id = R.string.password_confirm_input),
            inputValue = passwordConfirm.value,
            visualTransformation = PasswordVisualTransformation(),
            isError = passwordConfirm.isError(password),
            errorText = errorText(passwordConfirm.errorMessage(password))
        ) {
            passwordConfirm = PasswordConfirmUiModel(it)
        }
        SignupButton(
            modifier = Modifier.padding(32.dp),
            text = stringResource(id = R.string.sign_up_button),
        )
    }
}

@Composable
private fun errorText(@StringRes stringResId: Int?): String {
    return if (stringResId == null) "" else stringResource(id = stringResId)
}

@Preview(showBackground = true)
@Composable
private fun MainActivityPreview() {
    SignupTheme {
        SignupScreen()
    }
}
