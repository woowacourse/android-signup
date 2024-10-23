package nextstep.signup.domain

data class Username(val value: String = EMPTY_USERNAME) {
    val isValid: Boolean = isValidLength && isValidFormat

    val isValidLength: Boolean
        get() = value.validateUsernameLength()

    val isValidFormat: Boolean
        get() = value.validateUsernameFormat()

    private fun String.validateUsernameLength(): Boolean = length in USERNAME_LENGTH

    private fun String.validateUsernameFormat(): Boolean = matches(Regex(USERNAME_REGEX))

    companion object {
        private const val EMPTY_USERNAME = ""
        private const val MIN_USERNAME_LENGTH = 2
        private const val MAX_USERNAME_LENGTH = 5
        private val USERNAME_LENGTH = MIN_USERNAME_LENGTH..MAX_USERNAME_LENGTH
        private const val USERNAME_REGEX = "^[a-zA-Z가-힣]+$"
    }
}
