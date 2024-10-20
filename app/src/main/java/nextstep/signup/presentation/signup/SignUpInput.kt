package nextstep.signup.presentation.signup

data class SignUpInput(
    val username: String,
    val email: String,
    val password: String,
    val passwordConfirm: String
) {
    companion object {
        val intial = SignUpInput(username = "", email = "", password = "", passwordConfirm = "")
    }
}
