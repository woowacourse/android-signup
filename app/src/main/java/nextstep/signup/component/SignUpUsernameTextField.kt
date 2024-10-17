package nextstep.signup.component

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import nextstep.signup.R
import nextstep.signup.domain.validation.Username
import nextstep.signup.domain.validation.ValidationResult

@Composable
internal fun SignUpUsernameTextField(
    modifier: Modifier = Modifier,
    username: String,
    onUsernameChange: (String) -> Unit
) {
    val validationResult = Username(username).validationResult()
    val supportingText = when (validationResult) {
        ValidationResult.INVALID_LENGTH -> stringResource(R.string.error_name_length)
        ValidationResult.INVALID_FORMAT -> stringResource(R.string.error_name_format)
        else -> ""
    }

    TextField(
        modifier = modifier,
        value = username,
        onValueChange = { onUsernameChange(it) },
        label = { Text(stringResource(R.string.input_hint_username)) },
        singleLine = true,
        supportingText = { if (supportingText.isNotEmpty()) Text(text = supportingText) },
        isError = supportingText.isNotEmpty()
    )
}
