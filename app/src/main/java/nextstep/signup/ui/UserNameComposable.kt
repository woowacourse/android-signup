package nextstep.signup.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.signup.R
import nextstep.signup.model.UserName
import nextstep.signup.model.UserNameValidResult
import nextstep.signup.ui.component.TextComponent
import nextstep.signup.ui.component.TextFieldComponent

private const val USERNAME_LENGTH_ERROR = "이름은 2~5자여야 합니다."
private const val USERNAME_FORM_ERROR = "이름에는 숫자나 기호가 포함될 수 없습니다."

@Composable
fun UserNameComposable(
    userName: UserName,
    onUserNameChange: (String) -> Unit,
) {
    TextFieldComponent(
        newValue = userName.userName,
        onValueChange = onUserNameChange,
        label = stringResource(R.string.main_user_name),
        supportingText = {
            val errorMessage = userName.getErrorMessage() ?: return@TextFieldComponent
            TextComponent(description = errorMessage)
        },
        isError = userName.isError(),
    )
    Spacer(modifier = Modifier.size(36.dp))
}

private fun UserName.getErrorMessage(): String? =
    when (this.validate()) {
        UserNameValidResult.Blank -> null
        UserNameValidResult.InvalidLength -> USERNAME_LENGTH_ERROR
        UserNameValidResult.InvalidCharacter -> USERNAME_FORM_ERROR
        else -> null
    }

@Preview(showBackground = true)
@Composable
private fun UserNameComposablePreview() {
    UserNameComposable(
        userName = UserName("해나"),
        onUserNameChange = {},
    )
}
