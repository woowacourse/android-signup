package woowacourse.signup.ui.signup.model

import woowacourse.signup.R

class PasswordConfirmUiModel(val value: String = "") {
    fun isError(password: PasswordUiModel): Boolean {
        return value != password.value
    }

    fun errorMessage(password: PasswordUiModel): Int? {
        return if (isError(password)) {
            R.string.invalid_password_confirm
        } else {
            null
        }
    }
}
