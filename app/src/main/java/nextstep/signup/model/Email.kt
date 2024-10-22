package nextstep.signup.model

data class Email(
    val content: String,
) : InputValidator {
    private fun hasValidFormat(): Boolean = content.matches(Regex(EMAIL_REGEX))

    override fun validate(): ValidationState =
        when {
            content.isEmpty() -> ValidationState.Blank
            !hasValidFormat() -> ValidationState.Invalid.Email.InvalidFormat
            else -> ValidationState.Valid
        }

    companion object {
        const val EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
    }
}
