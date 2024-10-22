package nextstep.signup.model

sealed interface PasswordConfirmValidResult {
    data object Blank : PasswordConfirmValidResult

    data object Invalid : PasswordConfirmValidResult

    data object Success : PasswordConfirmValidResult
}
