package nextstep.signup.model

data class UserInformation(
    val userName: UserName,
    val email: Email,
    val password: Password,
    val passwordConfirm: PasswordConfirm,
) {
    fun isAbleToSubmit(): Boolean =
        userName.isValid() && email.isValid() && password.isValid() && passwordConfirm.isMatch(password.password)
}
