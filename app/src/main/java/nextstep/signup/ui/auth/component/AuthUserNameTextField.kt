package nextstep.signup.ui.auth.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import nextstep.signup.R
import nextstep.signup.domain.UserNameValidateResult
import nextstep.signup.ui.auth.model.toErrorMessage


@Composable
internal fun AuthUserNameTextField(
    modifier: Modifier = Modifier,
    userName: String,
    onUserNameChange: (String) -> Unit,
    userNameValidateResult: UserNameValidateResult,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onNext: () -> Unit = {},
    onDone: () -> Unit = {},
) {
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