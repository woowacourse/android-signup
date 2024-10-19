package nextstep.signup.model

data class Email(val email: String) {
    fun isError(): Boolean = !isBlank() && !isValid()

    fun isValid(): Boolean = email.matches(Regex(EMAIL_REGEX))

    fun getErrorMessage(): String? {
        return when {
            isBlank() -> null
            !isValid() -> EMAIL_FORM_ERROR
            else -> null
        }
    }

    private fun isBlank(): Boolean = email.isBlank()

    companion object {
        private const val EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
        private const val EMAIL_FORM_ERROR = "이메일 형식이 올바르지 않습니다."
    }
}
