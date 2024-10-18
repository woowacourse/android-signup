package nextstep.signup.model

class PasswordConfirm(
    private var value: String,
    private var originalPassword: String
) : InputValidation {
    private var errorMessage: String? = null

    override fun isInvalid(): Boolean {
        if (value != originalPassword) {
            errorMessage = ERROR_USER_PASSWORD_CONFIRM
            return true
        }
        return false
    }

    override fun getErrorMessage() = if (isInvalid()) errorMessage else null

    fun setValue(password: String, passwordConfirm: String) {
        value = passwordConfirm
        originalPassword = password
    }

    companion object {
        const val ERROR_USER_PASSWORD_CONFIRM = "비밀번호가 일치하지 않습니다."
    }
}
