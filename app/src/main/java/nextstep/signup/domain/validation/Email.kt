package nextstep.signup.domain.validation


data class Email(private val email: String = DEFAULT_EMAIL) {
    private val regex = Regex(EMAIL_REGEX)

    fun validationResult(): ValidationResult {
        return when {
            email.isEmpty() -> ValidationResult.EMPTY
            !isValidFormat() -> ValidationResult.INVALID_FORMAT
            else -> ValidationResult.SUCCESS
        }
    }

    private fun isValidFormat(): Boolean = email.matches(regex)

    companion object {
        const val DEFAULT_EMAIL = ""
        const val EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
    }
}
