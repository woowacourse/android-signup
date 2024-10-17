package nextstep.signup.model

data class Password(
    val content: String,
) : InputValidator {
    override fun isValid(): Boolean = hasValidLength() && hasValidFormat()

    override fun getErrorMessage(): String? =
        when {
            !hasValidLength() -> ERROR_PASSWORD_LENGTH_MESSAGE
            !hasValidFormat() -> ERROR_PASSWORD_FORMAT_MESSAGE
            else -> null
        }

    private fun hasValidLength(): Boolean = content.length in 8..16

    private fun hasValidFormat(): Boolean = content.matches(Regex(PASSWORD_REGEX))

    companion object {
        const val PASSWORD_REGEX = "^(?=.*[a-zA-Z])(?=.*[0-9]).{8,16}$"
        const val ERROR_PASSWORD_LENGTH_MESSAGE = "비밀번호는 8~16자여야 합니다."
        const val ERROR_PASSWORD_FORMAT_MESSAGE = "비밀번호는 영문과 숫자를 포함해야 합니다."
    }
}
