package nextstep.signup.domain

@JvmInline
value class PasswordConfirm(val content: String) {

    companion object {
        fun from(passwordInput: String, passwordConfirmInput: String): PasswordConfirmResult {
            if (passwordConfirmInput == "") return PasswordConfirmResult.EmptyField
            if (passwordInput != passwordConfirmInput) return PasswordConfirmResult.NotSamePasswordConfirm
            return PasswordConfirmResult.Success(PasswordConfirm(passwordConfirmInput))
        }
    }
}

sealed interface PasswordConfirmResult {
    data class Success(val passwordConfirm: PasswordConfirm) : PasswordConfirmResult

    data object EmptyField : PasswordConfirmResult

    sealed interface Failure : PasswordConfirmResult

    data object NotSamePasswordConfirm : Failure
}
