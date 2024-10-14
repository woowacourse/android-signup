package nextstep.signup.auth.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.signup.R
import nextstep.signup.auth.state.SignUpFormState
import nextstep.signup.ui.theme.SignupTheme

@Composable
internal fun SignUpForm(
    signUpFormState: SignUpFormState,
    onSignUpFormStateChange: (SignUpFormState) -> Unit,
    onDoneSignUp: () -> Unit
) {
    val focusRequester = remember {
        FocusRequester()
    }
    LaunchedEffect(key1 = Unit) {
        focusRequester.requestFocus()
    }
    AuthTextField(
        modifier = Modifier.focusRequester(focusRequester),
        label = stringResource(id = R.string.sign_up_user_name_form),
        text = signUpFormState.userName,
        isValid = {
            // TODO: 이름은 2~5자여야 합니다.
            // TODO: 이름에는 숫자나 기호가 포함될 수 없습니다
            true
        },
        imeAction = ImeAction.Next,
        onTextChange = { userName ->
            onSignUpFormStateChange(signUpFormState.copy(userName = userName))
        }
    )
    Spacer(modifier = Modifier.height(16.dp))
    AuthTextField(
        label = stringResource(id = R.string.sign_up_email_form),
        text = signUpFormState.email,
        isValid = {
            // TODO: 이메일 형식
            true
        },
        imeAction = ImeAction.Next,
        onTextChange = { email ->
            onSignUpFormStateChange(signUpFormState.copy(email = email))
        }
    )
    Spacer(modifier = Modifier.height(16.dp))
    AuthTextField(
        label = stringResource(id = R.string.sign_up_password_form),
        text = signUpFormState.password,
        isValid = {
            // TODO: 비밀 번호 8 ~ 16자리
            // TODO: 영문, 숫자
            true
        },
        imeAction = ImeAction.Next,
        keyboardType = KeyboardType.Password,
        onTextChange = { password ->
            onSignUpFormStateChange(signUpFormState.copy(password = password))
        }
    )
    Spacer(modifier = Modifier.height(16.dp))
    AuthTextField(
        label = stringResource(id = R.string.sign_up_password_confirm_form),
        text = signUpFormState.confirmPassword,
        isValid = {
            // TODO: Password와 동일
            true
        },
        onDone = onDoneSignUp,
        imeAction = ImeAction.Done,
        keyboardType = KeyboardType.Password,
        onTextChange = { confirmPassword ->
            onSignUpFormStateChange(signUpFormState.copy(confirmPassword = confirmPassword))
        }
    )
}

@Preview
@Composable
private fun Preview() {
    SignupTheme {
        Surface {
            val (value, onChangeValue) = remember {
                mutableStateOf(
                    SignUpFormState(
                        "",
                        "",
                        "",
                        ""
                    )
                )
            }
            Column(Modifier.padding(32.dp)) {
                SignUpForm(
                    signUpFormState = value,
                    onSignUpFormStateChange = onChangeValue,
                    onDoneSignUp = {}
                )
            }
        }
    }
}
