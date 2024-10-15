package nextstep.signup.domain

data class Username(
    val name: String = ""
) {
    fun isValid(): Boolean = isValidLength() && isValidTextType()

    private fun isValidTextType(): Boolean = name.matches(USERNAME_REGEX_TEXT_TYPE.toRegex())

    private fun isValidLength(): Boolean = name.matches(USERNAME_REGEX_LENGTH.toRegex())

    fun errorMessage(): Error? = when {
        name.isBlank() -> null
        name.isBlank() -> Error.NO_ERROR
        !isValidLength() -> Error.INVALID_USERNAME_LENGTH
        !isValidTextType() -> Error.INVALID_USERNAME_TYPE
        else -> Error.NO_ERROR
    }

    companion object {
        private const val USERNAME_REGEX_LENGTH = "^.{2,5}\$"
        private const val USERNAME_REGEX_TEXT_TYPE = "^[a-zA-Z가-힣]*\$"
    }
}
