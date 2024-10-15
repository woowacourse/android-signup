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
                value = userName,
                hint = stringResource(R.string.user_name),
                modifier = Modifier.padding(top = 36.dp),
                onValueChange = onUserNameChanged,
                getErrorMessage = { getUserNameErrorMessage(userName) },
            )
            SignUpTextField(
                value = email,
                hint = stringResource(R.string.email),
                modifier = Modifier.padding(top = 36.dp),
                onValueChange = onEmailChanged,
                getErrorMessage = { getEmailErrorMessage(email) },
            )
            SignUpTextField(
                value = password,
                hint = stringResource(R.string.password),
                modifier = Modifier.padding(top = 36.dp),
                visualTransformation = PasswordVisualTransformation(),
                onValueChange = onPasswordChanged,
                getErrorMessage = { validate(password) },
            )
            SignUpTextField(
                value = passwordConfirm,
                hint = stringResource(R.string.password_confirm),
                modifier = Modifier.padding(top = 36.dp),
                visualTransformation = PasswordVisualTransformation(),
                onValueChange = onPasswordConfirmChanged,
                getErrorMessage = { validate(passwordConfirm) },
            )
            SignUpButton(
                Modifier
                    .padding(top = 42.dp),
                stringResource(R.string.sign_up),
            )
        }
    }
}

@Composable
fun getUserNameErrorMessage(userName: String): String {
    val usernameLengthRegex = "^.{2,5}$"
    val usernameRegex = "^[a-zA-Z가-힣]+$"
    return if (!userName.matches(Regex(usernameRegex))) {
        stringResource(id = R.string.error_message_user_name)
    } else if (!userName.matches(Regex(usernameLengthRegex))) {
        stringResource(id = R.string.error_message_user_name_length)
    } else {
        stringResource(id = R.string.empty)
    }
}

@Composable
fun getEmailErrorMessage(email: String): String {
    val emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
    return if (email.matches(Regex(emailRegex))) {
        stringResource(id = R.string.empty)
    } else {
        stringResource(id = R.string.error_message_email)
    }
}

fun validate(text: String): String {
    return ""
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
