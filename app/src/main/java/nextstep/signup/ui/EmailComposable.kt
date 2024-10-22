package nextstep.signup.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.signup.R
import nextstep.signup.model.Email
import nextstep.signup.model.EmailValidResult
import nextstep.signup.ui.component.TextComponent
import nextstep.signup.ui.component.TextFieldComponent

private const val EMAIL_FORM_ERROR = "이메일 형식이 올바르지 않습니다."

@Composable
fun EmailComposable(
    email: Email,
    onEmailChange: (String) -> Unit,
) {
    TextFieldComponent(
        newValue = email.email,
        onValueChange = onEmailChange,
        label = stringResource(R.string.main_email),
        supportingText = {
            val errorMessage = email.getErrorMessage() ?: return@TextFieldComponent
            TextComponent(description = errorMessage)
        },
        isError = email.isError(),
        keyboardType = KeyboardType.Email,
    )
    Spacer(modifier = Modifier.size(36.dp))
}

private fun Email.getErrorMessage(): String? =
    when (this.validate()) {
        EmailValidResult.Blank -> null
        EmailValidResult.InvalidForm -> EMAIL_FORM_ERROR
        else -> null
    }

@Preview(showBackground = true)
@Composable
private fun EmailComposablePreview() {
    EmailComposable(
        email = Email("hannah@naver.com"),
        onEmailChange = {},
    )
}
