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
import nextstep.signup.ui.ButtonComponent
import nextstep.signup.ui.TextComponent
import nextstep.signup.ui.TextFieldComponent
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
        ButtonComponent(R.string.main_sign_up)
    }
}

@Composable
private fun SignUpGreeting() {
    TextComponent(stringResource(R.string.main_greeting))
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
    TextFieldComponent(
        newValue = userName,
        onValueChange = { userName = it },
        label = R.string.main_user_name,
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
