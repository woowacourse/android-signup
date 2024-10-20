package nextstep.signup.presentation.signup

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
    val passwordConfirmIsEmpty by remember(passwordConfirm) {
        mutableStateOf(passwordConfirm.isEmpty())
    }

    val passwordConfirmResult: PasswordConfirmResult by remember(
        password,
        passwordConfirm
    ) {
        mutableStateOf(PasswordConfirm.from(password, passwordConfirm))
    }
    SignUpTextField(
        modifier = modifier,
        labelText = labelText,
        value = passwordConfirm,
        onValueChange = onValueChange,
        isError = !passwordConfirmIsEmpty && passwordConfirmResult is PasswordConfirmResult.Failure,
        supportingText = { ErrorText(passwordConfirmResult) },
        keyboardType = KeyboardType.Password,
        visualTransformation = PasswordVisualTransformation()
    )
}

@Composable
private fun ErrorText(passwordConfirmResult: PasswordConfirmResult) {
    when (passwordConfirmResult) {
        is PasswordConfirmResult.EmptyField -> return
        is PasswordConfirmResult.Success -> return
        is PasswordConfirmResult.NotSamePasswordConfirm ->
            Text(text = stringResource(id = R.string.error_message_password_not_same))
    }
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
