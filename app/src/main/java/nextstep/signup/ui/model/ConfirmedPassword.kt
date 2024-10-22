package nextstep.signup.ui.model

import nextstep.signup.R

data class ConfirmedPassword(val value: String = "", private val password: String) {
    val validation: SignUpResult
        get() = isValidConfirmedPassword()

    private fun isValidConfirmedPassword(): SignUpResult {
        return when {
            value.isEmpty() -> SignUpResult.Blank(isValid = false)

            !validateConfirmedPassword(password, value) ->
                SignUpResult.Error(
                    isValid = false,
                    errorMessage = R.string.signup_password_confirm_error,
                )

            else -> SignUpResult.Success(isValid = true)
        }
    }

    private fun validateConfirmedPassword(
        password: String,
        confirmedPassword: String,
    ): Boolean {
        return password == confirmedPassword
    }
}
