package nextstep.signup.model

data class UserInformation(
    val userName: UserName,
    val email: Email,
    val password: Password,
    val passwordConfirm: PasswordConfirm,
)
