package nextstep.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import nextstep.signup.auth.screen.SignUpScreen
import nextstep.signup.auth.state.SignUpFormState
import nextstep.signup.ui.theme.SignupTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignupTheme {
                // TODO: rememberSaveable 을 사용하여 회원가입 폼 상태를 저장한다.
                val (formState, onChnageFormState) = remember {
                    mutableStateOf(SignUpFormState("", "", "", ""))
                }
                val onDoneSignUp = {
                    // TODO : Sign up 버튼을 클릭하면 회원가입 완료/실패 스낵바가 노출된다.
                }
                SignUpScreen(
                    signUpFormState = formState,
                    onSignUpFormStateChange = onChnageFormState,
                    onDoneSignUp = onDoneSignUp
                )
            }
        }
    }
}