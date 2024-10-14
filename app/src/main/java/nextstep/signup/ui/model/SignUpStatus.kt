package nextstep.signup.ui.model

import androidx.annotation.StringRes
import nextstep.signup.R

sealed interface SignUpStatus {
    data object Empty : SignUpStatus

    data object Success : SignUpStatus

    sealed class Error(@StringRes val message: Int) : SignUpStatus {
        data object UsernameLength : Error(R.string.error_username_length)
        data object UsernameNonCharacter : Error(R.string.error_username_non_character)
        data object EmailFormat : Error(R.string.error_email_format)
        data object PasswordLength : Error(R.string.error_password_length)
        data object PasswordFormat : Error(R.string.error_password_format)
        data object PasswordConfirmation : Error(R.string.error_password_confirmation)
    }
}
