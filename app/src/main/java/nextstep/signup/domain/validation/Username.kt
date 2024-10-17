package nextstep.signup.domain.validation

data class Username(private val name: String = DEFAULT_USERNAME) {
    private val regex = Regex(USERNAME_REGEX)

    fun validationResult(): ValidationResult {
        return when {
            name.isEmpty() -> ValidationResult.EMPTY
            !isValidLength() -> ValidationResult.INVALID_LENGTH
            !isValidFormat() -> ValidationResult.INVALID_FORMAT
            else -> ValidationResult.SUCCESS
        }
    }

    private fun isValidLength(): Boolean = name.length in 2..5

    private fun isValidFormat(): Boolean = name.matches(regex)

    companion object {
        const val DEFAULT_USERNAME = ""
        const val USERNAME_REGEX = "^[a-zA-Z가-힣]+$"
    }
}
