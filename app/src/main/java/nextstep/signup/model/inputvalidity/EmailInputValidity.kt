package nextstep.signup.model.inputvalidity

enum class EmailInputValidity : InputValidity {
    INVALID_FORMAT,
    VALID,
    ;

    companion object {
        private const val EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"

        fun of(input: String): EmailInputValidity {
            return when {
                isInputFormatInvalid(input) -> INVALID_FORMAT
                else -> VALID
            }
        }

        private fun isInputFormatInvalid(input: String): Boolean {
            return !input.matches(EMAIL_REGEX.toRegex())
        }
    }
}
