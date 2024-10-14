package nextstep.signup.domain

data class SignUp(
    val userName: UserName,
    val email: Email,
    val password: Password
) {
    fun isValid(): Boolean = userName.isValid() && email.isValid() && password.isValid()

    companion object {
        val INITIAL = SignUp(
            userName = UserName(""),
            email = Email(
                EmailId(""),
                EmailDomain("wooteco.com")
            ),
            password = Password(
                "",
                ""
            )
        )
    }
}
