package nextstep.signup.ui.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.signup.R
import nextstep.signup.model.validation.CompositeValidation
import nextstep.signup.model.validation.EqualValidation
import nextstep.signup.model.validation.LengthValidation
import nextstep.signup.model.validation.RegexValidation
import nextstep.signup.model.validation.Validation
import nextstep.signup.ui.theme.SignupTheme
import nextstep.signup.model.validation.ValidationResult

@Composable
fun SignUpScreen(
    userNameValidation: Validation,
    emailValidation: Validation,
    passwordValidation: Validation,
    modifier: Modifier = Modifier,
    userName: MutableState<String> = remember { mutableStateOf("") },
    email: MutableState<String> = remember { mutableStateOf("") },
    password: MutableState<String> = remember { mutableStateOf("") },
    passwordConfirm: MutableState<String> = remember { mutableStateOf("") },
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(42.dp),
    ) {
        val passwordConfirmValidation =
            EqualValidation(password.value)
        val isSignUpButtonEnabled =
            userNameValidation.validate(userName.value) is ValidationResult.Success &&
                    emailValidation.validate(email.value) is ValidationResult.Success &&
                    passwordValidation.validate(password.value) is ValidationResult.Success &&
                    passwordConfirmValidation.validate(passwordConfirm.value) is ValidationResult.Success

        Text(
            text = stringResource(id = R.string.welcome),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(36.dp),
        ) {
            UsernameTextField(
                username = userName,
                onValueChange = { userName.value = it },
                validation = userNameValidation,
            )
            EmailTextField(
                label = stringResource(id = R.string.email),
                text = email,
                onValueChange = { email.value = it },
                validation = emailValidation,
            )
            PasswordTextField(
                label = stringResource(id = R.string.password),
                text = password,
                validation = passwordValidation,
                onValueChange = { password.value = it },
            )
            PasswordConfirmTextField(
                label = stringResource(id = R.string.password_confirm),
                text = passwordConfirm,
                validation = passwordConfirmValidation,
                onValueChange = { passwordConfirm.value = it },
            )
        }
        ConfirmButton(
            modifier = Modifier.fillMaxWidth(),
            enabled = isSignUpButtonEnabled,
            text = stringResource(id = R.string.signup),
        )
    }
}

@Preview(
    showBackground = true,
)
@Composable
fun SignUpFormScreen() {
    val userNameLengthValidation =
        LengthValidation(2..5)
    val characterValidation = RegexValidation(
        "[a-zA-Z가-힣]+".toRegex(),
    )
    val userNameValidation = CompositeValidation(userNameLengthValidation, characterValidation)

    val emailValidation =
        RegexValidation(
            "[a-zA-Z0-9._-]+@[a-zA-Z]+\\.+[a-zA-Z]+".toRegex()
        )

    val passwordLengthValidation =
        LengthValidation(8..16)
    val passwordRegex = "^(?=.*[a-zA-Z])(?=.*[0-9]).+\$".toRegex()
    val regexValidation =
        RegexValidation(passwordRegex)
    val passwordValidation = CompositeValidation(passwordLengthValidation, regexValidation)

    val password = remember { mutableStateOf("") }
    SignupTheme {
        SignUpScreen(
            userNameValidation = userNameValidation,
            emailValidation = emailValidation,
            passwordValidation = passwordValidation,
            password = password,
        )
    }
}
