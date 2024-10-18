package nextstep.signup.domain

data class Password(val value: String = "") {
    val isValid: Boolean = isValidLength && isValidFormat

    val isValidLength: Boolean
        get() = value.validatePasswordLength()

    val isValidFormat: Boolean
        get() = value.validatePasswordFormat()

    private fun String.validatePasswordLength(): Boolean = length in PASSWORD_LEGNTH

    private fun String.validatePasswordFormat(): Boolean = matches(Regex(PASSWORD_REGEX))

    companion object {
        private const val PASSWORD_REGEX = "^(?=.*[a-zA-Z])(?=.*[0-9]).*$"
        private val PASSWORD_LEGNTH = 8..16
    }
}
