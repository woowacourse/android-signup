package nextstep.signup.presentation.signup

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import nextstep.signup.R
import nextstep.signup.domain.EmptyField
import nextstep.signup.domain.Failure
import nextstep.signup.domain.InvalidNameFormat
import nextstep.signup.domain.InvalidNameLength
import nextstep.signup.domain.Success
import nextstep.signup.domain.UserName

@Composable
fun UserNameTextField(
    modifier: Modifier = Modifier,
    name: String
) {
    SignUpTextField2(
        modifier = modifier,
        value = name,
        isError = when (UserName.from(name)) {
            is EmptyField -> false
            is Success -> false
            is Failure -> true
        },
        supportingText = {
            when (UserName.from(name)) {
                is EmptyField -> return@SignUpTextField2
                is Success -> return@SignUpTextField2
                is InvalidNameLength ->
                    Text(text = stringResource(id = R.string.error_message_user_name_invalid_length))

                is InvalidNameFormat ->
                    Text(text = stringResource(id = R.string.error_message_user_name_invalid_format))
            }
        }
    )
}

@Preview
@Composable
fun UsernameTextFieldPreview(
    @PreviewParameter(UsernamePreviewParameterProvider::class) username: String
) {
    UserNameTextField(
        name = username
    )
}

class UsernamePreviewParameterProvider : PreviewParameterProvider<String> {
    override val values = sequenceOf(
        // failure
        "a",
        "abcdefg",
        "a12",
        "12a",
        // success
        "ab",
        "qwert"
    )
}
