package nextstep.signup.domain

data class Password3(
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

        fun from(password: String, passwordConfirm: String): PasswordResult3 {
            if (password == "" || passwordConfirm == "") return PasswordResult3.EmptyField
            if (password.length !in PASSWORD_RANGE) return PasswordResult3.InvalidPasswordLength
            if (!regex.matches(password)) return PasswordResult3.InvalidPasswordFormat
            if (password != passwordConfirm) return PasswordResult3.NotSamePasswordConfirm
            return PasswordResult3.Success(password, passwordConfirm)
        }
    }
}

sealed interface PasswordResult3 {
    data class Success(val password: String, val passwordConfirm: String) : PasswordResult3

    data object EmptyField : PasswordResult3

    sealed interface Failure : PasswordResult3

    data object InvalidPasswordLength : Failure

    data object InvalidPasswordFormat : Failure

    data object NotSamePasswordConfirm : Failure
}
