package nextstep.signup.ui.domain

data class Username(
    override val text: String = DEFAULT_NAME
): SignUpModel {
    override fun validState(): SignUpState {
        return when {
            !isValidLength() -> SignUpState.InValid.UserNameLength
            !isValidText() -> SignUpState.InValid.UserNameType
            else -> SignUpState.Valid
        }
    }

    private fun isValidLength(): Boolean =
        text.matches(USERNAME_REGEX_LENGTH.toRegex())

    private fun isValidText() : Boolean =
        text.matches(USERNAME_REGEX_TEXT.toRegex())

    companion object {
        private const val DEFAULT_NAME = ""
        private const val USERNAME_REGEX_LENGTH = "^.{2,5}\$"
        private const val USERNAME_REGEX_TEXT = "^[a-zA-Z가-힣]*\$"
    }
}
