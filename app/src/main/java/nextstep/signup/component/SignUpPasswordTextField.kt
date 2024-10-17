package nextstep.signup.component

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import nextstep.signup.R
import nextstep.signup.domain.validation.Password
import nextstep.signup.domain.validation.ValidationResult

@Composable
internal fun SignUpPasswordTextField(
    modifier: Modifier = Modifier,
    password: String,
    onPasswordChange: (String) -> Unit
) {
    val validationResult = Password(password).validationResult()
    val supportingText = when (validationResult) {
        ValidationResult.INVALID_LENGTH -> stringResource(R.string.error_password_length)
        ValidationResult.INVALID_FORMAT -> stringResource(R.string.error_password_format)
        else -> ""
    }

    TextField(
        modifier = modifier,
        value = password,
        onValueChange = { onPasswordChange(it) },
        label = { Text(stringResource(R.string.input_hint_password)) },
        singleLine = true,
        supportingText = { if (supportingText.isNotEmpty()) Text(text = supportingText) },
        visualTransformation = PasswordVisualTransformation(),
        isError = supportingText.isNotEmpty()
    )
}
