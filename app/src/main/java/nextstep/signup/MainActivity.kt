package nextstep.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import nextstep.signup.ui.SignUpButton
import nextstep.signup.ui.SignUpSurfaceColumn
import nextstep.signup.ui.SignUpTextField
import nextstep.signup.ui.SignupTitle
import nextstep.signup.ui.theme.SignupTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var email by remember { mutableStateOf("") }
            var userName by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            var passwordConfirm by remember { mutableStateOf("") }

            SignupTheme {
                SignUpSurfaceColumn {
                    SignupTitle(
                        getString(R.string.welcome_to_compose),
                        Modifier.padding(top = 60.dp),
                    )
                    SignUpTextField(
                        modifier = Modifier.padding(top = 36.dp),
                        hint = getString(R.string.user_name),
                        value = userName,
                    ) {
                        userName = it
                    }
                    SignUpTextField(
                        modifier = Modifier.padding(top = 36.dp),
                        hint = getString(R.string.email),
                        value = email,
                    ) {
                        email = it
                    }
                    SignUpTextField(
                        modifier = Modifier.padding(top = 36.dp),
                        hint = getString(R.string.password),
                        value = password,
                        visualTransformation = PasswordVisualTransformation(),
                    ) {
                        password = it
                    }
                    SignUpTextField(
                        modifier = Modifier.padding(top = 36.dp),
                        hint = getString(R.string.password_confirm),
                        value = passwordConfirm,
                        visualTransformation = PasswordVisualTransformation(),
                    ) {
                        passwordConfirm = it
                    }
                    SignUpButton(
                        Modifier
                            .padding(top = 42.dp),
                        getString(R.string.sign_up),
                    )
                }
            }
        }
    }
}
