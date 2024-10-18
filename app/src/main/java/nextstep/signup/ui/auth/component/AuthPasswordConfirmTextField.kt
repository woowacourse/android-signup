package nextstep.signup.ui.auth.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import nextstep.signup.R
import nextstep.signup.domain.PasswordConfirmValidateResult
import nextstep.signup.ui.auth.model.toErrorMessage


@Composable
internal fun AuthPasswordConfirmTextField(
    modifier: Modifier = Modifier,
    passwordConfirm: String,
    onPasswordConfirmChange: (String) -> Unit,
    passwordConfirmValidateResult: PasswordConfirmValidateResult,
    keyboardType: KeyboardType = KeyboardType.Password,
    imeAction: ImeAction = ImeAction.Next,
    onNext: () -> Unit = {},
    onDone: () -> Unit = {},
) {
    AuthTextField(
        modifier = modifier,
        label = stringResource(id = R.string.sign_up_password_confirm_form),
        text = passwordConfirm,
        isValid = passwordConfirmValidateResult.isValid,
        errorMessage = passwordConfirmValidateResult.toErrorMessage(),
        keyboardType = keyboardType,
        imeAction = imeAction,
        onTextChange = onPasswordConfirmChange,
        onNext = onNext,
        onDone = onDone
    )
}