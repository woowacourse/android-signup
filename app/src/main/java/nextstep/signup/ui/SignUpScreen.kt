package nextstep.signup.ui

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.signup.R
import nextstep.signup.component.CustomButton
import nextstep.signup.component.CustomPasswordTextField
import nextstep.signup.component.CustomTextField
import nextstep.signup.component.TitleText
import nextstep.signup.model.Email
import nextstep.signup.model.InputValidation
import nextstep.signup.model.Name
import nextstep.signup.model.Password
import nextstep.signup.model.PasswordConfirm
import nextstep.signup.model.User
import nextstep.signup.ui.theme.Blue50
import nextstep.signup.ui.theme.SignupTheme
import nextstep.signup.ui.theme.gray50

@Composable
fun SignUpScreen() {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordConfirm by remember { mutableStateOf("") }

    val nameModel by rememberUpdatedState(Name(name))
    val emailModel by rememberUpdatedState(Email(email))
    val passwordModel by rememberUpdatedState(Password(password))
    val passwordConfirmModel by rememberUpdatedState(PasswordConfirm(password, passwordConfirm))

    val user by remember {
        derivedStateOf {
            User(nameModel, emailModel, passwordModel, passwordConfirmModel)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp)
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        TitleText(
            title = stringResource(R.string.sign_up_title)
        )

        Spacer(modifier = Modifier.height(40.dp))

        InputField(
            value = name,
            onValueChange = { name = it },
            model = nameModel,
            label = stringResource(R.string.user_name)
        )

        Spacer(modifier = Modifier.height(36.dp))

        InputField(
            value = email,
            onValueChange = { email = it },
            model = emailModel,
            label = stringResource(R.string.user_email),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier.height(36.dp))

        PasswordInputField(
            value = password,
            onValueChange = {
                password = it
                passwordConfirmModel.setValue(password, passwordConfirm)
            },
            model = passwordModel,
            label = stringResource(R.string.user_password)
        )

        Spacer(modifier = Modifier.height(36.dp))

        PasswordInputField(
            value = passwordConfirm,
            onValueChange = { passwordConfirm = it },
            model = passwordConfirmModel,
            label = stringResource(R.string.user_password_confirm)
        )

        Spacer(modifier = Modifier.height(42.dp))

        CustomButton(
            onClick = {
                if (user.isInValid()) {
                    Log.d("SignUpScreen", "회원가입 실패")
                } else {
                    Log.d("SignUpScreen", "회원가입 성공")
                }
            },
            buttonText = stringResource(R.string.sign_up_button),
            colors = ButtonDefaults.buttonColors(containerColor = if (user.isInValid()) gray50 else Blue50)
        )
    }
}

@Composable
fun InputField(
    value: String,
    onValueChange: (String) -> Unit,
    model: InputValidation,
    label: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    CustomTextField(
        value = value,
        onValueChange = onValueChange,
        label = label,
        isError = model.isInValid(),
        errorMessage = model.getErrorMessage(),
        keyboardOptions = keyboardOptions
    )
}

@Composable
fun PasswordInputField(
    value: String,
    onValueChange: (String) -> Unit,
    model: InputValidation,
    label: String
) {
    CustomPasswordTextField(
        value = value,
        onValueChange = onValueChange,
        isError = model.isInValid(),
        errorMessage = model.getErrorMessage(),
        label = label
    )
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignupTheme {
        SignUpScreen()
    }
}
