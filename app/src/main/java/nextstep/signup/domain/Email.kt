package nextstep.signup.domain

data class Email(
    val content: String
) {
    init {
        require(regex.matches(content)) { "the email format is not correct" }
    }

    companion object {
        private const val EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
        private val regex = Regex(EMAIL_REGEX)

        fun from(input: String): EmailResult {
            if (input == "") return EmailResult.EmptyField
            if (!regex.matches(input)) return EmailResult.InvalidNameFormat
            return EmailResult.Success(Email(input))
        }
    }
}

sealed interface EmailResult {
    data class Success(val email: Email) : EmailResult

    data object EmptyField : EmailResult

    sealed interface Failure : EmailResult

    data object InvalidNameFormat : Failure
}
