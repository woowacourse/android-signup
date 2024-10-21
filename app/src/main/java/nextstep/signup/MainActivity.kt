package nextstep.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch
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
                val snackbarHostState = remember { SnackbarHostState() }
                val coroutineScope = rememberCoroutineScope()
                val snackBarEvent: (String) -> Unit = { message ->
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar(
                            message = message,
                            duration = SnackbarDuration.Short,
                        )
                    }
                }
                Scaffold(
                    snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
                ) { paddingValues ->
                    SignUpComponent(
                        modifier =
                            Modifier
                                .fillMaxSize()
                                .padding(paddingValues),
                        snackBarEvent = snackBarEvent,
                    )
                }
            }
        }
    }
}

@Composable
fun SignUpComponent(
    modifier: Modifier = Modifier,
    snackBarEvent: (String) -> Unit = {},
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
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

        TitleText(stringResource(R.string.sign_up_title))

        InputText(
            title = R.string.sign_up_user_name_title,
            content = userName.content,
            onContentChange = { userName = userName.copy(content = it) },
            inputValidator = userName,
        )
        InputText(
            title = R.string.sign_up_email_title,
            content = email.content,
            onContentChange = { email = email.copy(content = it) },
            inputValidator = email,
        )
        InputText(
            title = R.string.sign_up_password_title,
            content = password.content,
            onContentChange = {
                password = password.copy(content = it)
                passwordConfirm = passwordConfirm.copy(password = it)
            },
            inputValidator = password,
            keyBoardType = KeyboardType.Password,
            visualTransformation = PasswordVisualTransformation(),
        )
        InputText(
            title = R.string.sign_up_password_confirm_title,
            content = passwordConfirm.content,
            onContentChange = { passwordConfirm = passwordConfirm.copy(content = it) },
            inputValidator = passwordConfirm,
            keyBoardType = KeyboardType.Password,
            visualTransformation = PasswordVisualTransformation(),
        )

        val message = stringResource(R.string.sign_up_complete_message)
        TextButton(R.string.sign_up_button_title, isValid, { snackBarEvent(message) })
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SignUpPreview() {
    SignupTheme {
        SignUpComponent(Modifier.fillMaxSize())
    }
}
