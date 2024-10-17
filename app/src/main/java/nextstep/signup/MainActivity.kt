package nextstep.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
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
import kotlinx.coroutines.launch
import nextstep.signup.component.SignUpEmailTextField
import nextstep.signup.component.SignUpPasswordConfirmTextField
import nextstep.signup.component.SignUpPasswordTextField
import nextstep.signup.component.SignUpSubmitButton
import nextstep.signup.component.SignUpTitle
import nextstep.signup.component.SignUpUsernameTextField
import nextstep.signup.domain.validation.Email
import nextstep.signup.domain.validation.Password
import nextstep.signup.domain.validation.PasswordConfirm
import nextstep.signup.domain.validation.SignUpState
import nextstep.signup.domain.validation.Username
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
                    SignUpScreen()
                }
            }
        }
    }
}

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier
) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordConfirm by remember { mutableStateOf("") }
    val signUpState by remember {
        derivedStateOf {
            SignUpState(
                username = Username(username),
                email = Email(email),
                password = Password(password),
                passwordConfirm = PasswordConfirm(password, passwordConfirm)
            )
        }
    }
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    val signupSuccessMessage = stringResource(R.string.success_sign_up)

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { contentPadding ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(contentPadding)
                .padding(start = 32.dp, end = 32.dp, top = 22.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            SignUpTitle(title = stringResource(R.string.sign_up_title))

            SignUpUsernameTextField(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                username = username,
                onUsernameChange = { username = it }
            )

            SignUpEmailTextField(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                email = email,
                onEmailChange = { email = it }
            )

            SignUpPasswordTextField(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                password = password,
                onPasswordChange = { password = it }
            )

            SignUpPasswordConfirmTextField(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                password = password,
                passwordConfirm = passwordConfirm,
                onPasswordConfirmChange = { passwordConfirm = it }
            )


            SignUpSubmitButton(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                text = stringResource(R.string.button_sign_up),
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar(signupSuccessMessage)
                    }
                },
                enabled = signUpState.isValid()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignupTheme {
        SignUpScreen()
    }
}
