package nextstep.signup.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.signup.R
import nextstep.signup.component.CustomButton
import nextstep.signup.component.CustomTextField
import nextstep.signup.component.TitleText
import nextstep.signup.ui.theme.Blue50
import nextstep.signup.ui.theme.SignupTheme

@Composable
fun SignUpScreen() {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordCheck by remember { mutableStateOf("") }

    val user = User(
        name = name,
        email = email,
        password = password,
        passwordCheck = passwordCheck
    )

    Column {
        Spacer(modifier = Modifier.height(60.dp))
        TitleText(
            modifier = Modifier.fillMaxWidth(),
            titleResId = R.string.sign_up_title,
        )

        Spacer(modifier = Modifier.height(4.dp))

        CustomTextField(
            value = user.name,
            onValueChange = { name = it },
            labelResId = R.string.user_name,
        )

        CustomTextField(
            value = user.email,
            onValueChange = { email = it },
            labelResId = R.string.user_email,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
        )

        CustomTextField(
            value = user.password,
            onValueChange = { password = it },
            labelResId = R.string.user_password,
            isPassword = true,
        )

        CustomTextField(
            value = user.passwordCheck,
            onValueChange = { passwordCheck = it },
            labelResId = R.string.user_password_confirm,
            isPassword = true,
        )

        Spacer(modifier = Modifier.height(42.dp))

        CustomButton(
            onClick = {},
            titleResId = R.string.sign_up_button,
            colors = ButtonDefaults.buttonColors(containerColor = Blue50),
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
