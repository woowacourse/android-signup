package nextstep.signup.domain


data class Password(
    val password: String = "",
    val passwordConfirm: String = "",
) {
    init {
        require(password.length in PASSWORD_RANGE) { "password has to be in $PASSWORD_RANGE" }
    }

    fun isValid(): Boolean = password.isNotBlank() && password == passwordConfirm

    companion object {
        private const val MIN_PASSWORD_LENGTH = 8
        private const val MAX_PASSWORD_LENGTH = 16
        private val PASSWORD_RANGE = MIN_PASSWORD_LENGTH..MAX_PASSWORD_LENGTH
    }
}
