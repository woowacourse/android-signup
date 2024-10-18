package nextstep.signup.model.inputvalidity

enum class PasswordConfirmInputValidity : InputValidity {
    DOES_NOT_MATCH,
    NO_ERROR,
    ;

    companion object {
        var password: String = ""
        var passwordConfirm: String = ""

        fun of(): PasswordConfirmInputValidity {
            return when {
                doesNotMatch() -> DOES_NOT_MATCH
                else -> NO_ERROR
            }
        }

        private fun doesNotMatch(): Boolean {
            return password != passwordConfirm
        }
    }
}
