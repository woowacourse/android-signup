package nextstep.signup.model

sealed class InputError {
    sealed class NameError : InputError() {
        data object InvalidLength : NameError()
        data object InvalidFormat : NameError()
    }

    sealed class EmailError : InputError() {
        data object InvalidFormat : EmailError()
    }

    sealed class PasswordError : InputError() {
        data object InvalidLength : PasswordError()
        data object InvalidFormat : PasswordError()
    }

    sealed class PasswordConfirmError : InputError() {
        data object PasswordMismatch : PasswordConfirmError()
    }

    data object None : InputError()
}
