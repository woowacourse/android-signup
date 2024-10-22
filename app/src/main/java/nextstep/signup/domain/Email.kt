package nextstep.signup.domain

@JvmInline
value class Email(
    val value: String = "",
) {
    fun validate(): InputValidation {
        if (value.isBlank()) return InputValidation(isError = false)
        if (!value.matches(Regex(EMAIL_REGEX))) {
            return InputValidation(errorCode = ErrorCode.ERROR_INVALID_EMAIL_FORMAT, isError = true)
        }
        return InputValidation(isError = false)
    }

    companion object {
        const val EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
    }
}
