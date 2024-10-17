package nextstep.signup.ui.domain

class Password(
    val text: String = DEFAULT_PASSWORD_TEXT
) {
    fun isValid(): Boolean =  isValidLength() && isValidText()

    private fun isValidLength() : Boolean  =
        text.matches(PASSWORD_REGEX_LENGTH.toRegex())

    private fun isValidText() : Boolean =
        text.matches(PASSWORD_REGEX_TEXT.toRegex())

    companion object {
        private const val DEFAULT_PASSWORD_TEXT = ""
        private const val PASSWORD_REGEX_LENGTH = "^[\\s\\S]{8,16}\$"
        private const val PASSWORD_REGEX_TEXT = "^(?=.*[a-zA-Z])(?=.*[0-9]).+\$"
    }
}
