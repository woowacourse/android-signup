package nextstep.signup.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SignUpForm(
    val userName: String,
    val email: String,
    val password: String,
    val passwordConfirm: String,
) : Parcelable {
    val isValidForm: Boolean
        get() {
            return (validateUserName() == 0) &&
                (validateEmail() == 0) &&
                (validatePassword() == 0) &&
                (validatePasswordConfirm() == 0)
        }

    private fun validateUserName(): Int {
        return if (!userName.matches(Regex(USER_NAME_FORMAT_REGEX))) {
            ERROR_FORMAT
        } else if (!userName.matches(Regex(USER_NAME_LENGTH_REGEX))) {
            ERROR_LENGTH
        } else {
            VALID
        }
    }

    private fun validateEmail(): Int {
        return if (email.matches(Regex(EMAIL_FORMAT_REGEX))) {
            VALID
        } else {
            ERROR_FORMAT
        }
    }

    private fun validatePassword(): Int {
        return if (!password.matches(Regex(PASSWORD_FORMAT_REGEX))) {
            ERROR_FORMAT
        } else if (!password.matches(Regex(PASSWORD_LENGTH_REGEX))) {
            ERROR_LENGTH
        } else {
            VALID
        }
    }

    private fun validatePasswordConfirm(): Int {
        return if (passwordConfirm != password) {
            ERROR_FORMAT
        } else {
            VALID
        }
    }

    companion object {
        const val USER_NAME_LENGTH_REGEX = "^.{2,5}$"
        const val USER_NAME_FORMAT_REGEX = "^[a-zA-Z가-힣]+$"
        const val EMAIL_FORMAT_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
        const val PASSWORD_LENGTH_REGEX = "^.{8,16}$"
        const val PASSWORD_FORMAT_REGEX = "^(?=.*[a-zA-Z])(?=.*[0-9]).+$"

        const val VALID = 0
        const val ERROR_FORMAT = 1
        const val ERROR_LENGTH = 2

        val emptySignUpForm = SignUpForm("", "", "", "")
    }
}
