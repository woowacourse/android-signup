package nextstep.signup.model

class Password(private val value: String) : InputValidation {
    private var inputError: InputError = InputError.None

    override fun isInvalid(): Boolean {
        return lengthValidate() || regexValidate()
    }

    override fun getValidationError(): InputError = if (isInvalid()) inputError else InputError.None

    private fun regexValidate(): Boolean {
        if (!value.matches(PASSWORD_REGEX.toRegex())) {
            inputError = InputError.PasswordError.InvalidFormat
            return true
        }
        return false
    }

    private fun lengthValidate(): Boolean {
        if (value.length !in MIN_LENGTH..MAX_LENGTH) {
            inputError = InputError.PasswordError.InvalidLength
            return true
        }
        return false
    }

    companion object {
        const val MIN_LENGTH = 8
        const val MAX_LENGTH = 16
        const val PASSWORD_REGEX = "^(?=.*[!@#\$%^&*()_+=\\-{}|:<>?,.]).+$"
        const val ERROR_USER_PASSWORD_LENGTH = "비밀번호는 $MIN_LENGTH~${MAX_LENGTH}자여야 합니다."
        const val ERROR_USER_PASSWORD_REGEX = "비밀번호에는 특수문자가 포함되어야 합니다."
    }
}
