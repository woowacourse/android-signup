package nextstep.signup.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.signup.R
import nextstep.signup.domain.SignUpForm

@Composable
fun SignUpScreen(
    signUpForm: SignUpForm,
    onSignUpFormChanged: (SignUpForm) -> Unit,
) {
    val onUserNameChanged =
        remember(signUpForm.userName) {
            { newUserName: String ->
                onSignUpFormChanged(signUpForm.copy(userName = newUserName))
            }
        }
    val onEmailChanged =
        remember(signUpForm.email) {
            { newEmail: String ->
                onSignUpFormChanged(signUpForm.copy(email = newEmail))
            }
        }
    val onPasswordChanged =
        remember(signUpForm.password) {
            { newPassword: String ->
                onSignUpFormChanged(signUpForm.copy(password = newPassword))
            }
        }
    val onPasswordConfirmChanged =
        remember(signUpForm.passwordConfirm) {
            { newPasswordConfirm: String ->
                onSignUpFormChanged(signUpForm.copy(passwordConfirm = newPasswordConfirm))
            }
        }
    Surface(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp),
        color = MaterialTheme.colorScheme.background,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
        ) {
            Spacer(modifier = Modifier.height(60.dp))
            SignupTitle(
                stringResource(R.string.welcome_to_compose),
            )
            Spacer(modifier = Modifier.height(36.dp))
            SignUpTextField(
                value = signUpForm.userName,
                hint = stringResource(R.string.user_name),
                onValueChange = onUserNameChanged,
                errorMessage = signUpForm.getUserNameErrorMessage(),
            )
            Spacer(modifier = Modifier.height(36.dp))
            SignUpTextField(
                value = signUpForm.email,
                hint = stringResource(R.string.email),
                onValueChange = onEmailChanged,
                errorMessage = signUpForm.getEmailErrorMessage(),
            )
            Spacer(modifier = Modifier.height(36.dp))
            SignUpTextField(
                value = signUpForm.password,
                hint = stringResource(R.string.password),
                visualTransformation = PasswordVisualTransformation(),
                onValueChange = onPasswordChanged,
                errorMessage = signUpForm.getPasswordErrorMessage(),
            )
            Spacer(modifier = Modifier.height(36.dp))
            SignUpTextField(
                value = signUpForm.passwordConfirm,
                hint = stringResource(R.string.password_confirm),
                visualTransformation = PasswordVisualTransformation(),
                onValueChange = onPasswordConfirmChanged,
                errorMessage = signUpForm.getPasswordConfirmErrorMessage(),
            )
            Spacer(modifier = Modifier.height(42.dp))
            SignUpButton(
                title = stringResource(R.string.sign_up),
                isEnabled = signUpForm.isValidForm,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SignUpPreview() {
    var signUpForm by rememberSaveable { mutableStateOf(SignUpForm.emptySignUpForm) }

    SignUpScreen(signUpForm) { newSignUpForm ->
        signUpForm = newSignUpForm
    }
}

@Preview(showBackground = true)
@Composable
private fun SignUpPreviewWithValue() {
    var signUpForm by rememberSaveable {
        mutableStateOf(
            SignUpForm(
                "test",
                "test@gmail.com",
                "test1234",
                "test1234",
            ),
        )
    }

    SignUpScreen(signUpForm) { newSignUpForm ->
        signUpForm = newSignUpForm
    }
}
