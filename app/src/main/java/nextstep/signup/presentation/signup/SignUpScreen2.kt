package nextstep.signup.presentation.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
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
import nextstep.signup.ui.theme.SignupTheme

@Composable
fun SignUpScreen2() {
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
        verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SignUpHeader(
            modifier = Modifier.wrapContentSize()
        )

        UserNameTextField(
            labelText = stringResource(R.string.sign_up_user_name_label),
            name = username,
            onValueChange = { username = it },
            modifier = Modifier.fillMaxWidth()
        )

        EmailTextField(
            labelText = stringResource(R.string.sign_up_email_label),
            email = email,
            onValueChange = { email = it },
            modifier = Modifier.fillMaxWidth()
        )

        PasswordTextFields(
            password = password,
            passwordConfirm = passwordConfirm,
            onPasswordChange = { password = it },
            onPasswordConfirmChange = { passwordConfirm = it },
            modifier = Modifier.fillMaxWidth()
        )

        SignUpButton(
            text = stringResource(R.string.sign_up_button),
            modifier = Modifier.fillMaxWidth(),
            enable = { false }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Signup2ScreenPreview() {
    SignupTheme {
        SignUpScreen2()
    }
}
