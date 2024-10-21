package nextstep.signup.presentation.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.res.stringResource
import nextstep.signup.R
import nextstep.signup.domain.ErrorCode
import nextstep.signup.domain.InputValidation

@ReadOnlyComposable
@Composable
fun InputValidation.toErrorMessage(): String =
    when (this.errorCode) {
        ErrorCode.ERROR_USERNAME_LENGTH -> stringResource(R.string.error_username_length)
        ErrorCode.ERROR_USERNAME_INVALID_CHARACTERS -> stringResource(R.string.error_username_invalid_characters)
        ErrorCode.ERROR_INVALID_EMAIL_FORMAT -> stringResource(R.string.error_invalid_email_format)
        ErrorCode.ERROR_PASSWORD_LENGTH -> stringResource(R.string.error_password_length)
        ErrorCode.ERROR_PASSWORD_REQUIREMENTS -> stringResource(R.string.error_password_requirements)
        ErrorCode.ERROR_PASSWORD_MISMATCH -> stringResource(R.string.error_password_mismatch)
        null -> stringResource(R.string.default_error)
    }
