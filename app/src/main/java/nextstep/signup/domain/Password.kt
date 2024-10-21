package nextstep.signup.domain

import nextstep.signup.domain.ErrorCode.ERROR_PASSWORD_LENGTH
import nextstep.signup.domain.ErrorCode.ERROR_PASSWORD_MISMATCH
import nextstep.signup.domain.ErrorCode.ERROR_PASSWORD_REQUIREMENTS

@JvmInline
value class Password(
    val value: String = "",
) {
    fun validate(): InputValidation {
        if (value.isBlank()) return InputValidation(isError = false)
        if (value.length !in MIN_PASSWORD_LENGTH..MAX_PASSWORD_LENGTH) {
            return InputValidation(errorCode = ERROR_PASSWORD_LENGTH, isError = true)
        }
        if (!value.matches(Regex(PASSWORD_REGEX))) {
            return InputValidation(
                errorCode = ERROR_PASSWORD_REQUIREMENTS,
                isError = true,
            )
        }
        return InputValidation(isError = false)
    }

    fun validateConfirmation(other: Password): InputValidation {
        if (value.isBlank()) return InputValidation(isError = false)
        if (value != other.value) {
            return InputValidation(
                errorCode = ERROR_PASSWORD_MISMATCH,
                isError = true,
            )
        }
        return InputValidation(isError = false)
    }

    companion object {
        const val PASSWORD_REGEX = "^(?=.*[a-zA-Z])(?=.*[0-9]).{8,16}$"
        const val MIN_PASSWORD_LENGTH = 8
        const val MAX_PASSWORD_LENGTH = 16
    }
}
