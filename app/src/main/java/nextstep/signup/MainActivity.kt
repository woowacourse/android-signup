package nextstep.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.signup.model.Email
import nextstep.signup.model.Password
import nextstep.signup.model.PasswordConfirm
import nextstep.signup.model.UserInformation
import nextstep.signup.model.UserName
import nextstep.signup.ui.component.ButtonComponent
import nextstep.signup.ui.component.TextComponent
import nextstep.signup.ui.component.TextFieldComponent
import nextstep.signup.ui.theme.SignupTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SignupTheme {
                Surface(
                    modifier =
                        Modifier
                            .fillMaxSize()
                            .padding(top = 56.dp, start = 32.dp, end = 32.dp),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    SignUpScreen()
                }
            }
        }
    }
}

@Composable
fun SignUpScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        var userName by remember { mutableStateOf(UserName("")) }
        var email by remember { mutableStateOf(Email("")) }
        var password by remember { mutableStateOf(Password("")) }
        var passwordConfirm by remember { mutableStateOf(PasswordConfirm("")) }

        val userInformation = UserInformation(userName, email, password, passwordConfirm)
        val isSubmitButtonEnabled =
            userName.isValid() && email.isValid() && password.isValid() && passwordConfirm.isMatch(password.password)

        SignUpGreeting()
        SignUpInputBox(
            userInformation,
            onUserNameChange = { userName = userName.copy(userName = it) },
            onEmailChange = { email = email.copy(email = it) },
            onPasswordChange = { password = password.copy(password = it) },
            onPasswordConfirmChange = { passwordConfirm = passwordConfirm.copy(passwordConfirm = it) },
        )
        ButtonComponent(enabled = isSubmitButtonEnabled, description = R.string.main_sign_up)
    }
}

@Composable
private fun SignUpGreeting() {
    TextComponent(description = stringResource(R.string.main_greeting), style = MaterialTheme.typography.titleLarge)
    Spacer(modifier = Modifier.size(42.dp))
}

@Composable
private fun SignUpInputBox(
    userInformation: UserInformation,
    onUserNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onPasswordConfirmChange: (String) -> Unit,
) {
    UserNameComposable(userName = userInformation.userName, onUserNameChange)
    EmailComposable(email = userInformation.email, onEmailChange)
    PasswordComposable(password = userInformation.password, onPasswordChange)
    PasswordConfirmComposable(
        password = userInformation.password,
        passwordConfirm = userInformation.passwordConfirm,
        onPasswordConfirmChange,
    )
}

@Composable
fun UserNameComposable(
    userName: UserName,
    onUserNameChange: (String) -> Unit,
) {
    TextFieldComponent(
        newValue = userName.userName,
        onValueChange = onUserNameChange,
        label = R.string.main_user_name,
        supportingText = {
            val errorMessage = userName.getErrorMessage() ?: return@TextFieldComponent
            TextComponent(description = errorMessage)
        },
        isError = userName.isError(),
    )
    Spacer(modifier = Modifier.size(36.dp))
}

@Composable
fun EmailComposable(
    email: Email,
    onEmailChange: (String) -> Unit,
) {
    TextFieldComponent(
        newValue = email.email,
        onValueChange = onEmailChange,
        label = R.string.main_email,
        supportingText = {
            val errorMessage = email.getErrorMessage() ?: return@TextFieldComponent
            TextComponent(description = errorMessage)
        },
        isError = email.isError(),
        keyboardType = KeyboardType.Email,
    )
    Spacer(modifier = Modifier.size(36.dp))
}

@Composable
fun PasswordComposable(
    password: Password,
    onPasswordChange: (String) -> Unit,
) {
    TextFieldComponent(
        newValue = password.password,
        onValueChange = onPasswordChange,
        label = R.string.main_password,
        supportingText = {
            val errorMessage = password.getErrorMessage() ?: return@TextFieldComponent
            TextComponent(description = errorMessage)
        },
        isError = password.isError(),
        keyboardType = KeyboardType.Password,
    )
    Spacer(modifier = Modifier.size(36.dp))
}

@Composable
fun PasswordConfirmComposable(
    password: Password,
    passwordConfirm: PasswordConfirm,
    onPasswordConfirmChange: (String) -> Unit,
) {
    TextFieldComponent(
        newValue = passwordConfirm.passwordConfirm,
        onValueChange = onPasswordConfirmChange,
        label = R.string.main_password_confirm,
        supportingText = {
            val errorMessage = passwordConfirm.getErrorMessage(password.password) ?: return@TextFieldComponent
            TextComponent(description = errorMessage)
        },
        isError = passwordConfirm.isError(password.password),
        keyboardType = KeyboardType.Password,
    )
    Spacer(modifier = Modifier.size(42.dp))
}

@Preview(showBackground = true)
@Composable
private fun GreetingPreview() {
    SignupTheme {
        SignUpScreen()
    }
}
