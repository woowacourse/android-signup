package nextstep.signup.domain

@JvmInline
value class UserName(
    val value: String = "",
) {
    fun validate(): InputValidation {
        if (value.isBlank()) return InputValidation(isError = false)
        if (!value.matches(Regex(USERNAME_REGEX))) {
            return InputValidation(
                errorCode = ErrorCode.ERROR_USERNAME_INVALID_CHARACTERS,
                isError = true,
            )
        }
        if (value.length !in MIN_USERNAME_LENGTH..MAX_USERNAME_LENGTH) {
            return InputValidation(errorCode = ErrorCode.ERROR_USERNAME_LENGTH, isError = true)
        }
        return InputValidation(isError = false)
    }

    companion object {
        const val USERNAME_REGEX = "^[a-zA-Z가-힣]+$"
        const val MIN_USERNAME_LENGTH = 2
        const val MAX_USERNAME_LENGTH = 5
    }
}
