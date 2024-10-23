package nextstep.signup.domain

data class Password(val value: String = EMPTY_PASSWORD) {
    val isValid: Boolean = isValidLength && isValidFormat

    val isValidLength: Boolean
        get() = value.validatePasswordLength()

    val isValidFormat: Boolean
        get() = value.validatePasswordFormat()

    private fun String.validatePasswordLength(): Boolean = length in PASSWORD_LENGTH

    private fun String.validatePasswordFormat(): Boolean = matches(Regex(PASSWORD_REGEX))

    companion object {
        private const val EMPTY_PASSWORD = ""
        private const val MIN_PASSWORD_LENGTH = 8
        private const val MAX_PASSWORD_LENGTH = 16
        private val PASSWORD_LENGTH = MIN_PASSWORD_LENGTH..MAX_PASSWORD_LENGTH
        private const val PASSWORD_REGEX = "^(?=.*[a-zA-Z])(?=.*[0-9]).*$"
    }
}
