package nextstep.signup.presentation.signup

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import nextstep.signup.R
import nextstep.signup.domain.Email2
import nextstep.signup.domain.EmailResult

@Composable
fun EmailTextField(
    modifier: Modifier = Modifier,
    email: String
) {
    SignUpTextField2(
        modifier = modifier,
        value = email,
        isError = when (Email2.from(input = email)) {
            is EmailResult.EmptyField -> false
            is EmailResult.Success -> false
            is EmailResult.Failure -> true
        },
        supportingText = {
            when (Email2.from(input = email)) {
                is EmailResult.EmptyField -> return@SignUpTextField2
                is EmailResult.Success -> return@SignUpTextField2
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
        email = email
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
