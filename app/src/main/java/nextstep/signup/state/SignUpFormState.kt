package nextstep.signup.state

data class SignUpFormState(
    val userName: String,
    val email: String,
    val password: String,
    val confirmPassword: String,
)