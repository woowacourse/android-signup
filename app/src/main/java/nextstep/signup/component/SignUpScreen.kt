package nextstep.signup.component

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
import nextstep.signup.model.InputFieldType

@Composable
fun SignUpScreen() {
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(16.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        var userName by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var confirmPassword by remember { mutableStateOf("") }
        TitleText(stringResource(R.string.title))

        Spacer(modifier = Modifier.height(16.dp))

        InputField(
            label = stringResource(R.string.sign_up),
            value = userName,
            onValueChange = { userName = it },
            isPasswordInputField = false,
            keyboardType = KeyboardType.Text,
            paddingBottom = 36.dp,
            type = InputFieldType.USER_NAME,
        )

        InputField(
            label = stringResource(R.string.email),
            value = email,
            onValueChange = { email = it },
            isPasswordInputField = false,
            keyboardType = KeyboardType.Email,
            paddingBottom = 36.dp,
            type = InputFieldType.EMAIL,
        )

        InputField(
            label = stringResource(R.string.password),
            value = password,
            onValueChange = { password = it },
            isPasswordInputField = true,
            keyboardType = KeyboardType.Password,
            paddingBottom = 36.dp,
            type = InputFieldType.PASSWORD,
        )

        InputField(
            label = stringResource(R.string.password_confirm),
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            isPasswordInputField = true,
            keyboardType = KeyboardType.Password,
            paddingBottom = 36.dp,
            type = InputFieldType.PASSWORD_CONFIRM,
        )

        SignUpButton(stringResource(R.string.sign_up))
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen()
}
