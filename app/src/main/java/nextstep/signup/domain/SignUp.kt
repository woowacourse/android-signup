package nextstep.signup.domain

data class SignUp(
    val email: Email,
    val username: Username,
    val password: Password,
    val confirmPassword: Password
): ErrorHandler {
    fun isValid(): Boolean = email.isValid() && username.isValid() && password.isValid() && confirmPassword.isValid() && password == confirmPassword

    override fun errorMessage(): Error = when {
        confirmPassword.value.isBlank() -> Error.NO_ERROR
        !isValid() -> Error.INVALID_CONFIRM_PASSWORD
        else -> Error.NO_ERROR
    }

    companion object {
        val BLANK_SIGN_UP = SignUp(
            email = Email(),
            username = Username(),
            password = Password(),
            confirmPassword = Password()
        )
    }
}
