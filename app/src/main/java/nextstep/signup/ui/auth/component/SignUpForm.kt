package nextstep.signup.ui.auth.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import nextstep.signup.ui.auth.model.SignUpFormState
import nextstep.signup.ui.auth.preview.SignUpPreviewParamsProvider
import nextstep.signup.ui.theme.SignupTheme

@Composable
internal fun SignUpForm(
    signUpFormState: SignUpFormState,
    onUserNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onPasswordConfirmChange: (String) -> Unit,
    onDoneSignUp: () -> Unit
) {
    val focusRequester = remember {
        FocusRequester()
    }

    LaunchedEffect(key1 = Unit) {
        focusRequester.requestFocus()
    }
    AuthUserNameTextField(
        modifier = Modifier.focusRequester(focusRequester),
        userName = signUpFormState.userName,
        onUserNameChange = onUserNameChange
    )
    Spacer(modifier = Modifier.height(16.dp))
    AuthEmailTextField(
        email = signUpFormState.email,
        onEmailChange = onEmailChange
    )
    Spacer(modifier = Modifier.height(16.dp))
    AuthPasswordTextField(
        password = signUpFormState.password,
        onPasswordChange = onPasswordChange
    )
    Spacer(modifier = Modifier.height(16.dp))
    AuthPasswordConfirmTextField(
        password = signUpFormState.password,
        passwordConfirm = signUpFormState.passwordConfirm,
        onPasswordConfirmChange = onPasswordConfirmChange,
        imeAction = ImeAction.Done,
        onDone = onDoneSignUp
    )
}

@Preview
@Composable
private fun Preview(@PreviewParameter(SignUpPreviewParamsProvider::class) value: SignUpFormState) {
    SignupTheme {
        Surface {
            Column(Modifier.padding(32.dp)) {
                SignUpForm(
                    signUpFormState = value,
                    onUserNameChange = {},
                    onEmailChange = {},
                    onPasswordChange = {},
                    onPasswordConfirmChange = {},
                    onDoneSignUp = {}
                )
            }
        }
    }
}
