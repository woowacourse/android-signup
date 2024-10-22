package nextstep.signup.model

sealed interface UserNameValidResult {
    data object Blank : UserNameValidResult

    data object InvalidLength : UserNameValidResult

    data object InvalidCharacter : UserNameValidResult

    data object Success : UserNameValidResult
}
