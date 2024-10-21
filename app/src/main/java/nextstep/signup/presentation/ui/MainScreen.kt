package nextstep.signup.presentation.ui

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.signup.R
import nextstep.signup.domain.Email
import nextstep.signup.domain.Password
import nextstep.signup.domain.UserName
import nextstep.signup.presentation.componet.CustomButton
import nextstep.signup.presentation.componet.CustomText
import nextstep.signup.presentation.componet.CustomTextField
import nextstep.signup.presentation.ui.theme.Blue50

@Composable
fun MainScreen() {
    var signUpState by remember { mutableStateOf(SignUpState()) }

    Column {
        Spacer(modifier = Modifier.height(60.dp))
        CustomText(
            modifier = Modifier.fillMaxWidth(),
            title = stringResource(R.string.sign_up_title),
        )

        Spacer(modifier = Modifier.height(18.dp))
        CustomTextField(
            modifier = Modifier.padding(horizontal = 32.dp, vertical = 18.dp),
            value = signUpState.username.value,
            onValueChange = { value -> signUpState = signUpState.copy(username = UserName(value)) },
            label = stringResource(id = R.string.username_input),
            inputValidation = signUpState.username.validate(),
        )
        CustomTextField(
            modifier = Modifier.padding(horizontal = 32.dp, vertical = 18.dp),
            value = signUpState.email.value,
            onValueChange = { value -> signUpState = signUpState.copy(email = Email(value)) },
            label = stringResource(id = R.string.email_input),
            inputValidation = signUpState.email.validate(),
        )
        CustomTextField(
            modifier = Modifier.padding(horizontal = 32.dp, vertical = 18.dp),
            value = signUpState.password.value,
            onValueChange = { value ->
                signUpState = signUpState.copy(password = Password(value))
            },
            label = stringResource(id = R.string.password_input),
            visualTransformation = PasswordVisualTransformation(),
            inputValidation = signUpState.password.validate(),
        )
        CustomTextField(
            modifier = Modifier.padding(horizontal = 32.dp, vertical = 18.dp),
            value = signUpState.passwordConfirm.value,
            onValueChange = { value ->
                signUpState = signUpState.copy(passwordConfirm = Password(value))
            },
            label = stringResource(id = R.string.password_confirm_input),
            visualTransformation = PasswordVisualTransformation(),
            inputValidation = signUpState.passwordConfirm.validateConfirmation(signUpState.password),
        )

        Spacer(modifier = Modifier.height(24.dp))
        CustomButton(
            modifier = Modifier.padding(horizontal = 32.dp),
            shape = RoundedCornerShape(100.dp),
            buttonColors = ButtonDefaults.buttonColors(containerColor = Blue50),
            buttonTitle = stringResource(R.string.sign_up_button),
            enabled = signUpState.enabled,
            onClick = {},
        )
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}
