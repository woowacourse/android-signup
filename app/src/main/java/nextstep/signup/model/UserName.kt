package nextstep.signup.model

data class UserName(
    val content: String,
) : InputValidator {
    override fun validate(): ValidationState =
        when {
            content.isEmpty() -> ValidationState.Blank
            !hasValidLength() -> ValidationState.Invalid.UserName.Length
            !hasValidFormat() -> ValidationState.Invalid.UserName.Format
            else -> ValidationState.Valid
        }

    private fun hasValidLength(): Boolean = content.length in MINIMUM_LENGTH..MAXIMUM_LENGTH

    private fun hasValidFormat(): Boolean = content.matches(Regex(USERNAME_REGEX))

    companion object {
        const val USERNAME_REGEX = "^[a-zA-Z가-힣]+$"
        const val MAXIMUM_LENGTH = 5
        const val MINIMUM_LENGTH = 2
    }
}
