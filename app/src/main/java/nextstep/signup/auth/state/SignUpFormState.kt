package nextstep.signup.auth.state

data class SignUpFormState(
    val userName: String,
    val email: String,
    val password: String,
    val confirmPassword: String,
) {
    // TODO: 회원가입 버튼 활성화 조건
    val enableSignUp: Boolean = userName.isNotEmpty() &&
            email.isNotEmpty() &&
            password.isNotEmpty() &&
            confirmPassword.isNotEmpty()
}