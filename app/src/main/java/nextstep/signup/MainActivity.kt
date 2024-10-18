package nextstep.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import kotlinx.coroutines.launch
import nextstep.signup.ui.auth.model.SignUpFormState
import nextstep.signup.ui.auth.screen.SignUpScreen
import nextstep.signup.ui.theme.SignupTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignupTheme {
                var formState by rememberSaveable {
                    mutableStateOf(SignUpFormState("", "", "", ""))
                }
                val onSignUpFormStateChange: (SignUpFormState) -> Unit = { new: SignUpFormState ->
                    formState = new
                }
                val onEmailChange = { newEmail: String ->
                    onSignUpFormStateChange(formState.copy(email = newEmail))
                }
                val onUserNameChange = { newUserName: String ->
                    onSignUpFormStateChange(formState.copy(userName = newUserName))
                }
                val onPasswordChange = { newPassword: String ->
                    onSignUpFormStateChange(formState.copy(password = newPassword))
                }
                val onPasswordConfirmChange = { newPasswordConfirm: String ->
                    onSignUpFormStateChange(formState.copy(passwordConfirm = newPasswordConfirm))
                }
                val enableSignUp by remember {
                    derivedStateOf {
                        formState.enableSignUp
                    }
                }
                val snackbarHostState = SnackbarHostState()
                val coroutineScope = rememberCoroutineScope()
                Scaffold(
                    snackbarHost = { SnackbarHost(snackbarHostState) }
                ) { innerPadding ->
                    val completeMessage = stringResource(id = R.string.sign_up_success)
                    val onDone: () -> Unit = remember {
                        {
                            coroutineScope.launch {
                                snackbarHostState.showSnackbar(completeMessage)
                            }
                        }
                    }
                    SignUpScreen(
                        modifier = Modifier.padding(innerPadding),
                        signUpFormState = formState,
                        onUserNameChange = onUserNameChange,
                        onEmailChange = onEmailChange,
                        onPasswordChange = onPasswordChange,
                        onPasswordConfirmChange = onPasswordConfirmChange,
                        enableSignUp = enableSignUp,
                        onDoneSignUp = onDone
                    )
                }
            }
        }
    }
}