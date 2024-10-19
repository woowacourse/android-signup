package woowacourse.signup.ui.signup.model

import android.content.res.Resources
import woowacourse.signup.R
import woowacourse.signup.domain.InvalidUserNameCompositionException
import woowacourse.signup.domain.InvalidUserNameLengthException
import woowacourse.signup.domain.UserName

class UserNameUiModel(val value: String = "") {
    fun isError(): Boolean {
        return runCatching { UserName(value) }.isFailure
    }

    fun errorMessage(resources: Resources): String {
        if (value.isBlank()) return ""
        val exception = runCatching { UserName(value) }.exceptionOrNull() ?: return ""
        return when (exception) {
            is InvalidUserNameLengthException -> resources.getString(R.string.invalid_username_length)
            is InvalidUserNameCompositionException -> resources.getString(R.string.invalid_username_composition)
            else -> ""
        }
    }
}
