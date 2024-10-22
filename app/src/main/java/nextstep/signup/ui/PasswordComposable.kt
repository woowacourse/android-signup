package nextstep.signup.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import nextstep.signup.R
import nextstep.signup.model.Password
import nextstep.signup.model.PasswordValidResult
import nextstep.signup.ui.component.TextComponent
import nextstep.signup.ui.component.TextFieldComponent

private const val PASSWORD_LENGTH_ERROR = "비밀번호는 8~16자여야 합니다."
private const val PASSWORD_FORM_ERROR = "비밀번호는 영문과 숫자를 포함해야 합니다."

@Composable
fun PasswordComposable(
    password: Password,
    onPasswordChange: (String) -> Unit,
) {
    TextFieldComponent(
        newValue = password.password,
        onValueChange = onPasswordChange,
        label = stringResource(R.string.main_password),
        supportingText = {
            val errorMessage = password.getErrorMessage() ?: return@TextFieldComponent
            TextComponent(description = errorMessage)
        },
        isError = password.isError(),
        keyboardType = KeyboardType.Password,
    )
    Spacer(modifier = Modifier.size(36.dp))
}

private fun Password.getErrorMessage(): String? =
    when (this.validate()) {
        PasswordValidResult.Blank -> null
        PasswordValidResult.InvalidLength -> PASSWORD_LENGTH_ERROR
        PasswordValidResult.InvalidCharacter -> PASSWORD_FORM_ERROR
        else -> null
    }

class PasswordPreviewParameterProvider : PreviewParameterProvider<Password> {
    override val values =
        sequenceOf(
            Password("gonghyeyeon"),
            Password("12345678"),
            Password("hannah0731"),
            Password("hye731"),
            Password("hannahhannah07310731"),
            Password(""),
            Password("hannah0731#"),
        )
}

@Preview(showBackground = true)
@Composable
private fun PasswordComposablePreview(
    @PreviewParameter(PasswordPreviewParameterProvider::class)
    password: Password,
) {
    PasswordComposable(
        password = password,
        onPasswordChange = {},
    )
}
