package nextstep.signup.ui.model

class Password(
    override val text: String = DEFAULT_PASSWORD_TEXT,
) : SignUpModel {
    override fun validState(): SignUpState {
        return when {
            isBlank() -> SignUpState.Blank
            !isValidLength() -> SignUpState.InValid.PasswordLength
            !isValidText() -> SignUpState.InValid.PasswordType
            else -> SignUpState.Valid
        }
    }

    override fun isBlank(): Boolean {
        return text.isBlank()
    }

    private fun isValidLength(): Boolean {
        return text.matches(PASSWORD_REGEX_LENGTH.toRegex())
    }

    private fun isValidText(): Boolean {
        return text.matches(PASSWORD_REGEX_TEXT.toRegex())
    }

    companion object {
        private const val DEFAULT_PASSWORD_TEXT = ""
        private const val PASSWORD_REGEX_LENGTH = "^[\\s\\S]{8,16}\$"
        private const val PASSWORD_REGEX_TEXT = "^(?=.*[a-zA-Z])(?=.*[0-9]).+\$"
    }
}
