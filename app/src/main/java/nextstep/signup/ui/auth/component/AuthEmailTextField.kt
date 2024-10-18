package nextstep.signup.ui.auth.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import nextstep.signup.R
import nextstep.signup.domain.EmailValidateResult
import nextstep.signup.ui.auth.model.toErrorMessage


@Composable
internal fun AuthEmailTextField(
    modifier: Modifier = Modifier,
    email: String,
    onEmailChange: (String) -> Unit,
    emailValidateResult: EmailValidateResult,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onNext: () -> Unit = {},
    onDone: () -> Unit = {},
) {
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

class EmailPreviewParamsProvider : PreviewParameterProvider<Pair<String, EmailValidateResult>> {
    override val values: Sequence<Pair<String, EmailValidateResult>>
        get() = sequenceOf(
            "sample@gmail.com" to EmailValidateResult.Success,
            "  " to EmailValidateResult.InvalidBlank,
            "asd" to EmailValidateResult.InvalidEmailFormat,
        )
}

@Composable
@Preview(showBackground = true)
private fun AuthEmailTextFieldPreview(
    @PreviewParameter(EmailPreviewParamsProvider::class)
    params: Pair<String, EmailValidateResult>
) {
    val (email, emailValidateResult) = params
    AuthEmailTextField(
        email = email,
        onEmailChange = {},
        emailValidateResult = emailValidateResult
    )
}
