package nextstep.signup.ui.model

import nextstep.signup.R

data class Password(val value: String = "") {
    val validation: SignUpResult
        get() = isValidPassword()

    private fun isValidPassword(): SignUpResult {
        return when {
            value.isEmpty() -> SignUpResult.Blank(isValid = false)

            !validatePasswordLength() ->
                SignUpResult.Error(
                    isValid = false,
                    errorMessage = R.string.signup_password_length_error,
                )

            !validatePasswordComposition() ->
                SignUpResult.Error(
                    isValid = false,
                    errorMessage = R.string.signup_password_composition_error,
                )

            else -> SignUpResult.Success(isValid = true)
        }
    }

    private fun validatePasswordLength() = value.length in PASSWORD_LENGTH

    private fun validatePasswordComposition(): Boolean =
        value.matches(
            Regex(PASSWORD_REGEX),
        )

    companion object {
        private const val PASSWORD_REGEX = "^(?=.*[a-zA-Z])(?=.*[0-9]).{8,16}$"
        private val PASSWORD_LENGTH = 8..16
    }
}
