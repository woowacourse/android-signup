package nextstep.signup.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

interface InputValue {
    fun validate(): ValidationState
}

@Parcelize
data class UserName(val value: String) : InputValue, Parcelable {
    override fun validate(): ValidationState {
        return if (!value.matches(Regex(USER_NAME_FORMAT_REGEX))) {
            ValidationState.FORMAT_ERROR
        } else if (!value.matches(Regex(USER_NAME_LENGTH_REGEX))) {
            ValidationState.LENGTH_ERROR
        } else {
            ValidationState.VALID
        }
    }

    companion object {
        const val USER_NAME_LENGTH_REGEX = "^.{2,5}$"
        const val USER_NAME_FORMAT_REGEX = "^[a-zA-Z가-힣]+$"
    }
}

@Parcelize
data class Email(val value: String) : InputValue, Parcelable {

    override fun validate(): ValidationState {
        return if (value.matches(Regex(EMAIL_FORMAT_REGEX))) {
            ValidationState.VALID
        } else {
            ValidationState.FORMAT_ERROR
        }
    }

    companion object {
        const val EMAIL_FORMAT_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
    }
}

@Parcelize
data class Password(val value: String) : InputValue, Parcelable {

    override fun validate(): ValidationState {
        return if (!value.matches(Regex(PASSWORD_FORMAT_REGEX))) {
            ValidationState.FORMAT_ERROR
        } else if (!value.matches(Regex(PASSWORD_LENGTH_REGEX))) {
            ValidationState.LENGTH_ERROR
        } else {
            ValidationState.VALID
        }
    }

    companion object {
        const val PASSWORD_LENGTH_REGEX = "^.{8,16}$"
        const val PASSWORD_FORMAT_REGEX = "^(?=.*[a-zA-Z])(?=.*[0-9]).+$"
    }
}

@Parcelize
data class PasswordConfirm(val value: String, val passwordConfirm: String) : InputValue,
    Parcelable {
    override fun validate(): ValidationState {
        return if (value != passwordConfirm) {
            ValidationState.FORMAT_ERROR
        } else {
            ValidationState.VALID
        }
    }
}