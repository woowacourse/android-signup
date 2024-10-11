package nextstep.signup.auth.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import nextstep.signup.auth.component.AuthTextField
import nextstep.signup.auth.state.SignUpFormState
import nextstep.signup.preview.BackgroundPreview
import nextstep.signup.ui.interaction.clearFocusWith
import nextstep.signup.ui.theme.SignupTheme

@Composable
fun SignUpScreen() {
    // TODO: rememberSaveable 을 사용하여 회원가입 폼 상태를 저장한다.
    val (formState, onChnageFormState) = remember {
        mutableStateOf(SignUpFormState("", "", "", ""))
    }
    val onClickSignUp = {
        // TODO : Sign up 버튼을 클릭하면 회원가입 완료 스낵바가 노출된다.
    }
    // TODO: 회원가입 버튼 활성화 조건
    val enableSignUp: Boolean = formState.userName.isNotEmpty() &&
            formState.email.isNotEmpty() &&
            formState.password.isNotEmpty() &&
            formState.confirmPassword.isNotEmpty()

    SignUpScreen(
        signUpFormState = formState,
        onSignUpFormStateChange = onChnageFormState,
        onClickSignUp = onClickSignUp,
        enableSignUp = enableSignUp
    )
}

@Composable
private fun SignUpScreen(
    signUpFormState: SignUpFormState,
    onSignUpFormStateChange: (SignUpFormState) -> Unit,
    onClickSignUp: () -> Unit,
    enableSignUp: Boolean,
) {
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
        SignUpForm(signUpFormState, onSignUpFormStateChange)
        Spacer(modifier = Modifier.padding(16.dp))
        SignUpConfirmButton(onClickSignUp, enableSignUp)
    }
}

@Composable
private fun SignUpForm(
    signUpFormState: SignUpFormState,
    onSignUpFormStateChange: (SignUpFormState) -> Unit
) {
    AuthTextField(
        label = "UserName",
        text = signUpFormState.userName,
        isError = {
            // TODO: 이름은 2~5자여야 합니다.
            // TODO: 이름에는 숫자나 기호가 포함될 수 없습니다
            false
        },
        onTextChange = { userName ->
            onSignUpFormStateChange(signUpFormState.copy(userName = userName))
        }
    )
    Spacer(modifier = Modifier.padding(16.dp))
    AuthTextField(label = "Email",
        text = signUpFormState.email,
        isError = {
            // TODO: 이메일 형식
            false
        },
        onTextChange = { email ->
            onSignUpFormStateChange(signUpFormState.copy(email = email))
        }
    )
    Spacer(modifier = Modifier.padding(16.dp))
    AuthTextField(
        label = "Password",
        text = signUpFormState.password,
        isError = {
            // TODO: 비밀 번호 8 ~ 16자리
            // TODO: 영문, 숫자
            false
        },
        onTextChange = { password ->
            onSignUpFormStateChange(signUpFormState.copy(password = password))
        }
    )
    Spacer(modifier = Modifier.padding(16.dp))
    AuthTextField(
        label = "Password Confirm",
        text = signUpFormState.confirmPassword,
        isError = {
            // TODO: 비밀번호랑 일치하니?
            false
        },
        onTextChange = { confirmPassword ->
            onSignUpFormStateChange(signUpFormState.copy(confirmPassword = confirmPassword))
        }
    )
}

@Composable
private fun SignUpConfirmButton(
    onClickSignUp: () -> Unit,
    enableSignUp: Boolean
) {
    Button(
        modifier = Modifier
            .fillMaxWidth(),
        onClick = { onClickSignUp() }, enabled = enableSignUp
    ) {
        Text(
            modifier = Modifier.padding(vertical = 6.dp),
            text = "Sign Up",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
private fun SignUpTitle() {
    Text(
        text = "Welcome to Compose ?? 🚀",
        style = MaterialTheme.typography.titleLarge.copy(
            fontWeight = FontWeight.Bold
        )
    )
}


@BackgroundPreview
@Composable
private fun Preview() {
    SignupTheme {
        SignUpScreen(
            signUpFormState = SignUpFormState("1", "2", "3", "4"),
            onSignUpFormStateChange = {},
            onClickSignUp = {},
            enableSignUp = true,
        )
    }
}

@BackgroundPreview
@Composable
private fun Preview2() {
    SignupTheme {
        SignUpScreen()
    }
}