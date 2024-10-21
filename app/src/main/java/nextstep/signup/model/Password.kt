package nextstep.signup.model

import nextstep.signup.R

@JvmInline
value class Password(
    val value: String = "",
) {
    fun validate(): InputValidation {
        if (value.isBlank()) return InputValidation(isError = false)
        if (value.length !in MIN_PASSWORD_LENGTH..MAX_PASSWORD_LENGTH) {
            return InputValidation(errorMessageRes = R.string.error_password_length, isError = true)
        }
        if (!value.matches(Regex(PASSWORD_REGEX))) {
            return InputValidation(errorMessageRes = R.string.error_password_requirements, isError = true)
        }
        return InputValidation(isError = false)
    }

    fun validateConfirmation(other: Password): InputValidation {
        if (value.isBlank()) return InputValidation(isError = false)
        if (value != other.value) {
            return InputValidation(errorMessageRes = R.string.error_password_mismatch, isError = true)
        }
        return InputValidation(isError = false)
    }

    companion object {
        const val PASSWORD_REGEX = "^(?=.*[a-zA-Z])(?=.*[0-9]).{8,16}$"
        const val MIN_PASSWORD_LENGTH = 8
        const val MAX_PASSWORD_LENGTH = 16
    }
}
