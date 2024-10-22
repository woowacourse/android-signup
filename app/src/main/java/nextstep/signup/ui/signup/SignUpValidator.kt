package nextstep.signup.ui.signup

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import nextstep.signup.R
import nextstep.signup.domain.Email
import nextstep.signup.domain.Password
import nextstep.signup.domain.PasswordConfirm
import nextstep.signup.domain.Username

object SignUpValidator {
    @Composable
    fun Username.getValidationMessage(): String? {
        return when {
            value.isEmpty() -> null
            isValidFormat.not() -> stringResource(id = R.string.signup_support_username_invalid_format)
            isValidLength.not() -> stringResource(id = R.string.signup_support_username_invalid_length)
            else -> null
        }
    }

    @Composable
    fun Email.getValidationMessage(): String? {
        return when {
            value.isEmpty() -> null
            isValidFormat.not() -> stringResource(id = R.string.signup_support_email_invalid_format)
            else -> null
        }
    }

    @Composable
    fun Password.getValidationMessage(): String? {
        return when {
            value.isEmpty() -> null
            isValidFormat.not() -> stringResource(id = R.string.signup_support_password_invalid_format)
            isValidLength.not() -> stringResource(id = R.string.signup_support_password_invalid_length)
            else -> null
        }
    }

    @Composable
    fun PasswordConfirm.getValidationMessage(password: String): String? {
        return when {
            value.isEmpty() -> null
            isMatchWithPassword(password) -> stringResource(id = R.string.signup_support_password_confirm_mismatch)
            else -> null
        }
    }
}
