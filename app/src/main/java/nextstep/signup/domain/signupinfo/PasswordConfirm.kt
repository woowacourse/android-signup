package nextstep.signup.domain.signupinfo

class PasswordConfirm private constructor(
    val value: String,
) {

    sealed interface PasswordConfirmFail : SignUpInfoResult.Fail {
        data object Different : PasswordConfirmFail
    }

    companion object {

        fun from(value: String, password: String): SignUpInfoResult = when {
            value.isEmpty() -> SignUpInfoResult.Empty
            value != password -> PasswordConfirmFail.Different
            else -> SignUpInfoResult.Success(PasswordConfirm(value))
        }

    }
}