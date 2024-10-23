package nextstep.signup.component

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import nextstep.signup.R
import nextstep.signup.domain.validation.PasswordConfirm
import nextstep.signup.domain.validation.ValidationResult

@Composable
internal fun SignUpPasswordConfirmTextField(
    modifier: Modifier = Modifier,
    password: String,
    passwordConfirm: String,
    onPasswordConfirmChange: (String) -> Unit
) {
    val validationResult =
        PasswordConfirm(
            password = password,
            value = passwordConfirm
        ).validationResult()
    val supportingText = when (validationResult) {
        ValidationResult.INVALID_MATCH -> stringResource(R.string.error_password_confirm)
        else -> ""
    }

    TextField(
        modifier = modifier,
        value = passwordConfirm,
        onValueChange = { onPasswordConfirmChange(it) },
        label = { Text(stringResource(R.string.input_hint_password_confirm)) },
        singleLine = true,
        supportingText = { if (supportingText.isNotEmpty()) Text(text = supportingText) },
        visualTransformation = PasswordVisualTransformation(),
        isError = supportingText.isNotEmpty()
    )
}
