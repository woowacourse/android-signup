package nextstep.signup.model

data class User(
    val name: Name,
    val email: Email,
    val password: Password,
    val passwordConfirm: PasswordConfirm
) {
    fun isInvalid(): Boolean {
        return name.isInvalid() || email.isInvalid() || password.isInvalid() || passwordConfirm.isInvalid()
    }
}
