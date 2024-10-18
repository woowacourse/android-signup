package nextstep.signup.domain

import androidx.compose.runtime.Immutable

@JvmInline
value class Password(val value: String) {

    init {
        require(value.isNotBlank()) { "비밀번호는 공백일 수 없습니다." }
        require(value.hasAlpha()) { "비밀번호는 영문자를 포함해야 합니다." }
        require(value.hasNumber()) { "비밀번호는 숫자를 포함해야 합니다." }
        require(value.hasLength()) { "비밀번호는 8자 이상 16자 이하여야 합니다." }
    }

    companion object {
        const val MAX_LENGTH = 16
        const val MIN_LENGTH = 8
        private val ALPHA_REGEX = "[a-zA-Z]".toRegex()
        private val NUMBER_EXIST = "[0-9]".toRegex()

        private fun String.hasAlpha() = this.contains(ALPHA_REGEX)
        private fun String.hasNumber() = this.contains(NUMBER_EXIST)
        private fun String.hasLength() = this.length in MIN_LENGTH..MAX_LENGTH

        fun validate(password: String): PasswordValidateResult {
            return when {
                password.isBlank() -> PasswordValidateResult.InValidBlank
                password.hasAlpha().not() -> PasswordValidateResult.InValidNotContainAlpha
                password.hasNumber().not() -> PasswordValidateResult.InValidNotContainNumber
                password.hasLength().not() -> PasswordValidateResult.InValidNotInLength
                else -> PasswordValidateResult.Success
            }
        }
    }
}

@Immutable
sealed interface PasswordValidateResult {
    val isValid: Boolean get() = this is Success

    data object Success : PasswordValidateResult
    data object InValidBlank : PasswordValidateResult
    data object InValidNotContainAlpha : PasswordValidateResult
    data object InValidNotContainNumber : PasswordValidateResult
    data object InValidNotInLength : PasswordValidateResult
}
