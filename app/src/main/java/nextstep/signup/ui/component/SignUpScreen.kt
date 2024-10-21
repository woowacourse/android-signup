package nextstep.signup.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.signup.R
import nextstep.signup.ui.model.SignUpInfo
import nextstep.signup.ui.theme.SignupTheme

@Composable
fun SignUpScreen() {
    var signUpInfo by remember { mutableStateOf(SignUpInfo()) }

    Column(
        modifier = Modifier.padding(horizontal = 33.0.dp),
    ) {
        SignUpTitle(R.string.signup_title)
        SignUpField(
            R.string.signup_username_label,
            value = signUpInfo.userName,
            validationResult = signUpInfo.userNameValidation,
            onValueChange = { signUpInfo = signUpInfo.copy(userName = it) },
        )
        SignUpField(
            R.string.signup_email_label,
            value = signUpInfo.email,
            validationResult = signUpInfo.emailValidation,
            onValueChange = { signUpInfo = signUpInfo.copy(email = it) },
        )

        SignUpField(
            R.string.signup_password_label,
            value = signUpInfo.password,
            validationResult = signUpInfo.passwordValidation,
            onValueChange = { signUpInfo = signUpInfo.copy(password = it) },
            hidden = true,
        )

        SignUpField(
            R.string.signup_password_confirm_label,
            value = signUpInfo.confirmedPassword,
            validationResult = signUpInfo.confirmedPasswordValidation,
            onValueChange = { signUpInfo = signUpInfo.copy(confirmedPassword = it) },
            hidden = true,
        )
        SignUpButton(
            R.string.signup_button,
            enabled = signUpInfo.signUpInfoValidation,
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
