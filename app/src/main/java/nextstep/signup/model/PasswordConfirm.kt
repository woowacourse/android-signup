package nextstep.signup.model

data class PasswordConfirm(
    val passwordConfirm: String,
) {
    fun isError(password: String): Boolean = !isBlank() && !isMatch(password)

    fun isMatch(password: String): Boolean = password == passwordConfirm

    fun getErrorMessage(password: String): String? =
        when {
            isBlank() -> null
            !isMatch(password) -> PASSWORD_CONFIRM_ERROR
            else -> null
        }

    private fun isBlank(): Boolean = passwordConfirm.isBlank()

    companion object {
        private const val PASSWORD_CONFIRM_ERROR = "비밀번호가 일치하지 않습니다."
    }
}
