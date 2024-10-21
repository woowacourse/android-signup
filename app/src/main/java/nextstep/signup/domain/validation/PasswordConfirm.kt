package nextstep.signup.domain.validation

data class PasswordConfirm(
    private val password: String = DEFAULT_PASSWORD,
    private val value: String = DEFAULT_VALUE
) {
    fun validationResult(): ValidationResult {
        return when {
            value.isEmpty() -> ValidationResult.EMPTY
            !isMatched() -> ValidationResult.INVALID_MATCH
            else -> ValidationResult.SUCCESS
        }
    }

    private fun isMatched(): Boolean = password == value

    companion object {
        const val DEFAULT_PASSWORD = ""
        const val DEFAULT_VALUE = ""
    }
}
