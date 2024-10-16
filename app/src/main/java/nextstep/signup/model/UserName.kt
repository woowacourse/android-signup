package nextstep.signup.model

data class UserName(
    val content: String,
) : InputValidator {
    override fun isValid(): Boolean = hasValidLength() && hasValidFormat()

    override fun getErrorMessage(): String? =
        when {
            !hasValidLength() -> ERROR_USERNAME_LENGTH_MESSAGE
            !hasValidFormat() -> ERROR_USERNAME_FORMAT_MESSAGE
            else -> null
        }

    private fun hasValidLength(): Boolean = content.length in 2..5

    private fun hasValidFormat(): Boolean = content.matches(Regex(USERNAME_REGEX))

    companion object {
        const val USERNAME_REGEX = "^[a-zA-Z가-힣]+$"
        const val ERROR_USERNAME_LENGTH_MESSAGE = "이름은 2~5자여야 합니다."
        const val ERROR_USERNAME_FORMAT_MESSAGE = "이름에는 숫자나 기호가 포함될 수 없습니다."
    }
}
