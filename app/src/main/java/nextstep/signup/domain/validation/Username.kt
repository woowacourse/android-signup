package nextstep.signup.domain.validation

data class Username(private val value: String = DEFAULT_VALUE) {
    private val regex = Regex(USERNAME_REGEX)

    fun validationResult(): ValidationResult {
        return when {
            value.isEmpty() -> ValidationResult.EMPTY
            !isValidLength() -> ValidationResult.INVALID_LENGTH
            !isValidFormat() -> ValidationResult.INVALID_FORMAT
            else -> ValidationResult.SUCCESS
        }
    }

    private fun isValidLength(): Boolean = value.length in 2..5

    private fun isValidFormat(): Boolean = value.matches(regex)

    companion object {
        const val DEFAULT_VALUE = ""
        const val USERNAME_REGEX = "^[a-zA-Z가-힣]+$"
    }
}
