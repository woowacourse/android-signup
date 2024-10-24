package nextstep.signup.ui.model

data class Email(
    override val text: String = DEFAULT_EMAIL_ADDRESS
) : SignUpModel {
    override fun isValidState(): SignUpState {
        return when {
            isBlank() -> SignUpState.Blank
            !isValidEmail() -> SignUpState.InValid.Email
            else -> SignUpState.Valid
        }
    }

    override fun isBlank(): Boolean {
        return text.isBlank()
    }

    private fun isValidEmail(): Boolean {
        return text.matches(EMAIL_REGEX.toRegex())
    }

    companion object {
        private const val DEFAULT_EMAIL_ADDRESS = ""
        private const val EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
    }
}
