package nextstep.signup.domain

data class SignUp(
    val email: Email,
    val username: Username,
    val password: Password,
    val confirmPassword: Password
) {
    fun isValid(): Boolean = email.isValid() && username.isValid() && password.isValid() && confirmPassword.isValid() && password == confirmPassword

    fun errorMessage(): Error? = when {
        confirmPassword.value.isBlank() -> null
        !isValid() -> Error.INVALID_CONFIRM_PASSWORD
        else -> null
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
