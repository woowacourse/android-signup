package nextstep.signup.domain

class Username(name: String = "") {
    private var _value = name
    val value: String
        get() = _value

    private var _isValid = isValidLength && isValidFormat
    val isValid: Boolean
        get() = _isValid

    private var _isValidLength = name.validateUsernameLength()
    val isValidLength: Boolean
        get() = _isValidLength

    private var _isValidFormat = name.validateUsernameFormat()
    val isValidFormat: Boolean
        get() = _isValidFormat

    fun setUsername(value: String) {
        _value = value
    }

    private fun String.validateUsernameLength(): Boolean = length in USERNAME_LEGNTH

    private fun String.validateUsernameFormat(): Boolean = matches(Regex(USERNAME_REGEX))

    companion object {
        private const val USERNAME_REGEX = "^[a-zA-Z가-힣]+$"
        private val USERNAME_LEGNTH = 2..5
    }
}
