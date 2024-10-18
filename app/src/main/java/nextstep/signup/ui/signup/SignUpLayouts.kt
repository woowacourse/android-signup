package nextstep.signup.ui.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.signup.R
import nextstep.signup.domain.Email
import nextstep.signup.domain.Password
import nextstep.signup.domain.Username
import nextstep.signup.ui.common.button.StateButton
import nextstep.signup.ui.common.textfield.InputType
import nextstep.signup.ui.common.textfield.SingleLineTextInput
import nextstep.signup.ui.common.textfield.validateEmailInput
import nextstep.signup.ui.common.textfield.validatePasswordConfirmInput
import nextstep.signup.ui.common.textfield.validatePasswordInput
import nextstep.signup.ui.common.textfield.validateUsernameInput
import nextstep.signup.ui.signup.SignUpValidator.validateEmail
import nextstep.signup.ui.signup.SignUpValidator.validatePassword
import nextstep.signup.ui.signup.SignUpValidator.validateUsername
import nextstep.signup.ui.theme.SignUpTheme
import nextstep.signup.ui.theme.Typography

@Composable
fun SignUpTitle() {
    Text(
        text = stringResource(id = R.string.signup_title),
        style = Typography.titleLarge,
    )
}

@Composable
fun SignUpInteractionLayer(onButtonClicked: () -> Unit) {
    val textFieldModifier = Modifier.fillMaxWidth()

    var username by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordConfirm by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxHeight(0.8f),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SingleLineTextInput(
            modifier = textFieldModifier,
            value = username,
            onValueChange = { username = it },
            label = stringResource(id = R.string.signup_username),
            inputType = InputType.Username,
            validateInput = { validateUsername(Username(username)) },
        )
        SingleLineTextInput(
            modifier = textFieldModifier,
            value = email,
            onValueChange = { email = it },
            label = stringResource(id = R.string.signup_email),
            inputType = InputType.Email,
            validateInput = { validateEmail(Email(email)) },
        )
        SingleLineTextInput(
            modifier = textFieldModifier,
            value = password,
            onValueChange = { password = it },
            label = stringResource(id = R.string.signup_password),
            inputType = InputType.Password,
            validateInput = { validatePassword(Password(password)) },
        )
        SingleLineTextInput(
            modifier = textFieldModifier,
            value = passwordConfirm,
            onValueChange = { passwordConfirm = it },
            label = stringResource(id = R.string.signup_password_confirm),
            inputType = InputType.Password,
            validateInput = { validatePasswordConfirmInput(password, passwordConfirm) },
        )
        StateButton(
            modifier = textFieldModifier.requiredHeight(50.dp),
            text = stringResource(id = R.string.signup_signup),
        ) {
            onButtonClicked()
        }
    }
}

@Composable
fun SignUpLayout(onButtonClicked: () -> Unit) {
    Column(
        modifier =
        Modifier
            .fillMaxHeight(0.7f)
            .padding(32.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SignUpTitle()
        SignUpInteractionLayer {
            onButtonClicked()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpLayoutPreview() {
    SignUpTheme {
        Surface(
            modifier =
            Modifier
                .fillMaxSize()
                .padding(32.dp),
        ) {
            SignUpInteractionLayer {}
        }
    }
}
