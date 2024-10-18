package nextstep.signup.domain

data class SignUp(
    val email: Email,
    val username: Username,
    val password: Password,
    val confirmPassword: Password
) : ErrorHandler {
    override val error: Error
        get() = when {
            confirmPassword.value.isBlank() -> Error.NO_ERROR
            !isValid() -> Error.INVALID_CONFIRM_PASSWORD
            else -> Error.NO_ERROR
        }

    fun isValid(): Boolean =
        email.isValid() && username.isValid() && password.isValid() && confirmPassword.isValid() && password == confirmPassword

    companion object {
        val BLANK_SIGN_UP = SignUp(
            email = Email(),
            username = Username(),
            password = Password(),
            confirmPassword = Password()
        )
    }
}
