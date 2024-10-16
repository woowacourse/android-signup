package nextstep.signup.ui.model

data class SignUpInformation(
    val userName: UserName,
    val email: Email,
    val password: Password,
    val passwordConfirm: PasswordConfirm,
) {
    fun isEligibleForSignUp(): Boolean =
        listOf(userName, email, password, passwordConfirm).all { information ->
            information.text.isNotEmpty() && information.isValid()
        }
}
