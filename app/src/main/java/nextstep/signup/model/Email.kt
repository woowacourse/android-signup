package nextstep.signup.model

class Email(private val value: String) : InputValidation {
    private var inputError: InputError = InputError.None

    override fun isInvalid(): Boolean {
        return regexValidate()
    }

    override fun getValidationError(): InputError = if (isInvalid()) inputError else InputError.None

    private fun regexValidate(): Boolean {
        if (!value.matches(EMAIL_REGEX.toRegex())) {
            inputError = InputError.EmailError.InvalidFormat
            return true
        }
        return false
    }

    companion object {
        const val EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
    }
}
