package nextstep.signup.domain

data class SignUp(
    val email: Email,
    val password: Password,
    val username: Username
) {
    fun isValid(): Boolean = email.isValid() && password.isValid() && username.isValid()

    companion object {
        val BLANK_SIGN_UP = SignUp(
            email = Email(""),
            password = Password(
                "",
                ""
            ),
            username = Username("")
        )
    }
}
