package nextstep.signup.model

sealed interface PasswordValidResult {
    data object Blank : PasswordValidResult

    data object InvalidLength : PasswordValidResult

    data object InvalidCharacter : PasswordValidResult

    data object Success : PasswordValidResult
}
