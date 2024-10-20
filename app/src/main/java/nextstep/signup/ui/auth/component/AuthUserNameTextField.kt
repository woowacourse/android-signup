package nextstep.signup.ui.auth.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import nextstep.signup.R
import nextstep.signup.domain.UserName
import nextstep.signup.domain.UserNameValidateResult

@Composable
internal fun AuthUserNameTextField(
    modifier: Modifier = Modifier,
    userName: String,
    onUserNameChange: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onNext: () -> Unit = {},
    onDone: () -> Unit = {}
) {
    val userNameValidateResult = remember(userName) {
        UserName.validate(userName)
    }
    AuthTextField(
        modifier = modifier,
        label = stringResource(id = R.string.sign_up_user_name_form),
        text = userName,
        isValid = userNameValidateResult.isValid,
        errorMessage = userNameValidateResult.toErrorMessage(),
        keyboardType = keyboardType,
        imeAction = imeAction,
        onTextChange = onUserNameChange,
        onNext = onNext,
        onDone = onDone
    )
}

@Composable
fun UserNameValidateResult.toErrorMessage(): String? {
    return when (this) {
        UserNameValidateResult.Success -> null
        UserNameValidateResult.InvalidBlank -> stringResource(id = R.string.user_name_error_blank)
        UserNameValidateResult.InvalidContainNumber -> stringResource(
            id = R.string.user_name_error_number
        )

        UserNameValidateResult.InvalidContainSpecialCharacter -> stringResource(
            id = R.string.user_name_error_special_character
        )

        UserNameValidateResult.InvalidOutOfLength -> stringResource(
            id = R.string.user_name_error_length,
            UserName.MIN_LENGTH,
            UserName.MAX_LENGTH
        )
    }
}
