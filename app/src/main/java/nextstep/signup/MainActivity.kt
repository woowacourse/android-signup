package nextstep.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import nextstep.signup.ui.SignUpScreen
import nextstep.signup.ui.theme.SignupTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var email by rememberSaveable { mutableStateOf("") }
            var userName by rememberSaveable { mutableStateOf("") }
            var password by rememberSaveable { mutableStateOf("") }
            var passwordConfirm by rememberSaveable { mutableStateOf("") }

            SignupTheme {
                SignUpScreen(
                    userName,
                    { userName = it },
                    email,
                    { email = it },
                    password,
                    { password = it },
                    passwordConfirm,
                    { passwordConfirm = it },
                )
            }
        }
    }
}
