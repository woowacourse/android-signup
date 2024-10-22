package nextstep.signup.ui.model

import nextstep.signup.R

data class Email(val value: String = "") {
    val validation: SignUpResult
        get() = isValidEmail()

    private fun isValidEmail(): SignUpResult {
        return when {
            value.isEmpty() -> SignUpResult.Blank(isValid = false)

            !validateEmailComposition() ->
                SignUpResult.Error(
                    false,
                    R.string.signup_email_composition_error,
                )

            else -> SignUpResult.Success(isValid = true)
        }
    }

    private fun validateEmailComposition(): Boolean =
        value.matches(
            Regex(EMAIL_REGEX),
        )

    companion object {
        private const val EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
    }
}
