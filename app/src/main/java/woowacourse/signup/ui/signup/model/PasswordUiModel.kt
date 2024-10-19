package woowacourse.signup.ui.signup.model

import android.content.res.Resources
import woowacourse.signup.R
import woowacourse.signup.domain.InvalidPasswordCompositionException
import woowacourse.signup.domain.InvalidPasswordLengthException
import woowacourse.signup.domain.Password

class PasswordUiModel(val value: String = "") {
    fun isError(): Boolean {
        return runCatching { Password(value) }.isFailure
    }

    fun errorMessage(resources: Resources): String {
        if (value.isBlank()) return ""
        val exception = runCatching { Password(value) }.exceptionOrNull() ?: return ""
        return when (exception) {
            is InvalidPasswordLengthException -> resources.getString(R.string.invalid_password_length)
            is InvalidPasswordCompositionException -> resources.getString(R.string.invalid_password_composition)
            else -> ""
        }
    }
}
