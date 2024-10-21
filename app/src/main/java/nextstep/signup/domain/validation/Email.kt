package nextstep.signup.domain.validation

data class Email(private val value: String = DEFAULT_VALUE) {
    private val regex = Regex(EMAIL_REGEX)

    fun validationResult(): ValidationResult {
        return when {
            value.isEmpty() -> ValidationResult.EMPTY
            !isValidFormat() -> ValidationResult.INVALID_FORMAT
            else -> ValidationResult.SUCCESS
        }
    }

    private fun isValidFormat(): Boolean = value.matches(regex)

    companion object {
        const val DEFAULT_VALUE = ""
        const val EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
    }
}
