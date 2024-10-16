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
import nextstep.signup.ui.model.SignUpInformation
import nextstep.signup.ui.model.UserName

val PASSWORD_REGEX = Regex("^(?=.*[a-zA-Z])(?=.*[0-9]).{8,16}$")

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
        var password by rememberSaveable { mutableStateOf("") }
        var passwordConfirm by rememberSaveable { mutableStateOf("") }

        var signUpInformation by rememberSaveable { mutableStateOf(SignUpInformation()) }

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
                value = signUpInformation.userName.text,
                onValueChange = { value ->
                    signUpInformation = signUpInformation.copy(userName = UserName(text = value))
                },
                isValid = signUpInformation.userName.isValid(),
                errorMessage = signUpInformation.userName.errorMessage(),
            )
            SignUpTextField(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(bottom = 36.dp),
                label = stringResource(R.string.email_label),
                value = signUpInformation.email.text,
                onValueChange = { value ->
                    signUpInformation = signUpInformation.copy(email = Email(text = value))
                },
                isValid = signUpInformation.email.isValid(),
                errorMessage = signUpInformation.email.errorMessage(),
                keyboardType = KeyboardType.Email,
            )
            SignUpTextField(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(bottom = 36.dp),
                label = stringResource(R.string.password_label),
                value = password,
                onValueChange = { input ->
                    password = input
                },
                isValid = password.matches(PASSWORD_REGEX),
                errorMessage = "hi",
                keyboardType = KeyboardType.Password,
                visualTransformation = PasswordVisualTransformation(),
            )
            SignUpTextField(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(bottom = 36.dp),
                label = stringResource(R.string.password_confirm_label),
                value = passwordConfirm,
                onValueChange = { input ->
                    passwordConfirm = input
                },
                isValid = password.matches(PASSWORD_REGEX),
                errorMessage = "hi",
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
        )

        Spacer(modifier = Modifier.padding(bottom = 36.dp))
    }
}
