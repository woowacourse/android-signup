package nextstep.signup.ui.model

data class ConfirmPassword(
    val password: Password,
    override val text: String = DEFAULT_TEXT,
) : SignUpModel {
    override fun validState(): SignUpState {
        return when {
            isBlank() -> SignUpState.Blank
            !isSamePassword() -> SignUpState.InValid.Confirm
            else -> SignUpState.Valid
        }
    }

    override fun isBlank(): Boolean {
        return text.isBlank()
    }

    private fun isSamePassword(): Boolean{
        return password.text == text
    }

    companion object {
        private const val DEFAULT_TEXT = ""
    }
}
