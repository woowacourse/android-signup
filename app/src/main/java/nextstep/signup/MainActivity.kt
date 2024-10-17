package nextstep.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import nextstep.signup.auth.screen.SignUpScreen
import nextstep.signup.auth.state.SignUpFormState
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
                val onDoneSignUp = {
                    // TODO : Sign up 버튼을 클릭하면 회원가입 완료/실패 스낵바가 노출된다.
                }
                SignUpScreen(
                    signUpFormState = formState,
                    onUserNameChange = onUserNameChange,
                    onEmailChange = onEmailChange,
                    onPasswordChange = onPasswordChange,
                    onPasswordConfirmChange = onPasswordConfirmChange,
                    onDoneSignUp = onDoneSignUp
                )
            }
        }
    }
}