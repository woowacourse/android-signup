package nextstep.signup.presentation.signup

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import nextstep.signup.R
import nextstep.signup.domain.Email
import nextstep.signup.domain.EmailResult

@Composable
fun EmailTextField(
    modifier: Modifier = Modifier,
    labelText: String = stringResource(R.string.default_text_field_label),
    onValueChange: (String) -> Unit,
    email: String
) {
    SignUpTextField(
        modifier = modifier,
        labelText = labelText,
        value = email,
        onValueChange = onValueChange,
        keyboardType = KeyboardType.Email,
        isError = Email.from(email) is EmailResult.Failure,
        supportingText = {
            when (Email.from(input = email)) {
                is EmailResult.EmptyField -> return@SignUpTextField
                is EmailResult.Success -> return@SignUpTextField
                is EmailResult.InvalidNameFormat -> Text(text = stringResource(id = R.string.error_message_email_invalid_format))
            }
        }
    )
}

@Preview
@Composable
fun EmailTextFieldPreview(
    @PreviewParameter(EmailPreviewParameter::class) email: String
) {
    EmailTextField(
        email = email,
        onValueChange = {}
    )
}

class EmailPreviewParameter : PreviewParameterProvider<String> {
    override val values = sequenceOf(
        // failure
        "qwer",
        "qwer@",
        "qwer.com",
        "qwer@wooteco com",
        // success
        "qwer@wooteco.com",
        "qwert13@wooteco.net"
    )
}
