package nextstep.signup.ui.auth.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import nextstep.signup.R
import nextstep.signup.domain.PasswordConfirm
import nextstep.signup.domain.PasswordConfirmValidateResult

@Composable
internal fun AuthPasswordConfirmTextField(
    password: String,
    passwordConfirm: String,
    onPasswordConfirmChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Password,
    imeAction: ImeAction = ImeAction.Next,
    onNext: () -> Unit = {},
    onDone: () -> Unit = {}
) {
    val passwordConfirmValidateResult = remember(password, passwordConfirm) {
        PasswordConfirm.validate(
            password = password,
            passwordConfirm = passwordConfirm
        )
    }
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

@Composable
@ReadOnlyComposable
fun PasswordConfirmValidateResult.toErrorMessage(): String? {
    return when (this) {
        PasswordConfirmValidateResult.Success -> null
        PasswordConfirmValidateResult.InValid -> stringResource(
            id = R.string.password_confirm_error
        )
    }
}
