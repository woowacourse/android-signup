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
import nextstep.signup.domain.Email2
import nextstep.signup.domain.Password
import nextstep.signup.domain.PasswordConfirm
import nextstep.signup.domain.SignUp
import nextstep.signup.domain.UserName
import nextstep.signup.ui.theme.SignupTheme

@Composable
fun SignUpScreen() {
    var username: String by remember {
        mutableStateOf("")
    }

    var email: String by remember {
        mutableStateOf("")
    }

    var password: String by remember {
        mutableStateOf("")
    }

    var passwordConfirm: String by remember {
        mutableStateOf("")
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
            name = username,
            onValueChange = { username = it },
            labelText = stringResource(R.string.sign_up_user_name_label),
            modifier = Modifier.fillMaxWidth()
        )

        EmailTextField(
            email = email,
            onValueChange = { email = it },
            labelText = stringResource(R.string.sign_up_email_label),
            modifier = Modifier.fillMaxWidth()
        )

        PasswordTextField(
            password = password,
            onValueChange = { password = it },
            labelText = stringResource(id = R.string.sign_up_password_label),
            modifier = Modifier.fillMaxWidth()
        )

        PasswordConfirmTextField(
            password = password,
            passwordConfirm = passwordConfirm,
            onValueChange = { passwordConfirm = it },
            labelText = stringResource(id = R.string.sign_up_password_confirm_label),
            modifier = Modifier.fillMaxWidth()
        )

        SignUpButton(
            text = stringResource(R.string.sign_up_button),
            modifier = Modifier.fillMaxWidth(),
            signUpResult = SignUp.from(
                userName = UserName.from(username),
                email = Email2.from(email),
                password = Password.from(password),
                passwordConfirm = PasswordConfirm.from(password, passwordConfirm)
            )
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
