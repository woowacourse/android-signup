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
import nextstep.signup.model.EmailValidResult
import nextstep.signup.model.Password
import nextstep.signup.model.PasswordConfirm
import nextstep.signup.model.PasswordValidResult
import nextstep.signup.model.User
import nextstep.signup.model.UserName
import nextstep.signup.model.UserNameValidResult
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
                    color = MaterialTheme.colorScheme.surface,
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

        val user = User(userName, email, password, passwordConfirm)

        SignUpTitle()
        SignUpInputBox(
            user,
            onUserNameChange = { userName = userName.copy(userName = it) },
            onEmailChange = { email = email.copy(email = it) },
            onPasswordChange = { password = password.copy(password = it) },
            onPasswordConfirmChange = { passwordConfirm = passwordConfirm.copy(passwordConfirm = it) },
        )
        ButtonComponent(enabled = user.isAbleToSubmit(), description = stringResource(id = R.string.main_sign_up))
    }
}

@Composable
private fun SignUpTitle() {
    TextComponent(description = stringResource(R.string.main_greeting), style = MaterialTheme.typography.titleLarge)
    Spacer(modifier = Modifier.size(42.dp))
}

@Composable
private fun SignUpInputBox(
    user: User,
    onUserNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onPasswordConfirmChange: (String) -> Unit,
) {
    UserNameComposable(userName = user.userName, onUserNameChange)
    EmailComposable(email = user.email, onEmailChange)
    PasswordComposable(password = user.password, onPasswordChange)
    PasswordConfirmComposable(
        password = user.password,
        passwordConfirm = user.passwordConfirm,
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
        label = stringResource(R.string.main_user_name),
        supportingText = {
            val errorMessage = userName.getErrorMessage() ?: return@TextFieldComponent
            TextComponent(description = errorMessage)
        },
        isError = userName.isError(),
    )
    Spacer(modifier = Modifier.size(36.dp))
}

private fun UserName.getErrorMessage(): String? =
    when (this.validate()) {
        UserNameValidResult.Blank -> null
        UserNameValidResult.InvalidLength -> USERNAME_LENGTH_ERROR
        UserNameValidResult.InvalidCharacter -> USERNAME_FORM_ERROR
        else -> null
    }

@Composable
fun EmailComposable(
    email: Email,
    onEmailChange: (String) -> Unit,
) {
    TextFieldComponent(
        newValue = email.email,
        onValueChange = onEmailChange,
        label = stringResource(R.string.main_email),
        supportingText = {
            val errorMessage = email.getErrorMessage() ?: return@TextFieldComponent
            TextComponent(description = errorMessage)
        },
        isError = email.isError(),
        keyboardType = KeyboardType.Email,
    )
    Spacer(modifier = Modifier.size(36.dp))
}

private fun Email.getErrorMessage(): String? =
    when (this.validate()) {
        EmailValidResult.Blank -> null
        EmailValidResult.InvalidForm -> EMAIL_FORM_ERROR
        else -> null
    }

@Composable
fun PasswordComposable(
    password: Password,
    onPasswordChange: (String) -> Unit,
) {
    TextFieldComponent(
        newValue = password.password,
        onValueChange = onPasswordChange,
        label = stringResource(R.string.main_password),
        supportingText = {
            val errorMessage = password.getErrorMessage() ?: return@TextFieldComponent
            TextComponent(description = errorMessage)
        },
        isError = password.isError(),
        keyboardType = KeyboardType.Password,
    )
    Spacer(modifier = Modifier.size(36.dp))
}

private fun Password.getErrorMessage(): String? =
    when (this.validate()) {
        PasswordValidResult.Blank -> null
        PasswordValidResult.InvalidLength -> PASSWORD_LENGTH_ERROR
        PasswordValidResult.InvalidCharacter -> PASSWORD_FORM_ERROR
        else -> null
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
        label = stringResource(R.string.main_password_confirm),
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

private const val USERNAME_LENGTH_ERROR = "이름은 2~5자여야 합니다."
private const val USERNAME_FORM_ERROR = "이름에는 숫자나 기호가 포함될 수 없습니다."
private const val EMAIL_FORM_ERROR = "이메일 형식이 올바르지 않습니다."
private const val PASSWORD_LENGTH_ERROR = "비밀번호는 8~16자여야 합니다."
private const val PASSWORD_FORM_ERROR = "비밀번호는 영문과 숫자를 포함해야 합니다."
