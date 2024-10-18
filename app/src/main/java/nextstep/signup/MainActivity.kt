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
        SignUpGreeting()
        SignUpInputBox()
        ButtonComponent(description = R.string.main_sign_up)
    }
}

@Composable
private fun SignUpGreeting() {
    TextComponent(description = stringResource(R.string.main_greeting), style = MaterialTheme.typography.titleLarge)
    Spacer(modifier = Modifier.size(42.dp))
}

@Composable
private fun SignUpInputBox() {
    var userName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordConfirm by remember { mutableStateOf("") }

    UserNameComposable(value = userName, onUserNameChange = { userName = it })
    EmailComposable(value = email, onEmailChange = { email = it })
    PasswordComposable(value = password, onPasswordChange = { password = it })
    PasswordConfirmComposable(password = password, value = passwordConfirm, onPasswordConfirmChange = { passwordConfirm = it })
}

@Composable
fun UserNameComposable(
    value: String,
    onUserNameChange: (String) -> Unit,
) {
    val userName = UserName(value)

    TextFieldComponent(
        newValue = value,
        onValueChange = onUserNameChange,
        label = R.string.main_user_name,
        supportingText = {
            val errorMessage = userName.getErrorMessage() ?: return@TextFieldComponent
            TextComponent(description = errorMessage)
        },
        isError = userName.isInvalid(),
    )
    Spacer(modifier = Modifier.size(36.dp))
}

@Composable
fun EmailComposable(
    value: String,
    onEmailChange: (String) -> Unit,
) {
    val email = Email(value)
    TextFieldComponent(
        newValue = value,
        onValueChange = onEmailChange,
        label = R.string.main_email,
        supportingText = {
            val errorMessage = email.getErrorMessage() ?: return@TextFieldComponent
            TextComponent(description = errorMessage)
        },
        isError = email.isValid(),
        keyboardType = KeyboardType.Email,
    )
    Spacer(modifier = Modifier.size(36.dp))
}

@Composable
fun PasswordComposable(
    value: String,
    onPasswordChange: (String) -> Unit,
) {
    val password = Password(value)

    TextFieldComponent(
        newValue = password.password,
        onValueChange = onPasswordChange,
        label = R.string.main_password,
        supportingText = {
            val errorMessage = password.getErrorMessage() ?: return@TextFieldComponent
            TextComponent(description = errorMessage)
        },
        isError = password.isValid(),
        keyboardType = KeyboardType.Password,
    )
    Spacer(modifier = Modifier.size(36.dp))
}

@Composable
fun PasswordConfirmComposable(
    password: String,
    value: String,
    onPasswordConfirmChange: (String) -> Unit,
) {
    val passwordConfirm = PasswordConfirm(password, passwordConfirm = value)

    TextFieldComponent(
        newValue = value,
        onValueChange = onPasswordConfirmChange,
        label = R.string.main_password_confirm,
        supportingText = {
            val errorMessage = passwordConfirm.getErrorMessage() ?: return@TextFieldComponent
            TextComponent(description = errorMessage)
        },
        isError = passwordConfirm.isValid(),
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
