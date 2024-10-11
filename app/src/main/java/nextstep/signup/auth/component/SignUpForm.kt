package nextstep.signup.auth.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import nextstep.signup.auth.state.SignUpFormState


@Composable
internal fun SignUpForm(
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