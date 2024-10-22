package nextstep.signup.model

data class Email(val email: String) {
    fun isError(): Boolean = !isBlank() && !isValid()

    fun isValid(): Boolean = email.matches(Regex(EMAIL_REGEX))

    fun validate(): EmailValidResult =
        when {
            isBlank() -> EmailValidResult.Blank
            !isValid() -> EmailValidResult.InvalidForm
            else -> EmailValidResult.Success
        }

    private fun isBlank(): Boolean = email.isBlank()

    companion object {
        private const val EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
    }
}
