package nextstep.signup.domain.validation

data class Password(private val value: String = DEFAULT_VALUE) {
    private val regex = Regex(PASSWORD_REGEX)

    fun validationResult(): ValidationResult {
        return when {
            value.isEmpty() -> ValidationResult.EMPTY
            !isValidLength() -> ValidationResult.INVALID_LENGTH
            !isValidFormat() -> ValidationResult.INVALID_FORMAT
            else -> ValidationResult.SUCCESS
        }
    }

    private fun isValidLength(): Boolean = value.length in PASSWORD_RANGE

    private fun isValidFormat(): Boolean = value.matches(regex)

    companion object {
        const val DEFAULT_VALUE = ""
        const val PASSWORD_REGEX = "^(?=.*[a-zA-Z])(?=.*[0-9]).*$"
        val PASSWORD_RANGE = 8..16
    }
}
