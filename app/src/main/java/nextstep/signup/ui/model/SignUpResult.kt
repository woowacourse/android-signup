package nextstep.signup.ui.model

import androidx.annotation.StringRes

sealed class SignUpResult(
    val isValid: Boolean,
    @StringRes val errorMessage: Int? = null,
) {
    class Blank(isValid: Boolean) : SignUpResult(isValid)

    class Success(isValid: Boolean) : SignUpResult(isValid)

    class Error(isValid: Boolean, errorMessage: Int) : SignUpResult(isValid, errorMessage)
}
