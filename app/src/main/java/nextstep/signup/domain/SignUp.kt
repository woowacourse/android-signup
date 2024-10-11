package nextstep.signup.domain

data class SignUp(
    val userName: UserName,
    val email: Email,
    val password: Password,
) {
    fun isValid(): Boolean = userName.isValid() && email.isValid() && password.isValid()
}
