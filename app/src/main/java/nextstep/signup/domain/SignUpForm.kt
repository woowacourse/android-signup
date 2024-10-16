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
            return (validateUserName() == ValidationState.VALID) &&
                (validateEmail() == ValidationState.VALID) &&
                (validatePassword() == ValidationState.VALID) &&
                (validatePasswordConfirm() == ValidationState.VALID)
        }

    private fun validateUserName(): ValidationState {
        return if (!userName.matches(Regex(USER_NAME_FORMAT_REGEX))) {
            ValidationState.FORMAT_ERROR
        } else if (!userName.matches(Regex(USER_NAME_LENGTH_REGEX))) {
            ValidationState.LENGTH_ERROR
        } else {
            ValidationState.VALID
        }
    }

    private fun validateEmail(): ValidationState {
        return if (email.matches(Regex(EMAIL_FORMAT_REGEX))) {
            ValidationState.VALID
        } else {
            ValidationState.FORMAT_ERROR
        }
    }

    private fun validatePassword(): ValidationState {
        return if (!password.matches(Regex(PASSWORD_FORMAT_REGEX))) {
            ValidationState.FORMAT_ERROR
        } else if (!password.matches(Regex(PASSWORD_LENGTH_REGEX))) {
            ValidationState.LENGTH_ERROR
        } else {
            ValidationState.VALID
        }
    }

    private fun validatePasswordConfirm(): ValidationState {
        return if (passwordConfirm != password) {
            ValidationState.FORMAT_ERROR
        } else {
            ValidationState.VALID
        }
    }

    companion object {
        const val USER_NAME_LENGTH_REGEX = "^.{2,5}$"
        const val USER_NAME_FORMAT_REGEX = "^[a-zA-Z가-힣]+$"
        const val EMAIL_FORMAT_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
        const val PASSWORD_LENGTH_REGEX = "^.{8,16}$"
        const val PASSWORD_FORMAT_REGEX = "^(?=.*[a-zA-Z])(?=.*[0-9]).+$"

        val emptySignUpForm = SignUpForm("", "", "", "")
    }
}
