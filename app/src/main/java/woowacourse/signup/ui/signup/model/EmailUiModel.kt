package woowacourse.signup.ui.signup.model

import android.content.res.Resources
import woowacourse.signup.R
import woowacourse.signup.domain.Email
import woowacourse.signup.domain.InvalidEmailException

class EmailUiModel(val value: String = "") {
    fun isError(): Boolean {
        return runCatching { Email(value) }.isFailure
    }

    fun errorMessage(resources: Resources): String {
        if (value.isBlank()) return ""
        val exception = runCatching { Email(value) }.exceptionOrNull() ?: return ""
        return when (exception) {
            is InvalidEmailException -> resources.getString(R.string.invalid_email)
            else -> ""
        }
    }
}
