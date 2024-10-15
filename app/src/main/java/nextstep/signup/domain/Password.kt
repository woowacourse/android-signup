package nextstep.signup.domain

data class Password(
    val value: String = ""
) {
    fun isValid(): Boolean = isValidLength() && isValidTextType()

    private fun isValidLength(): Boolean = value.matches(PASSWORD_REGEX_LENGTH.toRegex())

    private fun isValidTextType(): Boolean = value.matches(PASSWORD_REGEX_TEXT_TYPE.toRegex())

    fun errorMessage(): Error? = when {
        value.isBlank() -> null
        !isValidTextType() -> Error.INVALID_PASSWORD_TYPE
        !isValidLength() -> Error.INVALID_PASSWORD_LENGTH
        else -> null
    }

    companion object {
        private const val PASSWORD_REGEX_LENGTH = "^[\\s\\S]{8,16}\$"
        private const val PASSWORD_REGEX_TEXT_TYPE = "^(?=.*[a-zA-Z])(?=.*[0-9]).+\$"
    }
}
