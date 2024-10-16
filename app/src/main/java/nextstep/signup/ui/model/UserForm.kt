package nextstep.signup.ui.model

import android.os.Parcelable
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserForm(
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val passwordConfirmation: String = "",
) : Parcelable {
    @IgnoredOnParcel
    val usernameStatus: SignUpStatus =
        when {
            username.isEmpty() -> SignUpStatus.Empty
            username.length !in VALID_USERNAME_LENGTH -> SignUpStatus.Error.UsernameLength
            username.matches(Regex(USERNAME_REGEX)) -> SignUpStatus.Success
            else -> SignUpStatus.Error.UsernameNonCharacter
        }

    @IgnoredOnParcel
    val emailStatus: SignUpStatus =
        when {
            email.isEmpty() -> SignUpStatus.Empty
            email.matches(Regex(EMAIL_REGEX)) -> SignUpStatus.Success
            else -> SignUpStatus.Error.EmailFormat
        }

    @IgnoredOnParcel
    val passwordStatus: SignUpStatus =
        when {
            password.isEmpty() -> SignUpStatus.Empty
            password.length !in VALID_PASSWORD_LENGTH -> SignUpStatus.Error.PasswordLength
            password.matches(Regex(PASSWORD_REGEX)) -> SignUpStatus.Success
            else -> SignUpStatus.Error.PasswordFormat
        }

    @IgnoredOnParcel
    val passwordConfirmationStatus: SignUpStatus =
        when {
            passwordConfirmation.isEmpty() -> SignUpStatus.Empty
            password == passwordConfirmation -> SignUpStatus.Success
            else -> SignUpStatus.Error.PasswordConfirmation
        }

    @IgnoredOnParcel
    val formValid: Boolean =
        usernameStatus == SignUpStatus.Success &&
                emailStatus == SignUpStatus.Success &&
                passwordStatus == SignUpStatus.Success &&
                passwordConfirmationStatus == SignUpStatus.Success

    companion object {
        private const val USERNAME_REGEX = "^[a-zA-Z가-힣]+$"
        private const val EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
        private const val PASSWORD_REGEX = "^(?=.*[a-zA-Z])(?=.*[0-9]).{8,16}$"

        private val VALID_USERNAME_LENGTH = 2..5
        private val VALID_PASSWORD_LENGTH = 8..16
    }
}
