package nextstep.signup.domain

import androidx.annotation.StringRes
import nextstep.signup.R

data class SignUpInfo(
    val userName: String = INITIAL_TEXT,
    val email: String = INITIAL_TEXT,
    val password: String = INITIAL_TEXT,
    val passwordConfirm: String = INITIAL_TEXT,
) {

    fun isUserNameError(): Boolean =
        (!userName.matches(USERNAME_REGEX) || userName.length !in USER_NAME_RANGE) && userName != INITIAL_TEXT

    @StringRes
    fun userNameErrorMessage(): Int? = when {
        userName == INITIAL_TEXT -> null
        !userName.matches(USERNAME_REGEX) -> R.string.sign_up_user_name_regex_error
        userName.length !in USER_NAME_RANGE -> R.string.sign_up_user_name_length_error
        else -> null
    }

    fun isEmailError(): Boolean = !email.matches(EMAIL_REGEX) && email != INITIAL_TEXT

    @StringRes
    fun emailErrorMessage(): Int? = when {
        email == INITIAL_TEXT -> null
        !email.matches(EMAIL_REGEX) -> R.string.sign_up_email_error
        else -> null
    }

    fun isPasswordError(): Boolean =
        (!password.matches(PASSWORD_REGEX) || password.length !in PASSWORD_RANGE) && password != INITIAL_TEXT

    @StringRes
    fun passwordErrorMessage(): Int? = when {
        password == INITIAL_TEXT -> null
        !password.matches(PASSWORD_REGEX) -> R.string.sign_up_password_regex_error
        password.length !in PASSWORD_RANGE -> R.string.sign_up_password_length_error
        else -> null
    }


    fun isPasswordConfirmError(): Boolean =
        password != passwordConfirm && passwordConfirm != INITIAL_TEXT

    @StringRes
    fun passwordConfirmMessage(): Int? = when {
        passwordConfirm == INITIAL_TEXT -> null
        password != passwordConfirm -> R.string.sign_up_password_confirm_error
        else -> null
    }


    companion object {
        private const val INITIAL_TEXT = ""

        private val USER_NAME_RANGE = 2..5
        private val PASSWORD_RANGE = 8..16

        private val USERNAME_REGEX = Regex("^[a-zA-Z가-힣]+$")
        private val EMAIL_REGEX = Regex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")
        private val PASSWORD_REGEX = Regex("^(?=.*[a-zA-Z])(?=.*[0-9]).+$")
    }
}