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
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import nextstep.signup.auth.component.SignUpConfirmButton
import nextstep.signup.auth.component.SignUpForm
import nextstep.signup.auth.component.SignUpTitle
import nextstep.signup.auth.preview.SignUpPreviewParamsProvider
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
    SignUpScreen(
        signUpFormState = formState,
        onSignUpFormStateChange = onChnageFormState,
        onDoneSignUp = onDoneSignUp
    )
}

@Composable
private fun SignUpScreen(
    signUpFormState: SignUpFormState,
    onSignUpFormStateChange: (SignUpFormState) -> Unit,
    onDoneSignUp: () -> Unit,
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
            SignUpConfirmButton(onDoneSignUp, signUpFormState.enableSignUp)
        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun Preview(
    @PreviewParameter(SignUpPreviewParamsProvider::class) signUpFormState: SignUpFormState
) {
    SignupTheme {
        val (formState, onSignUpFormStateChange) = remember {
            mutableStateOf(signUpFormState)
        }
        SignUpScreen(
            signUpFormState = formState,
            onSignUpFormStateChange = onSignUpFormStateChange,
            onDoneSignUp = {},
        )
    }
}