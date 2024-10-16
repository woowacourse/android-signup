package nextstep.signup.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import nextstep.signup.R
import nextstep.signup.ui.component.SignUpButton
import nextstep.signup.ui.component.SignUpHeaderText
import nextstep.signup.ui.component.SignUpTextField
import nextstep.signup.ui.model.Email
import nextstep.signup.ui.model.Password
import nextstep.signup.ui.model.PasswordConfirm
import nextstep.signup.ui.model.SignUpState
import nextstep.signup.ui.model.UserName

@Composable
fun SignUpScreen() {
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        var userName by rememberSaveable { mutableStateOf(UserName()) }
        var email by rememberSaveable { mutableStateOf(Email()) }
        var password by rememberSaveable { mutableStateOf(Password()) }
        var passwordConfirm by rememberSaveable { mutableStateOf(PasswordConfirm()) }

        val signUpState =
            SignUpState(
                userName = userName,
                email = email,
                password = password,
                passwordConfirm = passwordConfirm,
            )

        SignUpHeaderText(
            modifier =
                Modifier.padding(
                    start = 28.dp,
                    end = 28.dp,
                    top = 84.dp,
                    bottom = 42.dp,
                ),
            text = stringResource(R.string.sign_up_header),
        )

        Column(
            modifier = Modifier.padding(start = 28.dp, end = 28.dp),
        ) {
            SignUpTextField(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(bottom = 36.dp),
                label = stringResource(R.string.username_label),
                value = userName.text,
                onValueChange = { value ->
                    userName = userName.copy(text = value)
                },
                isValid = userName.isValid(),
                errorMessage = userName.errorMessage(),
            )

            SignUpTextField(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(bottom = 36.dp),
                label = stringResource(R.string.email_label),
                value = email.text,
                onValueChange = { value ->
                    email = email.copy(text = value)
                },
                isValid = email.isValid(),
                errorMessage = email.errorMessage(),
                keyboardType = KeyboardType.Email,
            )

            SignUpTextField(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(bottom = 36.dp),
                label = stringResource(R.string.password_label),
                value = password.text,
                onValueChange = { value ->
                    password = password.copy(text = value)
                    passwordConfirm = passwordConfirm.copy(passwordText = value)
                },
                isValid = password.isValid(),
                errorMessage = password.errorMessage(),
                keyboardType = KeyboardType.Password,
                visualTransformation = PasswordVisualTransformation(),
            )

            SignUpTextField(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(bottom = 36.dp),
                label = stringResource(R.string.password_confirm_label),
                value = passwordConfirm.text,
                onValueChange = { value ->
                    passwordConfirm = passwordConfirm.copy(text = value)
                },
                isValid = passwordConfirm.isValid(),
                errorMessage = passwordConfirm.errorMessage(),
                keyboardType = KeyboardType.Password,
                visualTransformation = PasswordVisualTransformation(),
            )
        }

        SignUpButton(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(start = 32.dp, end = 32.dp),
            text = stringResource(R.string.sign_up_button_label),
            onclick = {},
            enabled = signUpState.isEnable(),
        )

        Spacer(modifier = Modifier.padding(bottom = 36.dp))
    }
}
