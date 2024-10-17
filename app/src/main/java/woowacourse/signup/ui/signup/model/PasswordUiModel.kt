package woowacourse.signup.ui.signup.model

import woowacourse.signup.R
import woowacourse.signup.domain.InvalidPasswordCompositionException
import woowacourse.signup.domain.InvalidPasswordLengthException
import woowacourse.signup.domain.Password
import java.lang.IllegalArgumentException

class PasswordUiModel(val value: String = "") {
    fun isError(): Boolean {
        return try {
            Password(value)
            false
        } catch (exception: IllegalArgumentException) {
            true
        }
    }

    fun errorMessage(): Int? {
        return try {
            Password(value)
            null
        } catch (exception: IllegalArgumentException) {
            when (exception) {
                is InvalidPasswordLengthException -> R.string.invalid_password_length
                is InvalidPasswordCompositionException -> R.string.invalid_password_composition
                else -> null
            }
        }
    }
}
