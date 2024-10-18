package nextstep.signup.model

data class UserName(val userName: String) {
    fun isInvalid() = !isBlank() && (!isValidLength() || !hasInvalidCharacter())

    fun getErrorMessage(): String? =
        when {
            isBlank() -> null
            !isValidLength() -> USERNAME_LENGTH_ERROR
            !hasInvalidCharacter() -> USERNAME_FORM_ERROR
            else -> null
        }

    private fun isBlank() = userName.isBlank()

    private fun isValidLength() = userName.length in USERNAME_MIN_LENGTH..USERNAME_MAX_LENGTH

    private fun hasInvalidCharacter() = userName.matches(regex = Regex(USERNAME_REGEX))

    companion object {
        const val USERNAME_REGEX = "^[a-zA-Z가-힣]+$"
        private const val USERNAME_LENGTH_ERROR = "이름은 2~5자여야 합니다."
        private const val USERNAME_FORM_ERROR = "이름에는 숫자나 기호가 포함될 수 없습니다."
        const val USERNAME_MIN_LENGTH = 2
        const val USERNAME_MAX_LENGTH = 5
    }
}
