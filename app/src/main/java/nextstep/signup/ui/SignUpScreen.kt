package nextstep.signup.ui

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.signup.R

@Composable
fun SignUpScreen(
    userName: String,
    onUserNameChanged: (String) -> Unit,
    email: String,
    onEmailChanged: (String) -> Unit,
    password: String,
    onPasswordChanged: (String) -> Unit,
    passwordConfirm: String,
    onPasswordConfirmChanged: (String) -> Unit,
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
            SignupTitle(
                stringResource(R.string.welcome_to_compose),
                Modifier.padding(top = 60.dp),
            )
            SignUpTextField(
                modifier = Modifier.padding(top = 36.dp),
                hint = stringResource(R.string.user_name),
                value = userName,
                onValueChange = onUserNameChanged,
            )
            SignUpTextField(
                modifier = Modifier.padding(top = 36.dp),
                hint = stringResource(R.string.email),
                value = email,
                onValueChange = onEmailChanged,
            )
            SignUpTextField(
                modifier = Modifier.padding(top = 36.dp),
                hint = stringResource(R.string.password),
                value = password,
                visualTransformation = PasswordVisualTransformation(),
                onValueChange = onPasswordChanged,
            )
            SignUpTextField(
                modifier = Modifier.padding(top = 36.dp),
                hint = stringResource(R.string.password_confirm),
                value = passwordConfirm,
                visualTransformation = PasswordVisualTransformation(),
                onValueChange = onPasswordConfirmChanged,
            )
            SignUpButton(
                Modifier
                    .padding(top = 42.dp),
                stringResource(R.string.sign_up),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SignUpPreview() {
    var email by remember { mutableStateOf("") }
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordConfirm by remember { mutableStateOf("") }

    SignUpScreen(
        userName,
        { userName = it },
        email,
        { email = it },
        password,
        { password = it },
        passwordConfirm,
        { passwordConfirm = it },
    )
}

@Preview(showBackground = true)
@Composable
private fun SignUpPreviewWithValue() {
    var email by remember { mutableStateOf("salth6@naver.com") }
    var userName by remember { mutableStateOf("빙티") }
    var password by remember { mutableStateOf("password") }
    var passwordConfirm by remember { mutableStateOf("password") }

    SignUpScreen(
        userName,
        { userName = it },
        email,
        { email = it },
        password,
        { password = it },
        passwordConfirm,
        { passwordConfirm = it },
    )
}
