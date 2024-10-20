package nextstep.signup.presentation.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.signup.R
import nextstep.signup.domain.Email
import nextstep.signup.domain.Password
import nextstep.signup.domain.PasswordConfirm
import nextstep.signup.domain.SignUp
import nextstep.signup.domain.SignUpResult
import nextstep.signup.domain.UserName
import nextstep.signup.ui.theme.SignupTheme

@Composable
fun SignUpScreen() {
    var signUpInput: SignUpInput by remember {
        mutableStateOf(
            SignUpInput(
                username = "",
                email = "",
                password = "",
                passwordConfirm = ""
            )
        )
    }

    val signUpResult: SignUpResult by remember(signUpInput) {
        mutableStateOf(
            SignUp.from(
                userName = UserName.from(signUpInput.username),
                email = Email.from(signUpInput.email),
                password = Password.from(signUpInput.password),
                passwordConfirm = PasswordConfirm.from(signUpInput.password, signUpInput.passwordConfirm)
            )
        )
    }

    val signUpIsEnabled: Boolean by remember(signUpResult) {
        mutableStateOf(signUpResult is SignUpResult.Success)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(40.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SignUpHeader(
            modifier = Modifier.fillMaxWidth()
        )

        UserNameTextField(
            name = signUpInput.username,
            onValueChange = {
                signUpInput = signUpInput.copy(username = it)
            },
            labelText = stringResource(R.string.sign_up_user_name_label),
            modifier = Modifier.fillMaxWidth()
        )

        EmailTextField(
            email = signUpInput.email,
            onValueChange = {
                signUpInput = signUpInput.copy(email = it)
            },
            labelText = stringResource(R.string.sign_up_email_label),
            modifier = Modifier.fillMaxWidth()
        )

        PasswordTextField(
            password = signUpInput.password,
            onValueChange = {
                signUpInput = signUpInput.copy(password = it)
            },
            labelText = stringResource(id = R.string.sign_up_password_label),
            modifier = Modifier.fillMaxWidth()
        )

        PasswordConfirmTextField(
            password = signUpInput.password,
            passwordConfirm = signUpInput.passwordConfirm,
            onValueChange = {
                signUpInput = signUpInput.copy(passwordConfirm = it)
            },
            labelText = stringResource(id = R.string.sign_up_password_confirm_label),
            modifier = Modifier.fillMaxWidth()
        )

        SignUpButton(
            text = stringResource(R.string.sign_up_button),
            modifier = Modifier.fillMaxWidth(),
            enabled = signUpIsEnabled
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SignupScreenPreview() {
    SignupTheme {
        SignUpScreen()
    }
}
