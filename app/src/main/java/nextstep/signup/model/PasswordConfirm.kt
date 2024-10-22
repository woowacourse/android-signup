package nextstep.signup.model

class PasswordConfirm(
    private var value: String,
    private var originalPassword: String
) : InputValidation {
    private var inputError: InputError = InputError.None

    override fun isInvalid(): Boolean {
        if (value != originalPassword) {
            inputError = InputError.PasswordConfirmError.PasswordMismatch
            return true
        }
        return false
    }

    override fun getValidationError(): InputError = if (isInvalid()) inputError else InputError.None

    fun setValue(password: String, passwordConfirm: String) {
        value = passwordConfirm
        originalPassword = password
    }
}
