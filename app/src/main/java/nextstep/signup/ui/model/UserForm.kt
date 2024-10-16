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

    fun hasError(field: FormField): Boolean {
        return when (field) {
            FormField.USERNAME -> usernameStatus is SignUpStatus.Error
            FormField.EMAIL -> emailStatus is SignUpStatus.Error
            FormField.PASSWORD -> passwordStatus is SignUpStatus.Error
            FormField.PASSWORD_CONFIRMATION -> passwordConfirmationStatus is SignUpStatus.Error
        }
    }

    fun errorMessageResourceOf(field: FormField): Int? {
        return when (field) {
            FormField.USERNAME -> usernameErrorMessageResource(usernameStatus)
            FormField.EMAIL -> emailErrorMessageResource(emailStatus)
            FormField.PASSWORD -> passwordErrorMessageResource(passwordStatus)
            FormField.PASSWORD_CONFIRMATION -> passwordConfirmationErrorMessageResource(
                passwordConfirmationStatus
            )
        }
    }

    private fun passwordConfirmationErrorMessageResource(passwordConfirmationStatus: SignUpStatus): Int? =
        when (passwordConfirmationStatus) {
            is SignUpStatus.Error.PasswordConfirmation -> passwordConfirmationStatus.message
            else -> null
        }

    private fun passwordErrorMessageResource(passwordStatus: SignUpStatus): Int? =
        when (passwordStatus) {
            is SignUpStatus.Error.PasswordLength -> passwordStatus.message
            is SignUpStatus.Error.PasswordFormat -> passwordStatus.message
            else -> null
        }

    private fun emailErrorMessageResource(emailStatus: SignUpStatus) =
        when (emailStatus) {
            is SignUpStatus.Error.EmailFormat -> emailStatus.message
            else -> null
        }

    private fun usernameErrorMessageResource(usernameStatus: SignUpStatus): Int? =
        when (usernameStatus) {
            is SignUpStatus.Error.UsernameLength -> usernameStatus.message
            is SignUpStatus.Error.UsernameNonCharacter -> usernameStatus.message
            else -> null
        }

    enum class FormField {
        USERNAME, EMAIL, PASSWORD, PASSWORD_CONFIRMATION
    }

    companion object {
        private const val USERNAME_REGEX = "^[a-zA-Z가-힣]+$"
        private const val EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
        private const val PASSWORD_REGEX = "^(?=.*[a-zA-Z])(?=.*[0-9]).{8,16}$"

        private val VALID_USERNAME_LENGTH = 2..5
        private val VALID_PASSWORD_LENGTH = 8..16
    }
}
