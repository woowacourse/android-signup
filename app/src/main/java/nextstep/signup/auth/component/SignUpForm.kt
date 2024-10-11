package nextstep.signup.auth.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    val focusManager = LocalFocusManager.current

    AuthTextField(
        modifier = Modifier.focusRequester(focusRequester),
        label = "UserName",
        text = signUpFormState.userName,
        isError = {
            // TODO: 이름은 2~5자여야 합니다.
            // TODO: 이름에는 숫자나 기호가 포함될 수 없습니다
            false
        },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = { focusManager.moveFocus(FocusDirection.Next) }
        ),
        onTextChange = { userName ->
            onSignUpFormStateChange(signUpFormState.copy(userName = userName))
        }
    )
    Spacer(modifier = Modifier.padding(16.dp))
    AuthTextField(
        label = "Email",
        text = signUpFormState.email,
        isError = {
            // TODO: 이메일 형식
            false
        },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = { focusManager.moveFocus(FocusDirection.Next) }
        ),
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
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Password
        ),
        keyboardActions = KeyboardActions(
            onNext = { focusManager.moveFocus(FocusDirection.Next) }
        ),
        visualTransformation = PasswordVisualTransformation(),
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
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Password
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
                onDoneSignUp()
            }
        ),
        visualTransformation = PasswordVisualTransformation(),
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
                    ),
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