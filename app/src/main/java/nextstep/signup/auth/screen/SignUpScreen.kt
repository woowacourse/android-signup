package nextstep.signup.auth.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.signup.auth.component.SignUpConfirmButton
import nextstep.signup.auth.component.SignUpForm
import nextstep.signup.auth.component.SignUpTitle
import nextstep.signup.auth.state.SignUpFormState
import nextstep.signup.ui.interaction.clearFocusWith
import nextstep.signup.ui.theme.SignupTheme

@Composable
fun SignUpScreen() {
    // TODO: rememberSaveable 을 사용하여 회원가입 폼 상태를 저장한다.
    val (formState, onChnageFormState) = remember {
        mutableStateOf(SignUpFormState("", "", "", ""))
    }
    val onDoneSignUp = {
        // TODO : Sign up 버튼을 클릭하면 회원가입 완료/실패 스낵바가 노출된다.
    }
    // TODO: 회원가입 버튼 활성화 조건
    val enableSignUp: Boolean = formState.userName.isNotEmpty() &&
            formState.email.isNotEmpty() &&
            formState.password.isNotEmpty() &&
            formState.confirmPassword.isNotEmpty()
    SignUpScreen(
        signUpFormState = formState,
        onSignUpFormStateChange = onChnageFormState,
        onDoneSignUp = onDoneSignUp,
        enableSignUp = enableSignUp
    )
}

@Composable
private fun SignUpScreen(
    signUpFormState: SignUpFormState,
    onSignUpFormStateChange: (SignUpFormState) -> Unit,
    onDoneSignUp: () -> Unit,
    enableSignUp: Boolean,
) {
    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clearFocusWith(LocalFocusManager.current)
                .padding(top = 50.dp)
                .padding(horizontal = 36.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SignUpTitle()
            Spacer(modifier = Modifier.padding(25.dp))
            SignUpForm(signUpFormState, onSignUpFormStateChange, onDoneSignUp)
            Spacer(modifier = Modifier.padding(16.dp))
            SignUpConfirmButton(onDoneSignUp, enableSignUp)
        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun Preview() {
    SignupTheme {
        SignUpScreen(
            signUpFormState = SignUpFormState("1", "2", "3", "4"),
            onSignUpFormStateChange = {},
            onDoneSignUp = {},
            enableSignUp = true,
        )
    }
}