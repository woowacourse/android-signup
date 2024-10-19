package woowacourse.signup.ui.signup.model

import woowacourse.signup.R
import woowacourse.signup.domain.InvalidPasswordCompositionException
import woowacourse.signup.domain.InvalidPasswordLengthException
import woowacourse.signup.domain.Password

class PasswordUiModel(val value: String = "") {
    fun isError(): Boolean {
        return runCatching { Password(value) }.isFailure
    }

    fun errorMessage(): Int? {
        val exception = runCatching { Password(value) }.exceptionOrNull() ?: return null
        return when (exception) {
            is InvalidPasswordLengthException -> R.string.invalid_password_length
            is InvalidPasswordCompositionException -> R.string.invalid_password_composition
            else -> null
        }
    }
}
