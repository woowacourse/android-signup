package nextstep.signup.model

class Name(private val value: String) : InputValidation {
    private var errorMessage: String? = null

    override fun isInvalid(): Boolean {
        return regexValidate() || lengthValidate()
    }

    override fun getErrorMessage() = if (isInvalid()) errorMessage else null

    private fun regexValidate(): Boolean {
        if (!value.matches(NAME_REGEX.toRegex())) {
            errorMessage = ERROR_USER_NAME_REGEX
            return true
        }
        return false
    }

    private fun lengthValidate(): Boolean {
        if (value.length !in MIN_LENGTH..MAX_LENGTH) {
            errorMessage = ERROR_USER_NAME_LENGTH
            return true
        }
        return false
    }

    companion object {
        const val MIN_LENGTH = 2
        const val MAX_LENGTH = 5
        const val NAME_REGEX = "^[a-zA-Z가-힣]+$"
        const val ERROR_USER_NAME_LENGTH = "이름은 2~5자여야 합니다."
        const val ERROR_USER_NAME_REGEX = "이름에는 특수문자가 포함될 수 없습니다."
    }
}
