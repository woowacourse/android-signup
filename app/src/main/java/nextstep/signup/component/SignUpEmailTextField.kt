package nextstep.signup.component

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import nextstep.signup.R
import nextstep.signup.domain.validation.Email
import nextstep.signup.domain.validation.ValidationResult

@Composable
internal fun SignUpEmailTextField(
    modifier: Modifier = Modifier,
    email: String,
    onEmailChange: (String) -> Unit
) {
    val validationResult = Email(email).validationResult()
    val supportingText = when (validationResult) {
        ValidationResult.INVALID_FORMAT -> stringResource(R.string.error_email_format)
        else -> ""
    }
    TextField(
        modifier = modifier,
        value = email,
        onValueChange = { onEmailChange(it) },
        label = { Text(stringResource(R.string.input_hint_email)) },
        singleLine = true,
        supportingText = { if (supportingText.isNotEmpty()) Text(text = supportingText) },
        isError = supportingText.isNotEmpty()
    )
}
