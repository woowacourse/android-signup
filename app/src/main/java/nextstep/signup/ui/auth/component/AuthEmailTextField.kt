package nextstep.signup.ui.auth.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import nextstep.signup.R
import nextstep.signup.domain.Email
import nextstep.signup.domain.EmailValidateResult

@Composable
internal fun AuthEmailTextField(
    modifier: Modifier = Modifier,
    email: String,
    onEmailChange: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onNext: () -> Unit = {},
    onDone: () -> Unit = {}
) {
    val emailValidateResult = remember(email) {
        Email.validate(email)
    }
    AuthTextField(
        modifier = modifier,
        label = stringResource(id = R.string.sign_up_email_form),
        text = email,
        isValid = emailValidateResult.isValid,
        errorMessage = emailValidateResult.toErrorMessage(),
        keyboardType = keyboardType,
        imeAction = imeAction,
        onTextChange = onEmailChange,
        onNext = onNext,
        onDone = onDone
    )
}

@Composable
@ReadOnlyComposable
fun EmailValidateResult.toErrorMessage(): String? {
    return when (this) {
        EmailValidateResult.Success -> null
        EmailValidateResult.InvalidBlank -> stringResource(id = R.string.email_error_blank)
        EmailValidateResult.InvalidEmailFormat -> stringResource(id = R.string.email_error_format)
    }
}

class EmailPreviewParamsProvider : PreviewParameterProvider<String> {
    override val values: Sequence<String>
        get() = sequenceOf(
            "sample@gmail.com",
            "  ",
            "asd"
        )
}

@Composable
@Preview(showBackground = true)
private fun AuthEmailTextFieldPreview(
    @PreviewParameter(EmailPreviewParamsProvider::class)
    email: String
) {
    AuthEmailTextField(
        email = email,
        onEmailChange = {}
    )
}
