package nextstep.signup.model

sealed interface EmailValidResult {
    data object Blank : EmailValidResult

    data object InvalidForm : EmailValidResult

    data object Success : EmailValidResult
}
