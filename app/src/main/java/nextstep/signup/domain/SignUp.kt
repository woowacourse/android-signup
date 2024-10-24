package nextstep.signup.domain

data class SignUp(
    val userName: UserName,
    val email: Email,
    val password: Password,
    val passwordConfirm: PasswordConfirm
) {

    companion object {
        fun from(
            userName: UserNameResult,
            email: EmailResult,
            password: PasswordResult,
            passwordConfirm: PasswordConfirmResult
        ): SignUpResult {
            if (userName is UserNameResult.Success &&
                email is EmailResult.Success &&
                password is PasswordResult.Success &&
                passwordConfirm is PasswordConfirmResult.Success
            ) {
                return SignUpResult.Success(
                    SignUp(
                        userName = userName.userName,
                        email = email.email,
                        password = password.password,
                        passwordConfirm = passwordConfirm.passwordConfirm
                    )
                )
            }
            return SignUpResult.Failure
        }
    }
}

sealed interface SignUpResult {
    data class Success(val signUp: SignUp) : SignUpResult

    data object Initial : SignUpResult

    data object Failure : SignUpResult
}
