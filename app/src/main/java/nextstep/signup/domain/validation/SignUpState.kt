package nextstep.signup.domain.validation

data class SignUpState(
    val username: Username,
    val email: Email,
    val password: Password,
    val passwordConfirm: PasswordConfirm,
) {
    fun isValid(): Boolean {
        return username.validationResult() == ValidationResult.SUCCESS &&
                email.validationResult() == ValidationResult.SUCCESS &&
                password.validationResult() == ValidationResult.SUCCESS &&
                passwordConfirm.validationResult() == ValidationResult.SUCCESS
    }
}
