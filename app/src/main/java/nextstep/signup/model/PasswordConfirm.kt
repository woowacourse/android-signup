package nextstep.signup.model

class PasswordConfirm(
    private val value: String,
    private val originalPassword: String
) : InputValidation {
    private var errorMessage: String? = null

    override fun isInValid(): Boolean {
        if (value != originalPassword) {
            errorMessage = ERROR_USER_PASSWORD_CONFIRM
            return true
        }
        return false
    }

    override fun getErrorMessage() = if (isInValid()) errorMessage else null

    companion object {
        const val ERROR_USER_PASSWORD_CONFIRM = "비밀번호가 일치하지 않습니다."
    }
}
