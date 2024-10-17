package nextstep.signup.model.inputresult

enum class PasswordConfirmInputResult : InputResult {
    DOES_NOT_MATCH,
    NO_ERROR;

    companion object {
        fun of(input: String): PasswordConfirmInputResult {
            return when {
                isNotMatch(input) -> DOES_NOT_MATCH
                else -> NO_ERROR
            }
        }

        private fun isNotMatch(input: String): Boolean {
            TODO()
        }
    }
}