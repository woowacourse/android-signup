package nextstep.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.signup.ui.theme.SignupTheme

class MainActivity : ComponentActivity() {
    companion object {
        const val USERNAME_REGEX = "^[a-zA-Z가-힣]+$"
        const val EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
        const val PASSWORD_REGEX = "^(?=.*[a-zA-Z])(?=.*[0-9]).{8,16}$"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignupTheme {
                SignUpScreen()
            }
        }
    }
}

@Composable
fun SignUpScreen() {
    var userName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordConfirm by remember { mutableStateOf("") }

    var userNameError by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf("") }
    var passwordConfirmError by remember { mutableStateOf("") }

    val usernameLengthError = stringResource(R.string.username_length_error)
    val usernameFormatError = stringResource(R.string.username_format_error)
    val emailFormatError = stringResource(R.string.email_format_error)
    val passwordLengthError = stringResource(R.string.password_length_error)
    val passwordFormatError = stringResource(R.string.password_format_error)
    val passwordConfirmErrorString = stringResource(R.string.password_confirm_error)

    val isButtonEnabled = canClickedButton(
        userNameError,
        emailError,
        passwordError,
        passwordConfirmError,
        userName,
        email,
        password,
        passwordConfirm
    )

    Surface {
        Column(modifier = Modifier.fillMaxWidth()) {
            SignUpLabel()
            SignUpForm(
                userName = userName,
                onUserNameChange = {
                    userName = it
                    userNameError = getUserNameError(it, usernameLengthError, usernameFormatError)
                },
                userNameError = userNameError,

                email = email,
                onEmailChange = {
                    email = it
                    emailError = getEmailError(it, emailFormatError)
                },
                emailError = emailError,

                password = password,
                onPasswordChange = {
                    password = it
                    passwordError = getPasswordError(it, passwordLengthError, passwordFormatError)
                    passwordConfirmError =
                        if (passwordConfirm.isNotEmpty() && passwordConfirm != it) {
                            passwordConfirmErrorString
                        } else {
                            ""
                        }
                },
                passwordError = passwordError,

                passwordConfirm = passwordConfirm,
                onPasswordConfirmChange = {
                    passwordConfirm = it
                    passwordConfirmError = if (password != it) {
                        passwordConfirmErrorString
                    } else {
                        ""
                    }
                },
                passwordConfirmError = passwordConfirmError
            )
            SignUpButton(isButtonEnabled = isButtonEnabled)
        }
    }
}

@Composable
private fun canClickedButton(
    userNameError: String,
    emailError: String,
    passwordError: String,
    passwordConfirmError: String,
    userName: String,
    email: String,
    password: String,
    passwordConfirm: String
): Boolean {
    val isButtonEnabled = remember(
        userNameError, emailError, passwordError, passwordConfirmError,
        userName, email, password, passwordConfirm
    ) {
        userNameError.isEmpty() && emailError.isEmpty() && passwordError.isEmpty() && passwordConfirmError.isEmpty() &&
                userName.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && passwordConfirm.isNotEmpty()
    }
    return isButtonEnabled
}

@Composable
fun SignUpLabel() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(R.string.title),
            modifier = Modifier.align(Alignment.Center),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun SignUpForm(
    userName: String,
    onUserNameChange: (String) -> Unit,
    userNameError: String,

    email: String,
    onEmailChange: (String) -> Unit,
    emailError: String,

    password: String,
    onPasswordChange: (String) -> Unit,
    passwordError: String,

    passwordConfirm: String,
    onPasswordConfirmChange: (String) -> Unit,
    passwordConfirmError: String
) {
    Column {
        CustomTextField(
            value = userName,
            onValueChange = onUserNameChange,
            label = stringResource(R.string.username),
            isError = userNameError.isNotEmpty(),
            errorMessage = userNameError
        )

        CustomTextField(
            value = email,
            onValueChange = onEmailChange,
            label = stringResource(R.string.email),
            isError = emailError.isNotEmpty(),
            errorMessage = emailError
        )

        CustomTextField(
            value = password,
            onValueChange = onPasswordChange,
            label = stringResource(R.string.password),
            isPasswordField = true,
            isError = passwordError.isNotEmpty(),
            errorMessage = passwordError
        )

        CustomTextField(
            value = passwordConfirm,
            onValueChange = onPasswordConfirmChange,
            label = stringResource(R.string.password_confirm),
            isPasswordField = true,
            isError = passwordConfirmError.isNotEmpty(),
            errorMessage = passwordConfirmError
        )
    }
}

@Composable
fun SignUpButton(isButtonEnabled: Boolean) {
    Button(
        onClick = { /* something */ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        enabled = isButtonEnabled
    ) {
        Text(text = stringResource(R.string.sign_up))
    }
}

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    isPasswordField: Boolean = false,
    isError: Boolean = false,
    errorMessage: String = ""
) {
    Column {
        TextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(label) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            visualTransformation = if (isPasswordField) PasswordVisualTransformation() else VisualTransformation.None,
            isError = isError
        )
        if (isError) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(start = 24.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    SignupTheme {
        SignUpScreen()
    }
}

fun getUserNameError(userName: String, lengthError: String, formatError: String): String {
    return when {
        userName.length !in 2..5 -> lengthError
        !userName.matches(Regex(MainActivity.USERNAME_REGEX)) -> formatError
        else -> ""
    }
}

fun getEmailError(email: String, formatError: String): String {
    return if (!email.matches(Regex(MainActivity.EMAIL_REGEX))) {
        formatError
    } else {
        ""
    }
}

fun getPasswordError(password: String, lengthError: String, formatError: String): String {
    return when {
        password.length !in 8..16 -> lengthError
        !password.matches(Regex(MainActivity.PASSWORD_REGEX)) -> formatError
        else -> ""
    }
}
