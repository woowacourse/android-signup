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
import nextstep.signup.model.Email
import nextstep.signup.model.Password
import nextstep.signup.model.PasswordConfirm
import nextstep.signup.model.UserName
import nextstep.signup.ui.component.InputText
import nextstep.signup.ui.component.TextButton
import nextstep.signup.ui.component.TitleText
import nextstep.signup.ui.theme.SignupTheme

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

        var userName: UserName by remember { mutableStateOf(UserName("")) }
        var email: Email by remember { mutableStateOf(Email("")) }
        var password: Password by remember { mutableStateOf(Password("")) }
        var passwordConfirm: PasswordConfirm by remember {
            mutableStateOf(
                PasswordConfirm(
                    content = "",
                    password = password.content,
                ),
            )
        }
        val isValid = listOf(userName, email, password, passwordConfirm).all { it.isValid() }

        InputText(
            R.string.sign_up_user_name_title,
            userName.content,
            { userName = userName.copy(content = it) },
            userName,
        )
        InputText(
            R.string.sign_up_email_title,
            email.content,
            { email = email.copy(content = it) },
            email,
        )
        InputText(
            R.string.sign_up_password_title,
            password.content,
            {
                password = password.copy(content = it)
                passwordConfirm = passwordConfirm.copy(password = it)
            },
            password,
            KeyboardType.Password,
            PasswordVisualTransformation(),
        )
        InputText(
            R.string.sign_up_password_confirm_title,
            passwordConfirm.content,
            { passwordConfirm = passwordConfirm.copy(content = it) },
            passwordConfirm,
            KeyboardType.Password,
            PasswordVisualTransformation(),
        )

        TextButton(R.string.sign_up_button_title, isValid)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SignUpPreview() {
    SignupTheme {
        SignUpComponent()
    }
}
