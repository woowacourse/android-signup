package nextstep.signup.model

import nextstep.signup.R

@JvmInline
value class UserName(
    val value: String = "",
) {
    fun validate(): InputValidation {
        if (value.isBlank()) return InputValidation(isError = false)
        if (!value.matches(Regex(USERNAME_REGEX))) {
            return InputValidation(
                errorMessageRes = R.string.error_username_invalid_characters,
                isError = true,
            )
        }
        if (value.length !in MIN_USERNAME_LENGTH..MAX_USERNAME_LENGTH) {
            return InputValidation(errorMessageRes = R.string.error_username_length, isError = true)
        }
        return InputValidation(isError = false)
    }

    companion object {
        const val USERNAME_REGEX = "^[a-zA-Z가-힣]+$"
        const val MIN_USERNAME_LENGTH = 2
        const val MAX_USERNAME_LENGTH = 5
    }
}
