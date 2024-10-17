package nextstep.signup.domain

data class PasswordConfirm(val value: String, private val password: String) {
    init {
        require(isValid(value, password)) { "비밀번호가 일치하지 않습니다." }
    }

    companion object {
        private fun isValid(password: String, confirmPassword: String): Boolean {
            return password == confirmPassword
        }

        fun from(password: String, confirmPassword: String): PasswordConfirmResult {
            return if (isValid(password, confirmPassword)) {
                PasswordConfirmResult.Success(PasswordConfirm(confirmPassword, password))
            } else {
                PasswordConfirmResult.InValid
            }
        }
    }
}

sealed interface PasswordConfirmResult {
    data class Success(val passwordConfirm: PasswordConfirm) : PasswordConfirmResult
    data object InValid : PasswordConfirmResult
}