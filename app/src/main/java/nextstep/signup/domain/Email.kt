package nextstep.signup.domain

import androidx.compose.runtime.Immutable

@JvmInline
value class Email(val value: String) {

    init {
        require(value.isNotBlank()) { "이메일은 공백일 수 없습니다." }
        require(value.isValidEmailFormat()) { "이메일 형식이 올바르지 않습니다. e. sample@gmail.com" }
    }

    companion object {
        private const val EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}\$"

        private fun String.isValidEmailFormat(): Boolean {
            return matches(EMAIL_REGEX.toRegex())
        }

        fun validate(email: String): EmailValidateResult {
            return when {
                email.isBlank() -> EmailValidateResult.InvalidBlank
                email.isValidEmailFormat().not() -> EmailValidateResult.InvalidEmailFormat
                else -> EmailValidateResult.Success
            }
        }
    }
}

@Immutable
sealed interface EmailValidateResult {
    val isValid: Boolean get() = this is Success

    data object Success : EmailValidateResult
    data object InvalidBlank : EmailValidateResult
    data object InvalidEmailFormat : EmailValidateResult
}
