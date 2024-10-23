package nextstep.signup.model

data class PasswordConfirm(
    val content: String,
    val password: String,
) : InputValidator {
    override fun validate(): ValidationState =
        when {
            content.isEmpty() -> ValidationState.Blank
            !isSameWithPassword() -> ValidationState.Invalid.ConfirmMismatch
            else -> ValidationState.Valid
        }

    private fun isSameWithPassword(): Boolean = content == password
}
