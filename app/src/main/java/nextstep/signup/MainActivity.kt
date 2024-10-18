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
import androidx.compose.material3.TextField
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
    UserNameComposable()
    EmailComposable()
    PasswordComposable()
    PasswordConfirmComposable()
}

@Composable
private fun UserNameComposable() {
    var userName by remember { mutableStateOf("") }
    val isBlank = userName.isBlank()
    val isInvalidLength = userName.length !in USERNAME_MIN_LENGTH..USERNAME_MAX_LENGTH
    val hasInvalidCharacter = userName.matches(regex = Regex(USERNAME_REGEX)).not()
    val isError = isBlank.not() && (isInvalidLength || hasInvalidCharacter)

    TextFieldComponent(
        newValue = userName,
        onValueChange = { userName = it },
        label = R.string.main_user_name,
        supportingText = {
            when {
                isBlank -> return@TextFieldComponent
                isInvalidLength -> {
                    TextComponent(
                        description = "이름은 2~5자여야 합니다.",
                    )
                }
                hasInvalidCharacter -> {
                    TextComponent(
                        description = "이름에는 숫자나 기호가 포함될 수 없습니다.",
                    )
                }
            }
        },
        isError = isError,
    )
    Spacer(modifier = Modifier.size(36.dp))
}

@Composable
private fun EmailComposable() {
    var email by remember { mutableStateOf("") }
    TextFieldComponent(
        newValue = email,
        onValueChange = { email = it },
        label = R.string.main_email,
        supportingText = {},
        keyboardType = KeyboardType.Email,
    )
    Spacer(modifier = Modifier.size(36.dp))
}

@Composable
private fun PasswordComposable() {
    var password by remember { mutableStateOf("") }
    TextFieldComponent(
        newValue = password,
        onValueChange = { password = it },
        label = R.string.main_password,
        supportingText = {},
        keyboardType = KeyboardType.Password,
    )
    Spacer(modifier = Modifier.size(36.dp))
}

@Composable
private fun PasswordConfirmComposable() {
    var passwordConfirm by remember { mutableStateOf("") }
    TextFieldComponent(
        newValue = passwordConfirm,
        onValueChange = { passwordConfirm = it },
        label = R.string.main_password_confirm,
        supportingText = {},
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

const val USERNAME_REGEX = "^[a-zA-Z가-힣]+$"
const val EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
const val PASSWORD_REGEX = "^(?=.*[a-zA-Z])(?=.*[0-9]).{8,16}$"
const val USERNAME_MIN_LENGTH = 2
const val USERNAME_MAX_LENGTH = 5
