package nextstep.signup.domain

import androidx.compose.runtime.Immutable

data class PasswordConfirm(val value: String, private val password: String) {
    init {
        require(isValid(value, password)) { "비밀번호가 일치하지 않습니다." }
    }

    companion object {
        private fun isValid(password: String, confirmPassword: String): Boolean {
            return password == confirmPassword
        }

        fun validate(password: String, confirmPassword: String): PasswordConfirmValidateResult {
            return if (isValid(password, confirmPassword)) {
                PasswordConfirmValidateResult.Success
            } else {
                PasswordConfirmValidateResult.InValid
            }
        }
    }
}

@Immutable
sealed interface PasswordConfirmValidateResult {
    val isValid: Boolean get() = this is Success

    data object Success : PasswordConfirmValidateResult
    data object InValid : PasswordConfirmValidateResult
}