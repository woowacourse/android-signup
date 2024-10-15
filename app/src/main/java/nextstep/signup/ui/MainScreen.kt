package nextstep.signup.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.signup.R
import nextstep.signup.componet.CustomButton
import nextstep.signup.componet.CustomText
import nextstep.signup.componet.CustomTextField
import nextstep.signup.model.Email
import nextstep.signup.model.Password
import nextstep.signup.model.UserName
import nextstep.signup.ui.theme.Blue50

@Composable
fun MainScreen() {
    var mainState by remember { mutableStateOf(MainState()) }

    Column {
        Spacer(modifier = Modifier.height(60.dp))
        CustomText(
            modifier = Modifier.fillMaxWidth(),
            titleResId = R.string.sign_up_title,
        )

        Spacer(modifier = Modifier.height(18.dp))
        CustomTextField(
            modifier = Modifier.padding(horizontal = 32.dp, vertical = 18.dp),
            value = mainState.username.value,
            onValueChange = { value -> mainState = mainState.copy(username = UserName(value)) },
            labelResId = R.string.username_input,
            inputValidation = mainState.username.validate(),
        )
        CustomTextField(
            modifier = Modifier.padding(horizontal = 32.dp, vertical = 18.dp),
            value = mainState.email.value,
            onValueChange = { value -> mainState = mainState.copy(email = Email(value)) },
            labelResId = R.string.email_input,
            inputValidation = mainState.email.validate(),
        )
        CustomTextField(
            modifier = Modifier.padding(horizontal = 32.dp, vertical = 18.dp),
            value = mainState.password.value,
            onValueChange = { value ->
                mainState = mainState.copy(password = Password(value))
            },
            labelResId = R.string.password_input,
            visualTransformation = PasswordVisualTransformation(),
            inputValidation = mainState.password.validate(),
        )
        CustomTextField(
            modifier = Modifier.padding(horizontal = 32.dp, vertical = 18.dp),
            value = mainState.passwordConfirm.value,
            onValueChange = { value ->
                mainState = mainState.copy(passwordConfirm = Password(value))
            },
            labelResId = R.string.password_confirm_input,
            visualTransformation = PasswordVisualTransformation(),
            inputValidation = mainState.passwordConfirm.validateConfirmation(mainState.password),
        )

        Spacer(modifier = Modifier.height(24.dp))
        CustomButton(
            modifier = Modifier.padding(horizontal = 32.dp),
            shape = RoundedCornerShape(100.dp),
            buttonColors = ButtonDefaults.buttonColors(containerColor = Blue50),
            titleResId = R.string.sign_up_button,
            enabled = mainState.signUpEnabled,
            onClick = {},
        )
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}
