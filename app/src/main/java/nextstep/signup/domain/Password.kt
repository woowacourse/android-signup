package nextstep.signup.domain

data class Password(
    val password: String = "",
    val passwordConfirm: String = ""
) {
    init {
        require(password.length in PASSWORD_RANGE) { "password has to be in $PASSWORD_RANGE" }
        require(regex.matches(password)) { "password must contain at least one English or number" }
    }

    fun isValid(): Boolean = password.isNotBlank() && password == passwordConfirm

    companion object {
        private const val MIN_PASSWORD_LENGTH = 8
        private const val MAX_PASSWORD_LENGTH = 16
        private val PASSWORD_RANGE = MIN_PASSWORD_LENGTH..MAX_PASSWORD_LENGTH

        const val PASSWORD_REGEX = "^(?=.*[a-zA-Z])(?=.*[0-9])$"
        private val regex = Regex(PASSWORD_REGEX)
    }
}
