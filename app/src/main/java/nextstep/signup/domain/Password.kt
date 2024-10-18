package nextstep.signup.domain

@JvmInline
value class Password(val content: String) {
    init {
        require(content.length in PASSWORD_RANGE) { "password has to be in $PASSWORD_RANGE" }
        require(regex.matches(content)) { "password must contain at least one English and number" }
    }

    companion object {
        private const val MIN_PASSWORD_LENGTH = 8
        private const val MAX_PASSWORD_LENGTH = 16
        private val PASSWORD_RANGE = MIN_PASSWORD_LENGTH..MAX_PASSWORD_LENGTH

        private const val PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*\\d).+$"

        private val regex = Regex(PASSWORD_REGEX)

        fun from(passwordInput: String): PasswordResult {
            if (passwordInput == "") return PasswordResult.EmptyField
            if (passwordInput.length !in PASSWORD_RANGE) return PasswordResult.InvalidPasswordLength
            if (!regex.matches(passwordInput)) return PasswordResult.InvalidPasswordFormat
            return PasswordResult.Success(Password(passwordInput))
        }
    }
}

sealed interface PasswordResult {
    data class Success(val password: Password) : PasswordResult

    data object EmptyField : PasswordResult

    sealed interface Failure : PasswordResult

    data object InvalidPasswordLength : Failure

    data object InvalidPasswordFormat : Failure
}
