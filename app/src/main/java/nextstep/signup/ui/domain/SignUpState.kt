package nextstep.signup.ui.domain

sealed interface SignUpState {
    data object Valid : SignUpState
    sealed interface InValid: SignUpState {
        data object UserNameLength : InValid
        data object UserNameType: InValid
        data object Email : InValid
        data object PasswordType: InValid
        data object PasswordLength: InValid
        data object Confirm : InValid
    }
}

