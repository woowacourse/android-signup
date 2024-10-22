package nextstep.signup.model

sealed interface ValidationState {
    data object Valid : ValidationState

    data object Blank : ValidationState

    sealed interface Invalid : ValidationState {
        sealed interface UserName : Invalid {
            data object Length : UserName

            data object Format : UserName
        }

        sealed interface Password : Invalid {
            data object Length : Password

            data object Format : Password
        }

        sealed interface Email : Invalid {
            data object InvalidFormat : Email
        }

        data object ConfirmMismatch : Invalid
    }
}
