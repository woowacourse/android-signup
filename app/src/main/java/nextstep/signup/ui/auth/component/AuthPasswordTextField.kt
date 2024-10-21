package nextstep.signup.ui.auth.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import nextstep.signup.R
import nextstep.signup.domain.Password
import nextstep.signup.domain.PasswordValidateResult

@Composable
internal fun AuthPasswordTextField(
    password: String,
    onPasswordChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Password,
    imeAction: ImeAction = ImeAction.Next,
    onNext: () -> Unit = {},
    onDone: () -> Unit = {}
) {
    val passwordValidateResult = remember(password) {
        Password.validate(password)
    }
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

@Composable
@ReadOnlyComposable
fun PasswordValidateResult.toErrorMessage(): String? {
    return when (this) {
        PasswordValidateResult.Success -> null
        PasswordValidateResult.InValidBlank -> stringResource(id = R.string.password_error_blank)
        PasswordValidateResult.InValidNotInLength -> stringResource(
            id = R.string.password_error_length,
            Password.MIN_LENGTH,
            Password.MAX_LENGTH
        )

        PasswordValidateResult.InValidNotContainNumber -> stringResource(
            id = R.string.password_error_number
        )

        PasswordValidateResult.InValidNotContainAlpha -> stringResource(
            id = R.string.password_error_alpha
        )
    }
}
