package nextstep.signup.model.inputvalidity

enum class PasswordConfirmInputValidity : InputValidity {
    DOES_NOT_MATCH,
    NO_ERROR,
    ;

    companion object {
        var password: String = ""
        var passwordConfirm: String = ""

        fun of(input: String): PasswordConfirmInputValidity {
            return when {
                doesNotMatch(input) -> DOES_NOT_MATCH
                else -> NO_ERROR
            }
        }

        private fun doesNotMatch(input: String): Boolean {
            return password != passwordConfirm
        }
    }
}
