package nextstep.signup.model

class Name(private val value: String) : InputValidation {
    private var inputError: InputError = InputError.None

    override fun isInvalid(): Boolean {
        return regexValidate() || lengthValidate()
    }

    override fun getValidationError(): InputError = if (isInvalid()) inputError else InputError.None

    private fun regexValidate(): Boolean {
        if (!value.matches(NAME_REGEX.toRegex())) {
            inputError = InputError.NameError.InvalidFormat
            return true
        }
        return false
    }

    private fun lengthValidate(): Boolean {
        if (value.length !in MIN_LENGTH..MAX_LENGTH) {
            inputError = InputError.NameError.InvalidLength
            return true
        }
        return false
    }

    companion object {
        const val MIN_LENGTH = 2
        const val MAX_LENGTH = 5
        const val NAME_REGEX = "^[a-zA-Z가-힣]+$"
    }
}
