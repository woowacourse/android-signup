package nextstep.signup.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserForm(
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val passwordConfirmation: String = "",
) : Parcelable {
    val usernameStatus: SignUpStatus
        get() =
            when {
                username.isEmpty() -> SignUpStatus.Empty
                username.length !in 2..5 -> SignUpStatus.Error.UsernameLength
                username.matches(Regex(USERNAME_REGEX)) -> SignUpStatus.Success
                else -> SignUpStatus.Error.UsernameNonCharacter
            }

    val emailStatus: SignUpStatus
        get() =
            when {
                email.isEmpty() -> SignUpStatus.Empty
                email.matches(Regex(EMAIL_REGEX)) -> SignUpStatus.Success
                else -> SignUpStatus.Error.EmailFormat
            }

    val passwordStatus: SignUpStatus
        get() =
            when {
                password.isEmpty() -> SignUpStatus.Empty
                password.length !in 8..16 -> SignUpStatus.Error.PasswordLength
                password.matches(Regex(PASSWORD_REGEX)) -> SignUpStatus.Success
                else -> SignUpStatus.Error.PasswordFormat
            }

    val passwordConfirmationStatus: SignUpStatus
        get() =
            when {
                passwordConfirmation.isEmpty() -> SignUpStatus.Empty
                password == passwordConfirmation -> SignUpStatus.Success
                else -> SignUpStatus.Error.PasswordConfirmation
            }

    val formValid: Boolean
        get() =
            usernameStatus == SignUpStatus.Success &&
                emailStatus == SignUpStatus.Success &&
                passwordStatus == SignUpStatus.Success &&
                passwordConfirmationStatus == SignUpStatus.Success

    companion object {
        private const val USERNAME_REGEX = "^[a-zA-Z가-힣]+$"
        private const val EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
        private const val PASSWORD_REGEX = "^(?=.*[a-zA-Z])(?=.*[0-9]).{8,16}$"
    }
}
