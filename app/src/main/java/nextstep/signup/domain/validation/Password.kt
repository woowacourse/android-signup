package nextstep.signup.domain.validation

data class Password(private val password: String = DEFAULT_PASSWORD) {
    private val regex = Regex(PASSWORD_REGEX)

    fun validationResult(): ValidationResult {
        return when {
            password.isEmpty() -> ValidationResult.EMPTY
            !isValidLength() -> ValidationResult.INVALID_LENGTH
            !isValidFormat() -> ValidationResult.INVALID_FORMAT
            else -> ValidationResult.SUCCESS
        }
    }

    private fun isValidLength(): Boolean = password.length in 8..16

    private fun isValidFormat(): Boolean = password.matches(regex)

    companion object {
        const val DEFAULT_PASSWORD = ""
        const val PASSWORD_REGEX = "^(?=.*[a-zA-Z])(?=.*[0-9]).{8,16}$"
    }
}
