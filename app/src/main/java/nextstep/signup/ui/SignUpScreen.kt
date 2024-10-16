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
import nextstep.signup.domain.ValidationState

@Composable
fun SignUpScreen(
    signUpForm: SignUpForm,
    onSignUpFormChanged: (SignUpForm) -> Unit,
) {
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
                onValueChange = { onSignUpFormChanged(signUpForm.copy(userName = it)) },
                getErrorMessage = { getUserNameErrorMessage(signUpForm.validateUserName()) },
            )
            Spacer(modifier = Modifier.height(36.dp))
            SignUpTextField(
                value = signUpForm.email,
                hint = stringResource(R.string.email),
                onValueChange = { onSignUpFormChanged(signUpForm.copy(email = it)) },
                getErrorMessage = { getEmailErrorMessage(signUpForm.validateEmail()) },
            )
            Spacer(modifier = Modifier.height(36.dp))
            SignUpTextField(
                value = signUpForm.password,
                hint = stringResource(R.string.password),
                visualTransformation = PasswordVisualTransformation(),
                onValueChange = { onSignUpFormChanged(signUpForm.copy(password = it)) },
                getErrorMessage = { getPasswordErrorMessage(signUpForm.validatePassword()) },
            )
            Spacer(modifier = Modifier.height(36.dp))
            SignUpTextField(
                value = signUpForm.passwordConfirm,
                hint = stringResource(R.string.password_confirm),
                visualTransformation = PasswordVisualTransformation(),
                onValueChange = { onSignUpFormChanged(signUpForm.copy(passwordConfirm = it)) },
                getErrorMessage = {
                    getPasswordConfirmErrorMessage(
                        signUpForm.validatePasswordConfirm(),
                    )
                },
            )
            Spacer(modifier = Modifier.height(42.dp))
            SignUpButton(
                title = stringResource(R.string.sign_up),
                isEnabled = signUpForm.isValidForm,
            )
        }
    }
}

@Composable
fun getUserNameErrorMessage(usernameState: ValidationState): String {
    return when (usernameState) {
        ValidationState.VALID -> stringResource(id = R.string.empty)
        ValidationState.FORMAT_ERROR -> stringResource(id = R.string.format_error_message_user_name)
        ValidationState.LENGTH_ERROR -> stringResource(id = R.string.length_error_message_user_name)
    }
}

@Composable
fun getEmailErrorMessage(emailState: ValidationState): String {
    return when (emailState) {
        ValidationState.FORMAT_ERROR -> stringResource(id = R.string.format_error_message_email)
        else -> stringResource(id = R.string.empty)
    }
}

@Composable
fun getPasswordErrorMessage(passwordState: ValidationState): String {
    return when (passwordState) {
        ValidationState.VALID -> stringResource(id = R.string.empty)
        ValidationState.FORMAT_ERROR -> stringResource(id = R.string.format_error_message_password)
        ValidationState.LENGTH_ERROR -> stringResource(id = R.string.length_error_message_password)
    }
}

@Composable
fun getPasswordConfirmErrorMessage(passwordState: ValidationState): String {
    return when (passwordState) {
        ValidationState.FORMAT_ERROR -> stringResource(id = R.string.format_error_message_password_confirm)
        else -> stringResource(id = R.string.empty)
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
