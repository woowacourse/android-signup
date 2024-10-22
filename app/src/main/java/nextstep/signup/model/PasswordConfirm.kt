package nextstep.signup.model

data class PasswordConfirm(
    val passwordConfirm: String,
) {
    fun isError(password: String): Boolean = !isBlank() && !isMatch(password)

    fun isMatch(password: String): Boolean = password == passwordConfirm

    fun validate(password: String): PasswordConfirmValidResult =
        when {
            isBlank() -> PasswordConfirmValidResult.Blank
            !isMatch(password) -> PasswordConfirmValidResult.Invalid
            else -> PasswordConfirmValidResult.Success
        }

    private fun isBlank(): Boolean = passwordConfirm.isBlank()
}
