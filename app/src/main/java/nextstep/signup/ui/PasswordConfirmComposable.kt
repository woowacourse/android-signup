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
import nextstep.signup.model.PasswordConfirm
import nextstep.signup.model.PasswordConfirmValidResult
import nextstep.signup.ui.component.TextComponent
import nextstep.signup.ui.component.TextFieldComponent

private const val PASSWORD_CONFIRM_ERROR = "비밀번호가 일치하지 않습니다."

@Composable
fun PasswordConfirmComposable(
    password: Password,
    passwordConfirm: PasswordConfirm,
    onPasswordConfirmChange: (String) -> Unit,
) {
    TextFieldComponent(
        newValue = passwordConfirm.passwordConfirm,
        onValueChange = onPasswordConfirmChange,
        label = stringResource(R.string.main_password_confirm),
        supportingText = {
            val errorMessage = passwordConfirm.getErrorMessage(password.password) ?: return@TextFieldComponent
            TextComponent(description = errorMessage)
        },
        isError = passwordConfirm.isError(password.password),
        keyboardType = KeyboardType.Password,
    )
    Spacer(modifier = Modifier.size(42.dp))
}

private fun PasswordConfirm.getErrorMessage(password: String): String? =
    when (this.validate(password)) {
        PasswordConfirmValidResult.Blank -> null
        PasswordConfirmValidResult.Invalid -> PASSWORD_CONFIRM_ERROR
        else -> null
    }

class PasswordConfirmPreviewParameterProvider : PreviewParameterProvider<PasswordConfirm> {
    override val values =
        sequenceOf(
            PasswordConfirm("hannah0731"),
            PasswordConfirm("hannah"),
            PasswordConfirm(""),
        )
}

@Preview(showBackground = true)
@Composable
private fun PasswordConfirmComposablePreview(
    @PreviewParameter(PasswordConfirmPreviewParameterProvider::class)
    passwordConfirm: PasswordConfirm,
) {
    PasswordConfirmComposable(
        password = Password("hannah0731"),
        passwordConfirm = passwordConfirm,
        onPasswordConfirmChange = {},
    )
}
