package woowacourse.signup.ui.signup.model

import woowacourse.signup.R
import woowacourse.signup.domain.Email
import woowacourse.signup.domain.InvalidEmailException

class EmailUiModel(val value: String = "") {
    fun isError(): Boolean {
        return runCatching { Email(value) }.isFailure
    }

    fun errorMessage(): Int? {
        val exception = runCatching { Email(value) }.exceptionOrNull() ?: return null
        return when (exception) {
            is InvalidEmailException -> R.string.invalid_email
            else -> null
        }
    }
}
