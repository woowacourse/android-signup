package nextstep.signup.domain

data class Username(val value: String = "") {
    val isValid: Boolean = isValidLength && isValidFormat

    val isValidLength: Boolean
        get() = value.validateUsernameLength()

    val isValidFormat: Boolean
        get() = value.validateUsernameFormat()

    private fun String.validateUsernameLength(): Boolean = length in USERNAME_LEGNTH

    private fun String.validateUsernameFormat(): Boolean = matches(Regex(USERNAME_REGEX))

    companion object {
        private const val USERNAME_REGEX = "^[a-zA-Z가-힣]+$"
        private val USERNAME_LEGNTH = 2..5
    }
}
