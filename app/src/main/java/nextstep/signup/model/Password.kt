package nextstep.signup.model

data class Password(
    val content: String,
) : InputValidator {
    override fun validate(): ValidationState =
        when {
            content.isEmpty() -> ValidationState.Blank
            !hasValidLength() -> ValidationState.Invalid.Password.Length
            !hasValidFormat() -> ValidationState.Invalid.Password.Format
            else -> ValidationState.Valid
        }

    private fun hasValidLength(): Boolean = content.length in MINIMUM_LENGTH..MAXIMUM_LENGTH

    private fun hasValidFormat(): Boolean = content.matches(Regex(PASSWORD_REGEX))

    companion object {
        const val PASSWORD_REGEX = "^(?=.*[a-zA-Z])(?=.*[0-9]).*$"
        const val MAXIMUM_LENGTH = 16
        const val MINIMUM_LENGTH = 8
    }
}
