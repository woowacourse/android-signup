package nextstep.signup.model

class Email(private val value: String) : InputValidation {
    private var errorMessage: String? = null

    override fun isInvalid(): Boolean {
        return regexValidate()
    }

    override fun getErrorMessage() = if (isInvalid()) errorMessage else null

    private fun regexValidate(): Boolean {
        if (!value.matches(EMAIL_REGEX.toRegex())) {
            errorMessage = ERROR_USER_EMAIL_REGEX
            return true
        }
        return false
    }

    companion object {
        const val ERROR_USER_EMAIL_REGEX = "올바른 이메일 형식이 아닙니다."
        const val EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
    }
}
