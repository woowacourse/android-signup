package nextstep.signup.ui.domain

data class Email(
    override val text: String = DEFAULT_EMAIL_ADDRESS
) : SignUpModel {
    override fun validState(): SignUpState {
        return if (text.matches(EMAIL_REGEX.toRegex())) {
            SignUpState.Valid
        } else {
            SignUpState.InValid.Email
        }
    }

    companion object {
        private const val DEFAULT_EMAIL_ADDRESS = ""
        private const val EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
    }
}
