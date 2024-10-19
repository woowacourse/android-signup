package woowacourse.signup.ui.signup.model

import android.content.res.Resources
import woowacourse.signup.R

class PasswordConfirmUiModel(val value: String = "") {
    fun isError(password: PasswordUiModel): Boolean {
        return value != password.value
    }

    fun errorMessage(
        resources: Resources,
        password: PasswordUiModel,
    ): String {
        if (value.isBlank()) return ""
        if (isError(password)) {
            return resources.getString(R.string.invalid_password_confirm)
        }
        return ""
    }
}
