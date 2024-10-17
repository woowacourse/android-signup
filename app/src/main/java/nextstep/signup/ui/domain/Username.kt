package nextstep.signup.ui.domain

data class Username(
    val name: String = DEFAULT_NAME
) {
    fun isValid(): Boolean = isValidText() && isValidLength()

    private fun isValidLength(): Boolean =
        name.matches(USERNAME_REGEX_LENGTH.toRegex())

    private fun isValidText() : Boolean =
        name.matches(USERNAME_REGEX_TEXT.toRegex())

    companion object {
        private const val DEFAULT_NAME = ""
        private const val USERNAME_REGEX_LENGTH = "^.{2,5}\$"
        private const val USERNAME_REGEX_TEXT = "^[a-zA-Z가-힣]*\$"
    }
}
