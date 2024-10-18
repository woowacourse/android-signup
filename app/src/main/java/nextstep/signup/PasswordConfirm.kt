package nextstep.signup

data class PasswordConfirm(
    val password: String,
    val passwordConfirm: String,
) {
    fun isValid(): Boolean = !isBlank() && !isMatchPassword()

    fun getErrorMessage(): String? =
        when {
            isBlank() -> null
            !isMatchPassword() -> PASSWORD_CONFIRM_ERROR
            else -> null
        }

    private fun isBlank(): Boolean = passwordConfirm.isBlank()

    private fun isMatchPassword(): Boolean = password == passwordConfirm

    companion object {
        private const val PASSWORD_CONFIRM_ERROR = "비밀번호가 일치하지 않습니다."
    }
}
