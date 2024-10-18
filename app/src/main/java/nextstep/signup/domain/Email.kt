package nextstep.signup.domain

data class Email(val value: String = "") {
    val isValid = isValidFormat

    val isValidFormat: Boolean
        get() = value.validateEmailFormat()

    private fun String.validateEmailFormat(): Boolean = matches(Regex(EMAIL_REGEX))

    companion object {
        private const val EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
    }
}
