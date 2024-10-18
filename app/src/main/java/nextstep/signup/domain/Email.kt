package nextstep.signup.domain

class Email(email: String = "") {
    private var _value = email
    val value: String
        get() = _value

    private var _isValid = isValidFormat
    val isValid: Boolean
        get() = _isValid

    private var _isValidFormat = email.validateEmailFormat()
    val isValidFormat: Boolean
        get() = _isValidFormat

    fun setEmail(value: String) {
        _value = value
    }

    private fun String.validateEmailFormat(): Boolean = matches(Regex(EMAIL_REGEX))

    companion object {
        private const val EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
    }
}
