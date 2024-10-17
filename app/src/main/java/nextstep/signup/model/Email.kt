package nextstep.signup.model

data class Email(
    val content: String,
) : InputValidator {
    override fun isValid(): Boolean = hasValidFormat()

    private fun hasValidFormat(): Boolean = content.matches(Regex(EMAIL_REGEX))

    override fun getErrorMessage(): String? = if (!isValid()) ERROR_EMAIL_MESSAGE else null

    companion object {
        const val EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
        const val ERROR_EMAIL_MESSAGE = "이메일 형식이 올바르지 않습니다."
    }
}
