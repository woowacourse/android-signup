package nextstep.signup.domain.signupinfo

class PasswordConfirm private constructor(
    val value: String,
):SignUpInfoResult.Success {

    sealed interface PasswordConfirmFail : SignUpInfoResult.Fail {
        data object Different : PasswordConfirmFail
    }

    companion object {

        fun from(value: String, password: String): SignUpInfoResult = when {
            value.isEmpty() -> SignUpInfoResult.Empty
            value != password -> PasswordConfirmFail.Different
            else -> PasswordConfirm(value)
        }

    }
}