package nextstep.signup.model.inputvalidity

enum class UsernameInputValidity : InputValidity {
    INVALID_FORMAT,
    INVALID_LENGTH,
    NO_ERROR,
    ;

    companion object {
        private const val USERNAME_REGEX = "^[a-zA-Z가-힣]+$"
        private const val MIN_USERNAME_LENGTH = 2
        private const val MAX_USERNAME_LENGTH = 5

        fun of(input: String): UsernameInputValidity {
            return when {
                isInputFormatInvalid(input) -> INVALID_FORMAT
                isInputLengthInvalid(input) -> INVALID_LENGTH
                else -> NO_ERROR
            }
        }

        private fun isInputFormatInvalid(input: String): Boolean {
            return !input.matches(USERNAME_REGEX.toRegex())
        }

        private fun isInputLengthInvalid(input: String): Boolean {
            return input.length !in MIN_USERNAME_LENGTH..MAX_USERNAME_LENGTH
        }
    }
}
