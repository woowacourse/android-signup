package nextstep.signup.model

data class PasswordConfirm(
    val passwordConfirm: String,
) {
    fun isInvalid(password: String): Boolean = !isBlank() && !isMatchPassword(password)

    fun getErrorMessage(password: String): String? =
        when {
            isBlank() -> null
            !isMatchPassword(password) -> PASSWORD_CONFIRM_ERROR
            else -> null
        }

    private fun isBlank(): Boolean = passwordConfirm.isBlank()

    private fun isMatchPassword(password: String): Boolean = password == passwordConfirm

    companion object {
        private const val PASSWORD_CONFIRM_ERROR = "비밀번호가 일치하지 않습니다."
    }
}
