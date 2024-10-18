package woowacourse.signup.ui.signup.model

import woowacourse.signup.R
import woowacourse.signup.domain.InvalidUserNameCompositionException
import woowacourse.signup.domain.InvalidUserNameLengthException
import woowacourse.signup.domain.UserName
import java.lang.IllegalArgumentException

class UserNameUiModel(val value: String = "") {
    fun isError(): Boolean {
        return try {
            UserName(value)
            false
        } catch (exception: IllegalArgumentException) {
            true
        }
    }

    fun errorMessage(): Int? {
        return try {
            UserName(value)
            null
        } catch (exception: IllegalArgumentException) {
            when (exception) {
                is InvalidUserNameLengthException -> R.string.invalid_username_length
                is InvalidUserNameCompositionException -> R.string.invalid_username_composition
                else -> null
            }
        }
    }
}
