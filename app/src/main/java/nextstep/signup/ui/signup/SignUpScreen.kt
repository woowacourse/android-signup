package nextstep.signup.ui.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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

@Composable
fun SignUpScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        var userName by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var passwordConfirm by remember { mutableStateOf("") }

        SignUpHeaderText(
            modifier =
                Modifier.padding(
                    start = 34.dp,
                    end = 34.dp,
                    top = 112.dp,
                    bottom = 42.dp,
                ),
            text = stringResource(R.string.sign_up_greeting),
        )

        Column(
            modifier = Modifier.padding(start = 32.dp, end = 32.dp),
        ) {
            SignUpTextField(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(bottom = 36.dp),
                label = stringResource(R.string.username_label),
                value = userName,
                onValueChange = { input ->
                    userName = input
                },
            )
            SignUpTextField(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(bottom = 36.dp),
                label = stringResource(R.string.email_label),
                value = email,
                onValueChange = { input ->
                    email = input
                },
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
                keyboardType = KeyboardType.Password,
                visualTransformation = PasswordVisualTransformation(),
            )
            SignUpTextField(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(bottom = 42.dp),
                label = stringResource(R.string.password_confirm_label),
                value = passwordConfirm,
                onValueChange = { input ->
                    passwordConfirm = input
                },
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
    }
}
