package nextstep.signup.domain

class Password(password: String = "") {
    private var _value = password
    val value: String
        get() = _value

    private var _isValid = isValidLength && isValidFormat
    val isValid: Boolean
        get() = _isValid

    private var _isValidLength = password.validatePasswordLength()
    val isValidLength: Boolean
        get() = _isValidLength

    private var _isValidFormat = password.validatePasswordFormat()
    val isValidFormat: Boolean
        get() = _isValidFormat

    fun setPassword(value: String) {
        _value = value
    }

    private fun String.validatePasswordLength(): Boolean = length in PASSWORD_LEGNTH

    private fun String.validatePasswordFormat(): Boolean = matches(Regex(PASSWORD_REGEX))

    companion object {
        private const val PASSWORD_REGEX = "^(?=.*[a-zA-Z])(?=.*[0-9]).*$"
        private val PASSWORD_LEGNTH = 8..16
    }
}
