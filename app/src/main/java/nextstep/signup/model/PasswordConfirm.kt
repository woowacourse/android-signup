package nextstep.signup.model

data class PasswordConfirm(
    val content: String,
    val password: String,
) : InputValidator {
    override fun isValid(): Boolean = isSameWithPassword()

    override fun getErrorMessage(): String? = if (!isValid()) ERROR_PASSWORD_CONFIRM_MESSAGE else null

    private fun isSameWithPassword(): Boolean = content == password

    companion object {
        const val ERROR_PASSWORD_CONFIRM_MESSAGE = "비밀번호가 일치하지 않습니다."
    }
}
