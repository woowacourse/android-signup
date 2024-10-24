package nextstep.signup.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.signup.model.Email
import nextstep.signup.model.Password
import nextstep.signup.model.PasswordConfirm
import nextstep.signup.model.User
import nextstep.signup.model.UserName
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
private fun SignUpScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        var user by remember {
            mutableStateOf(
                User(
                    UserName(""),
                    Email(""),
                    Password(""),
                    PasswordConfirm(""),
                ),
            )
        }

        SignUpTitleComposable()
        SignUpInputBox(
            user = user,
            onUserNameChange = { newUserName ->
                user = user.copy(userName = user.userName.copy(userName = newUserName))
            },
            onEmailChange = { newEmail ->
                user = user.copy(email = user.email.copy(email = newEmail))
            },
            onPasswordChange = { newPassword ->
                user = user.copy(password = user.password.copy(password = newPassword))
            },
            onPasswordConfirmChange = { newPasswordConfirm ->
                user = user.copy(passwordConfirm = user.passwordConfirm.copy(passwordConfirm = newPasswordConfirm))
            },
        )
        SignUpButtonComposable(user.isAbleToSubmit())
    }
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

@Preview(showBackground = true)
@Composable
private fun GreetingPreview() {
    SignupTheme {
        SignUpScreen()
    }
}
