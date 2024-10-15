package nextstep.signup.domain

data class Password(
    val value: String = ""
) : ErrorHandler {
    fun isValid(): Boolean = isValidLength() && isValidTextType()

    private fun isValidLength(): Boolean = value.matches(PASSWORD_REGEX_LENGTH.toRegex())

    private fun isValidTextType(): Boolean = value.matches(PASSWORD_REGEX_TEXT_TYPE.toRegex())

    override fun errorMessage(): Error = when {
        value.isBlank() -> Error.NO_ERROR
        !isValidTextType() -> Error.INVALID_PASSWORD_TYPE
        !isValidLength() -> Error.INVALID_PASSWORD_LENGTH
        else -> Error.NO_ERROR
    }

    companion object {
        private const val PASSWORD_REGEX_LENGTH = "^[\\s\\S]{8,16}\$"
        private const val PASSWORD_REGEX_TEXT_TYPE = "^(?=.*[a-zA-Z])(?=.*[0-9]).+\$"
    }
}
