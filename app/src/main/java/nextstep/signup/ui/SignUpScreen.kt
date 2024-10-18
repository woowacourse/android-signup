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
import nextstep.signup.component.CustomButton
import nextstep.signup.component.CustomPasswordTextField
import nextstep.signup.component.CustomTextField
import nextstep.signup.component.TitleText
import nextstep.signup.model.Email
import nextstep.signup.model.Name
import nextstep.signup.model.Password
import nextstep.signup.model.PasswordConfirm
import nextstep.signup.model.User
import nextstep.signup.ui.theme.Blue50
import nextstep.signup.ui.theme.SignupTheme

@Composable
fun SignUpScreen() {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordConfirm by remember { mutableStateOf("") }

    var nameModel = Name(name)
    var emailModel = Email(email)
    var passwordModel = Password(password)
    var passwordConfirmModel = PasswordConfirm(password, passwordConfirm)

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
        CustomTextField(
            value = name,
            onValueChange = { newName ->
                name = newName
                nameModel = Name(newName)
            },
            label = stringResource(R.string.user_name),
            isError = nameModel.isInValid(),
            errorMessage = nameModel.getErrorMessage()
        )

        Spacer(modifier = Modifier.height(36.dp))
        CustomTextField(
            value = email,
            onValueChange = { newEmail ->
                email = newEmail
                emailModel = Email(newEmail)
            },
            label = stringResource(R.string.user_email),
            isError = emailModel.isInValid(),
            errorMessage = emailModel.getErrorMessage(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier.height(36.dp))
        CustomPasswordTextField(
            value = password,
            onValueChange = { newPassword ->
                password = newPassword
                passwordModel = Password(newPassword)
                passwordConfirmModel = PasswordConfirm(newPassword, passwordConfirm)
            },
            isError = passwordModel.isInValid(),
            errorMessage = passwordModel.getErrorMessage(),
            label = stringResource(R.string.user_password)
        )

        Spacer(modifier = Modifier.height(36.dp))
        CustomPasswordTextField(
            value = passwordConfirm,
            onValueChange = { newPasswordConfirm ->
                passwordConfirm = newPasswordConfirm
                passwordConfirmModel = PasswordConfirm(password, newPasswordConfirm)
            },
            isError = passwordConfirmModel.isInValid(),
            errorMessage = passwordConfirmModel.getErrorMessage(),
            label = stringResource(R.string.user_password_confirm)
        )

        Spacer(modifier = Modifier.height(42.dp))
        CustomButton(
            onClick = {
                val user = User(nameModel, emailModel, passwordModel, passwordConfirmModel)
                if (user.isInValid()) {
                    Log.d("SignUpScreen", "회원가입 실패")
                } else {
                    Log.d("SignUpScreen", "회원가입 성공")
                }
            },
            buttonText = stringResource(R.string.sign_up_button),
            colors = ButtonDefaults.buttonColors(containerColor = Blue50)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignupTheme {
        SignUpScreen()
    }
}
