package nextstep.signup.model

data class Password(val password: String) {
    fun isError() = !isBlank() && !isValid()

    fun isValid() = isValidLength() && hasEnglishAndNumber()

    fun validate(): PasswordValidResult =
        when {
            isBlank() -> PasswordValidResult.Blank
            !isValidLength() -> PasswordValidResult.InvalidLength
            !hasEnglishAndNumber() -> PasswordValidResult.InvalidCharacter
            else -> PasswordValidResult.Success
        }

    private fun isBlank(): Boolean = password.isBlank()

    private fun isValidLength(): Boolean = password.length in PASSWORD_MIN_LENGTH..PASSWORD_MAX_LENGTH

    private fun hasEnglishAndNumber(): Boolean = password.matches(Regex(PASSWORD_REGEX))

    companion object {
        private const val PASSWORD_REGEX = "^(?=.*[a-zA-Z])(?=.*[0-9]).*$"
        private const val PASSWORD_MIN_LENGTH = 8
        private const val PASSWORD_MAX_LENGTH = 16
    }
}
