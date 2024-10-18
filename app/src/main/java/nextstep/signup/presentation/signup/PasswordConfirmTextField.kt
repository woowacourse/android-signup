package nextstep.signup.presentation.signup

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import nextstep.signup.R
import nextstep.signup.domain.PasswordConfirm
import nextstep.signup.domain.PasswordConfirmResult

@Composable
fun PasswordConfirmTextField(
    modifier: Modifier = Modifier,
    password: String,
    passwordConfirm: String,
    onValueChange: (String) -> Unit,
    labelText: String = stringResource(R.string.default_text_field_label)
) {
    SignUpTextField2(
        modifier = modifier,
        labelText = labelText,
        value = passwordConfirm,
        onValueChange = onValueChange,
        isError = when (PasswordConfirm.from(password, passwordConfirm)) {
            is PasswordConfirmResult.EmptyField -> false
            is PasswordConfirmResult.Success -> false
            is PasswordConfirmResult.Failure -> true
        },
        supportingText = {
            when (PasswordConfirm.from(password, passwordConfirm)) {
                is PasswordConfirmResult.EmptyField -> return@SignUpTextField2
                is PasswordConfirmResult.Success -> return@SignUpTextField2
                is PasswordConfirmResult.NotSamePasswordConfirm ->
                    Text(text = stringResource(id = R.string.error_message_password_not_same))
            }
        },
        keyboardType = KeyboardType.Password,
        visualTransformation = PasswordVisualTransformation()
    )
}

@Preview
@Composable
fun PasswordTextFieldPreview(
    @PreviewParameter(PasswordConfirmPreviewParameter::class) passwordWithConfirm: PasswordWithConfirm
) {
    PasswordConfirmTextField(
        password = passwordWithConfirm.password,
        passwordConfirm = passwordWithConfirm.passwordConfirm,
        onValueChange = {},
        labelText = stringResource(id = R.string.sign_up_password_confirm_label)
    )
}

class PasswordConfirmPreviewParameter : PreviewParameterProvider<PasswordWithConfirm> {
    override val values = sequenceOf(
        // empty
        PasswordWithConfirm("a", ""),
        // not same
        PasswordWithConfirm("abcd1234", "abcd12345"),
        // success
        PasswordWithConfirm("abcd1234", "abcd1234")
    )
}

data class PasswordWithConfirm(
    val password: String,
    val passwordConfirm: String
)
