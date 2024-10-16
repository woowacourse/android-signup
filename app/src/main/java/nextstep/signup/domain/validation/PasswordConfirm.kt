package nextstep.signup.domain.validation

data class PasswordConfirm(
    private val password: String,
    private val passwordConfirm: String,
) {
    fun validationResult(): ValidationResult {
        return when {
            passwordConfirm.isEmpty() -> ValidationResult.EMPTY
            !isMatched() -> ValidationResult.INVALID_MATCH
            else -> ValidationResult.SUCCESS
        }
    }

    private fun isMatched(): Boolean = password == passwordConfirm
}
