package nextstep.signup.presentation.signup

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import nextstep.signup.R
import nextstep.signup.domain.UserName
import nextstep.signup.domain.UserNameResult

@Composable
fun UserNameTextField(
    modifier: Modifier = Modifier,
    name: String,
    onValueChange: (String) -> Unit,
    labelText: String = stringResource(R.string.default_text_field_label)
) {
    SignUpTextField(
        modifier = modifier,
        labelText = labelText,
        value = name,
        onValueChange = onValueChange,
        isError = UserName.from(name) is UserNameResult.Failure,
        supportingText = {
            when (UserName.from(name)) {
                is UserNameResult.EmptyField -> return@SignUpTextField
                is UserNameResult.Success -> return@SignUpTextField
                is UserNameResult.InvalidNameLength ->
                    Text(text = stringResource(id = R.string.error_message_user_name_invalid_length))

                is UserNameResult.InvalidNameFormat ->
                    Text(text = stringResource(id = R.string.error_message_user_name_invalid_format))
            }
        }
    )
}

@Preview
@Composable
fun UsernameTextFieldPreview(
    @PreviewParameter(UsernamePreviewParameter::class) username: String
) {
    UserNameTextField(
        name = username,
        onValueChange = {}
    )
}

class UsernamePreviewParameter : PreviewParameterProvider<String> {
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
