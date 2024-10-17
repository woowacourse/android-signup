package nextstep.signup.domain

@JvmInline
value class Email(val value: String) {

    init {
        require(value.isNotBlank()) { "이메일은 공백일 수 없습니다." }
        require(value.isValidEmailFormat()) { "이메일 형식이 올바르지 않습니다. e. sample@gmail.com" }
    }

    companion object {
        private const val EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}\$"

        private fun String.isValidEmailFormat(): Boolean {
            return matches(EMAIL_REGEX.toRegex())
        }

        fun from(email: String): EmailResult {
            return when {
                email.isBlank() -> EmailResult.InvalidBlank
                email.isValidEmailFormat().not() -> EmailResult.InvalidEmailFormat
                else -> EmailResult.Success(email)
            }
        }
    }
}

sealed interface EmailResult {
    data class Success(val email: String) : EmailResult
    data object InvalidBlank : EmailResult
    data object InvalidEmailFormat : EmailResult
}
