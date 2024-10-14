package nextstep.signup.domain

data class Password(
    val password: String,
    val passwordConfirm: String
) {
    fun isValid(): Boolean = password.isNotBlank() && password == passwordConfirm
}
