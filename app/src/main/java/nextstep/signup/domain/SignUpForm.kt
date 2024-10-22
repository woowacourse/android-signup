package nextstep.signup.domain

import nextstep.signup.domain.signupinfo.SignUpInfoResult

data class SignUpForm(
    val userName: SignUpInfoResult,
    val email: SignUpInfoResult,
    val password: SignUpInfoResult,
    val passwordConfirm: SignUpInfoResult,
) {


    fun canSubmit(): Boolean =
        userName is SignUpInfoResult.Success && email is SignUpInfoResult.Success
                && password is SignUpInfoResult.Success && passwordConfirm is SignUpInfoResult.Success

}
