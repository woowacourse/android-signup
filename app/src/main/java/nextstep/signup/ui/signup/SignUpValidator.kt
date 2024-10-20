package nextstep.signup.ui.signup

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import nextstep.signup.R
import nextstep.signup.domain.Email
import nextstep.signup.domain.Password
import nextstep.signup.domain.Username

object SignUpValidator {
    @Composable
    fun Username.validateUsername(): String? {
        return when {
            value.isEmpty() -> null
            isValidFormat.not() -> stringResource(id = R.string.signup_support_username_invalid_format)
            isValidLength.not() -> stringResource(id = R.string.signup_support_username_invalid_length)
            else -> null
        }
    }

    @Composable
    fun Email.validateEmail(): String? {
        return when {
            value.isEmpty() -> null
            isValidFormat.not() -> stringResource(id = R.string.signup_support_email_invalid_format)
            else -> null
        }
    }

    @Composable
    fun Password.validatePassword(): String? {
        return when {
            value.isEmpty() -> null
            isValidFormat.not() -> stringResource(id = R.string.signup_support_password_invalid_format)
            isValidLength.not() -> stringResource(id = R.string.signup_support_password_invalid_length)
            else -> null
        }
    }

    @Composable
    fun String.validatePasswordConfirm(password: String): String? {
        return when {
            isEmpty() -> null
            !equals(password) -> stringResource(id = R.string.signup_support_password_confirm_mismatch)
            else -> null
        }
    }
}
