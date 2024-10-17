package nextstep.signup

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import nextstep.signup.ui.component.SignUpToast
import nextstep.signup.ui.component.SubjectComponent
import nextstep.signup.ui.component.SubmitButtonComponent
import nextstep.signup.ui.component.TextFieldComponent
import nextstep.signup.ui.model.ConfirmPassword
import nextstep.signup.ui.model.Email
import nextstep.signup.ui.model.Password
import nextstep.signup.ui.model.Username
import nextstep.signup.ui.theme.SignupTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignupTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SignupScreen()
                }
            }
        }
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SignupScreen() {
    val scope = rememberCoroutineScope()
    val toastVisible = remember { mutableStateOf(false) }

    var userName by remember { mutableStateOf(Username()) }
    var email by remember { mutableStateOf(Email()) }
    var password by remember { mutableStateOf(Password()) }
    var passwordConfirm by remember { mutableStateOf(ConfirmPassword(password = password)) }

    fun confirmSignUp() {
        toastVisible.value = true
        userName = Username()
        email = Email()
        password = Password()
        passwordConfirm = ConfirmPassword(password)
    }
    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(Modifier.height(30.dp))
            SubjectComponent(
                subject = stringResource(R.string.subject),
                emoji = stringResource(R.string.emoji)
            )
            Spacer(Modifier.height(39.dp))
            TextFieldComponent(
                signUpModel = userName,
                onTextChange = { newText ->
                    userName = Username(newText)
                },
                labelText = stringResource(R.string.username_label)
            )
            TextFieldComponent(
                signUpModel = email,
                onTextChange = { newEmail ->
                    email = Email(newEmail)
                },
                labelText = stringResource(R.string.email_label)
            )
            TextFieldComponent(
                signUpModel = password,
                onTextChange = { newPassword ->
                    password = Password(newPassword)
                },
                labelText = stringResource(R.string.password_label),
                isPassword = true
            )
            TextFieldComponent(
                signUpModel = passwordConfirm,
                onTextChange = { newPasswordConfirm ->
                    passwordConfirm = ConfirmPassword(password, newPasswordConfirm)
                },
                labelText = stringResource(R.string.password_confirm_label),
                isPassword = true
            )
            Spacer(Modifier.height(24.dp))
            SubmitButtonComponent(
                signUpStates = listOf(
                    userName.validState(),
                    email.validState(),
                    password.validState(),
                    passwordConfirm.validState(),
                ),
                buttonText = stringResource(R.string.sign_up_button_label),
                onButtonClick = { confirmSignUp() }
            )
        }

        if (toastVisible.value) {
            SignUpToast(stringResource(R.string.confirm_sign_up))
            scope.launch {
                delay(2000)
                toastVisible.value = false
            }
        }
    }
}

@Preview(
    backgroundColor = 0xFFFFFFFF,
    showBackground = true
)
@Composable
fun PreviewSignupView() {
    SignupScreen()
}
