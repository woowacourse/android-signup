package nextstep.signup.model.inputvalidity

enum class PasswordInputValidity : InputValidity {
    INVALID_FORMAT,
    INVALID_LENGTH,
    VALID,
    ;

    companion object {
        private const val PASSWORD_REGEX = "^(?=.*[a-zA-Z])(?=.*[0-9]).*$"
        private const val MIN_PASSWORD_LENGTH = 8
        private const val MAX_PASSWORD_LENGTH = 16

        fun of(input: String): PasswordInputValidity {
            return when {
                isInputFormatInvalid(input) -> INVALID_FORMAT
                isInputLengthInvalid(input) -> INVALID_LENGTH
                else -> VALID
            }
        }

        private fun isInputFormatInvalid(input: String): Boolean {
            return !input.matches(PASSWORD_REGEX.toRegex())
        }

        private fun isInputLengthInvalid(input: String): Boolean {
            return input.length !in MIN_PASSWORD_LENGTH..MAX_PASSWORD_LENGTH
        }
    }
}
