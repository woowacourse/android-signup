package nextstep.signup.ui.auth.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import nextstep.signup.R
import nextstep.signup.domain.PasswordValidateResult
import nextstep.signup.ui.auth.model.toErrorMessage

@Composable
internal fun AuthPasswordTextField(
    modifier: Modifier = Modifier,
    password: String,
    onPasswordChange: (String) -> Unit,
    passwordValidateResult: PasswordValidateResult,
    keyboardType: KeyboardType = KeyboardType.Password,
    imeAction: ImeAction = ImeAction.Next,
    onNext: () -> Unit = {},
    onDone: () -> Unit = {},
) {
    AuthTextField(
        modifier = modifier,
        label = stringResource(id = R.string.sign_up_password_form),
        text = password,
        isValid = passwordValidateResult.isValid,
        errorMessage = passwordValidateResult.toErrorMessage(),
        keyboardType = keyboardType,
        imeAction = imeAction,
        onTextChange = onPasswordChange,
        onNext = onNext,
        onDone = onDone
    )
}