package nextstep.signup.presentation.signup

data class SignUpInput(
    val username: String,
    val email: String,
    val password: String,
    val passwordConfirm: String
)
