package nextstep.signup.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.signup.R
import nextstep.signup.model.fieldtype.InputFieldType
import nextstep.signup.model.fieldtype.PasswordInputFieldType

@Composable
fun SignUpScreen() {
    var userName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    var isUserNameValid by remember { mutableStateOf(false) }
    var isEmailValid by remember { mutableStateOf(false) }
    var isPasswordValid by remember { mutableStateOf(false) }
    var isConfirmPasswordValid by remember { mutableStateOf(false) }

    val isFormValid = isUserNameValid && isEmailValid && isPasswordValid && isConfirmPasswordValid

    Column(
        modifier =
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
    ) {
        TitleText(stringResource(R.string.title))

        Spacer(modifier = Modifier.height(16.dp))

        InputField(
            label = stringResource(R.string.sign_up),
            value = userName,
            onValueChange = { inputUserName, validity ->
                userName = inputUserName
                isUserNameValid = validity
            },
            keyboardType = KeyboardType.Text,
            paddingBottom = 36.dp,
            type = InputFieldType.USER_NAME,
        )

        InputField(
            label = stringResource(R.string.email),
            value = email,
            onValueChange = { inputUserName, validity ->
                email = inputUserName
                isEmailValid = validity
            },
            keyboardType = KeyboardType.Email,
            paddingBottom = 36.dp,
            type = InputFieldType.EMAIL,
        )

        PasswordInputField(
            label = stringResource(R.string.password),
            value = password,
            onValueChange = { inputPassword, validity ->
                password = inputPassword
                isPasswordValid = validity
            },
            keyboardType = KeyboardType.Password,
            paddingBottom = 36.dp,
            type = PasswordInputFieldType.PASSWORD,
        )

        PasswordInputField(
            label = stringResource(R.string.password_confirm),
            value = confirmPassword,
            onValueChange = { inputPassword, validity ->
                confirmPassword = inputPassword
                isConfirmPasswordValid = validity
            },
            keyboardType = KeyboardType.Password,
            paddingBottom = 36.dp,
            type = PasswordInputFieldType.PASSWORD_CONFIRM,
        )

        SignUpButton(
            buttonText = stringResource(R.string.sign_up),
            isEnable = isFormValid
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen()
}
