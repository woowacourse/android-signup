package nextstep.signup.model

data class Password(val password: String) {
    fun isError() = !isBlank() && !isValid()

    fun isValid() = isValidLength() && hasEnglishAndNumber()

    fun getErrorMessage(): String? =
        when {
            isBlank() -> null
            !isValidLength() -> PASSWORD_LENGTH_ERROR
            !hasEnglishAndNumber() -> PASSWORD_FORM_ERROR
            else -> null
        }

    private fun isBlank(): Boolean = password.isBlank()

    private fun isValidLength(): Boolean = password.length in PASSWORD_MIN_LENGTH..PASSWORD_MAX_LENGTH

    private fun hasEnglishAndNumber(): Boolean = password.matches(Regex(PASSWORD_REGEX))

    companion object {
        private const val PASSWORD_REGEX = "^(?=.*[a-zA-Z])(?=.*[0-9]).{8,16}$"
        private const val PASSWORD_LENGTH_ERROR = "비밀번호는 8~16자여야 합니다."
        private const val PASSWORD_FORM_ERROR = "비밀번호는 영문과 숫자를 포함해야 합니다."
        private const val PASSWORD_MIN_LENGTH = 8
        private const val PASSWORD_MAX_LENGTH = 16
    }
}
