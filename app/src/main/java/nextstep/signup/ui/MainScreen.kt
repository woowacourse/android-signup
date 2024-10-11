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
import nextstep.signup.ui.theme.Blue50

data class InputState(
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val passwordConfirm: String = "",
)

@Composable
fun MainScreen() {
    var inputState by remember { mutableStateOf(InputState()) }

    Column {
        Spacer(modifier = Modifier.height(60.dp))
        CustomText(
            modifier = Modifier.fillMaxWidth(),
            titleResId = R.string.sign_up_title,
        )

        Spacer(modifier = Modifier.height(18.dp))
        CustomTextField(
            modifier = Modifier.padding(horizontal = 32.dp, vertical = 18.dp),
            value = inputState.username,
            onValueChange = { username -> inputState = inputState.copy(username = username) },
            labelResId = R.string.username_input,
        )
        CustomTextField(
            modifier = Modifier.padding(horizontal = 32.dp, vertical = 18.dp),
            value = inputState.email,
            onValueChange = { email -> inputState = inputState.copy(email = email) },
            labelResId = R.string.email_input,
        )
        CustomTextField(
            modifier = Modifier.padding(horizontal = 32.dp, vertical = 18.dp),
            value = inputState.password,
            onValueChange = { password -> inputState = inputState.copy(password = password) },
            labelResId = R.string.password_input,
            visualTransformation = PasswordVisualTransformation(),
        )
        CustomTextField(
            modifier = Modifier.padding(horizontal = 32.dp, vertical = 18.dp),
            value = inputState.passwordConfirm,
            onValueChange = { passwordConfirm ->
                inputState = inputState.copy(passwordConfirm = passwordConfirm)
            },
            labelResId = R.string.password_confirm_input,
            visualTransformation = PasswordVisualTransformation(),
        )

        Spacer(modifier = Modifier.height(24.dp))
        CustomButton(
            modifier = Modifier.padding(horizontal = 32.dp),
            shape = RoundedCornerShape(100.dp),
            buttonColors = ButtonDefaults.buttonColors(containerColor = Blue50),
            titleResId = R.string.sign_up_button,
            onClick = {},
        )
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}
