package nextstep.signup.domain.validation

data class PasswordConfirm(
    private val password: String = DEFAULT_PASSWORD,
    private val passwordConfirm: String = DEFAULT_PASSWORD_CONFIRM,
) {
    fun validationResult(): ValidationResult {
        return when {
            passwordConfirm.isEmpty() -> ValidationResult.EMPTY
            !isMatched() -> ValidationResult.INVALID_MATCH
            else -> ValidationResult.SUCCESS
        }
    }

    private fun isMatched(): Boolean = password == passwordConfirm

    companion object {
        const val DEFAULT_PASSWORD = ""
        const val DEFAULT_PASSWORD_CONFIRM = ""
    }
}
