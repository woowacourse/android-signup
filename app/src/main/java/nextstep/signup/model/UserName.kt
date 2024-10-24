package nextstep.signup.model

data class UserName(val userName: String) {
    fun isError(): Boolean = !isBlank() && !isValid()

    fun isValid(): Boolean = isValidLength() && hasValidCharacter()

    fun validate(): UserNameValidResult =
        when {
            isBlank() -> UserNameValidResult.Blank
            !isValidLength() -> UserNameValidResult.InvalidLength
            !hasValidCharacter() -> UserNameValidResult.InvalidCharacter
            else -> UserNameValidResult.Success
        }

    private fun isBlank() = userName.isBlank()

    private fun isValidLength() = userName.length in USERNAME_MIN_LENGTH..USERNAME_MAX_LENGTH

    private fun hasValidCharacter() = userName.matches(regex = Regex(USERNAME_REGEX))

    companion object {
        const val USERNAME_REGEX = "^[a-zA-Z가-힣]+$"
        private const val USERNAME_MIN_LENGTH = 2
        private const val USERNAME_MAX_LENGTH = 5
    }
}
