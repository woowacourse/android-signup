package nextstep.signup.ui.model

data class SignUpState(
    val userName: UserName,
    val email: Email,
    val password: Password,
    val passwordConfirm: PasswordConfirm,
) {
    fun isEnable(): Boolean =
        listOf(userName, email, password, passwordConfirm).all { information ->
            information.text.isNotEmpty() && information.isValid()
        }
}
