package nextstep.signup.model

import nextstep.signup.R

@JvmInline
value class Password(
    val value: String = "",
) {
    fun validate(): InputValidation {
        if (value.isBlank()) return InputValidation(isError = false)
        if (!value.matches(Regex(PASSWORD_REGEX))) {
            return InputValidation(stringRes = R.string.error_password_requirements, isError = true)
        }
        if (value.length !in 8..16) {
            return InputValidation(stringRes = R.string.error_password_length, isError = true)
        }
        return InputValidation(isError = false)
    }

    fun validateConfirmation(other: Password): InputValidation {
        if (value.isBlank()) return InputValidation(isError = false)
        if (value != other.value) {
            return InputValidation(stringRes = R.string.error_password_mismatch, isError = true)
        }
        return InputValidation(isError = false)
    }

    companion object {
        const val PASSWORD_REGEX = "^(?=.*[a-zA-Z])(?=.*[0-9]).{8,16}$"
    }
}
