package nextstep.signup.domain

data class SignUp(
    val email: Email,
    val username: Username,
    val password: Password,
    val confirmPassword: Password,

) {
    fun isValid(): Boolean = email.isValid() && username.isValid() && password.isValid() && confirmPassword.isValid() && password == confirmPassword

    companion object {
        val BLANK_SIGN_UP = SignUp(
            email = Email(),
            username = Username(),
            password = Password(),
            confirmPassword = Password(),
        )
    }
}
