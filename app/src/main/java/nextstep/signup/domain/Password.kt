package nextstep.signup.domain

data class Password(
    val password: String = "",
    val passwordConfirm: String = ""
) {
    init {
        require(password.length in PASSWORD_RANGE) { "password has to be in $PASSWORD_RANGE" }
        require(regex.matches(password)) { "password must contain at least one English and number" }
        require(password == passwordConfirm) { "password and password confirm is different" }
    }

    fun isValid(): Boolean = password.isNotBlank() && password == passwordConfirm

    companion object {
        private const val MIN_PASSWORD_LENGTH = 8
        private const val MAX_PASSWORD_LENGTH = 16
        private val PASSWORD_RANGE = MIN_PASSWORD_LENGTH..MAX_PASSWORD_LENGTH

        private const val PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*\\d).+$"

        private val regex = Regex(PASSWORD_REGEX)
    }
}
