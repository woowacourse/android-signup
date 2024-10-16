package nextstep.signup.ui

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
import nextstep.signup.ui.theme.Blue50
import nextstep.signup.ui.theme.SignupTheme

@Composable
fun SignUpScreen() {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordConfirm by remember { mutableStateOf("") }

    val user = User(
        name = name,
        email = email,
        password = password,
        passwordConfirm = passwordConfirm
    )

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
            value = user.name,
            onValueChange = { name = it },
            label = stringResource(R.string.user_name)
        )

        Spacer(modifier = Modifier.height(36.dp))
        CustomTextField(
            value = user.email,
            onValueChange = { email = it },
            label = stringResource(R.string.user_email),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            )
        )

        Spacer(modifier = Modifier.height(36.dp))
        CustomPasswordTextField(
            value = user.password,
            onValueChange = { password = it },
            label = stringResource(R.string.user_password)
        )

        Spacer(modifier = Modifier.height(36.dp))
        CustomPasswordTextField(
            value = user.passwordConfirm,
            onValueChange = { passwordConfirm = it },
            label = stringResource(R.string.user_password_confirm)
        )

        Spacer(modifier = Modifier.height(42.dp))
        CustomButton(
            onClick = {},
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
