package woowacourse.signup.ui.signup.model

import woowacourse.signup.R
import woowacourse.signup.domain.InvalidUserNameCompositionException
import woowacourse.signup.domain.InvalidUserNameLengthException
import woowacourse.signup.domain.UserName

class UserNameUiModel(val value: String = "") {
    fun isError(): Boolean {
        return runCatching { UserName(value) }.isFailure
    }

    fun errorMessage(): Int? {
        val exception = runCatching { UserName(value) }.exceptionOrNull() ?: return null
        return when (exception) {
            is InvalidUserNameLengthException -> R.string.invalid_username_length
            is InvalidUserNameCompositionException -> R.string.invalid_username_composition
            else -> null
        }
    }
}
