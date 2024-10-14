package nextstep.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import nextstep.signup.ui.component.InputText
import nextstep.signup.ui.component.TextButton
import nextstep.signup.ui.component.TitleText
import nextstep.signup.ui.theme.SignupTheme
import nextstep.signup.ui.validateEmail
import nextstep.signup.ui.validatePassword
import nextstep.signup.ui.validatePasswordConfirm
import nextstep.signup.ui.validateUserName

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignupTheme(dynamicColor = false) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    SignUpComponent()
                }
            }
        }
    }
}

@Composable
fun SignUpComponent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        TitleText(R.string.sign_up_title)

        var userName: String by remember { mutableStateOf("") }
        var email: String by remember { mutableStateOf("") }
        var password: String by remember { mutableStateOf("") }
        var passwordConfirm: String by remember { mutableStateOf("") }

        InputText(
            R.string.sign_up_user_name_title,
            userName,
            { userName = it },
            { it.validateUserName() },
        )
        InputText(
            R.string.sign_up_email_title,
            email,
            { email = it },
            { it.validateEmail() },
            KeyboardType.Email,
        )
        InputText(
            R.string.sign_up_password_title,
            password,
            { password = it },
            { it.validatePassword() },
            KeyboardType.Password,
            PasswordVisualTransformation(),
        )
        InputText(
            R.string.sign_up_password_confirm_title,
            passwordConfirm,
            { passwordConfirm = it },
            { it.validatePasswordConfirm(password) },
            KeyboardType.Password,
            PasswordVisualTransformation(),
        )

        TextButton(R.string.sign_up_button_title)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SignUpPreview() {
    SignupTheme {
        SignUpComponent()
    }
}
