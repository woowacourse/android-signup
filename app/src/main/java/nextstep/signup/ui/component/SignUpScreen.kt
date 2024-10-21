package nextstep.signup.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.signup.R
import nextstep.signup.ui.model.ConfirmedPassword
import nextstep.signup.ui.model.Email
import nextstep.signup.ui.model.Password
import nextstep.signup.ui.model.UserName
import nextstep.signup.ui.theme.SignupTheme

@Composable
fun SignUpScreen() {
    var userName by remember { mutableStateOf(UserName()) }
    var email by remember { mutableStateOf(Email()) }
    var password by remember { mutableStateOf(Password()) }
    var confirmedPassword by remember { mutableStateOf(ConfirmedPassword(password = password.value)) }
    val signUpInfoValidation by remember {
        derivedStateOf {
            userName.validation.isValid &&
                    email.validation.isValid &&
                    password.validation.isValid &&
                    confirmedPassword.validation.isValid
        }
    }

    Column(
        modifier = Modifier.padding(horizontal = 33.0.dp),
    ) {
        SignUpTitle(R.string.signup_title)
        SignUpField(
            R.string.signup_username_label,
            value = userName.value,
            signUpResult = userName.validation,
            onValueChange = { userName = userName.copy(value = it) },
        )
        SignUpField(
            R.string.signup_email_label,
            value = email.value,
            signUpResult = email.validation,
            onValueChange = { email = email.copy(value = it) },
        )

        SignUpField(
            R.string.signup_password_label,
            value = password.value,
            signUpResult = password.validation,
            onValueChange = {
                password = password.copy(value = it)
                confirmedPassword = confirmedPassword.copy(password = it)
            },
            hidden = true,
        )

        SignUpField(
            R.string.signup_password_confirm_label,
            value = confirmedPassword.value,
            signUpResult = confirmedPassword.validation,
            onValueChange = {
                confirmedPassword = confirmedPassword.copy(value = it)
            },
            hidden = true,
        )
        SignUpButton(
            R.string.signup_button,
            enabled = signUpInfoValidation,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SignUpPreview() {
    SignupTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            SignUpScreen()
        }
    }
}
