package woowacourse.signup.ui.signup.model

import woowacourse.signup.R
import woowacourse.signup.domain.Email
import woowacourse.signup.domain.InvalidEmailException
import java.lang.IllegalArgumentException

class EmailUiModel(val value: String = "") {
    fun isError(): Boolean {
        return try {
            Email(value)
            false
        } catch (exception: IllegalArgumentException) {
            true
        }
    }

    fun errorMessage(): Int? {
        return try {
            Email(value)
            null
        } catch (exception: IllegalArgumentException) {
            when (exception) {
                is InvalidEmailException -> R.string.invalid_email
                else -> null
            }
        }
    }
}
