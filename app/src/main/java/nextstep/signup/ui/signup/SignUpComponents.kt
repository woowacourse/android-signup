package nextstep.signup.ui.signup

import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import nextstep.signup.R
import nextstep.signup.domain.Email
import nextstep.signup.domain.Password
import nextstep.signup.domain.PasswordConfirm
import nextstep.signup.domain.Username
import nextstep.signup.ui.common.button.StateButton
import nextstep.signup.ui.common.textfield.InputType
import nextstep.signup.ui.common.textfield.SingleLineTextInput
import nextstep.signup.ui.signup.SignUpValidator.getValidationMessage
import nextstep.signup.ui.theme.Typography

@Composable
fun SignUpTitle() {
    Text(
        text = stringResource(id = R.string.signup_title),
        style = Typography.titleLarge,
    )
}

@Composable
fun UsernameInput(
    modifier: Modifier = Modifier,
    username: Username,
    onUsernameChanged: (String) -> Unit,
) {
    SingleLineTextInput(
        modifier = modifier,
        value = username.value,
        onValueChange = onUsernameChanged,
        label = stringResource(id = R.string.signup_username),
        inputType = InputType.Username,
        supportingText = username.getValidationMessage(),
    )
}

@Composable
fun EmailInput(
    modifier: Modifier = Modifier,
    email: Email,
    onEmailChanged: (String) -> Unit,
) {
    SingleLineTextInput(
        modifier = modifier,
        value = email.value,
        onValueChange = onEmailChanged,
        label = stringResource(id = R.string.signup_email),
        inputType = InputType.Email,
        supportingText = email.getValidationMessage(),
    )
}

@Composable
fun PasswordInput(
    modifier: Modifier = Modifier,
    password: Password,
    onPasswordChanged: (String) -> Unit,
) {
    SingleLineTextInput(
        modifier = modifier,
        value = password.value,
        onValueChange = onPasswordChanged,
        label = stringResource(id = R.string.signup_password),
        inputType = InputType.Password,
        supportingText = password.getValidationMessage(),
    )
}

@Composable
fun PasswordConfirmInput(
    modifier: Modifier = Modifier,
    password: Password,
    passwordConfirm: PasswordConfirm,
    onPasswordConfirmChanged: (String) -> Unit,
) {
    SingleLineTextInput(
        modifier = modifier,
        value = passwordConfirm.value,
        onValueChange = onPasswordConfirmChanged,
        label = stringResource(id = R.string.signup_password_confirm),
        inputType = InputType.Password,
        supportingText = passwordConfirm.getValidationMessage(password.value),
    )
}

@Composable
fun SignUpButton(
    modifier: Modifier = Modifier,
    isSignUpAvailiable: Boolean,
    onButtonClicked: () -> Unit,
) {
    StateButton(
        modifier = modifier.requiredHeight(50.dp),
        text = stringResource(id = R.string.signup_signup),
        enabled = isSignUpAvailiable,
    ) {
        onButtonClicked()
    }
}
