package nextstep.signup.ui.domain

data class ConfirmPassword(
    val password: Password,
    override val text: String,
) : SignUpModel {
    override fun validState(): SignUpState {
        return if (password.text == text) SignUpState.Valid
        else SignUpState.InValid.Confirm
    }
}
