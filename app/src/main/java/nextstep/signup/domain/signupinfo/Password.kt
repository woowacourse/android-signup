package nextstep.signup.domain.signupinfo

class Password private constructor(
    val value: String,
) {

    init {
        require(value.matches(PASSWORD_REGEX)) {
            "비밀번호는 영문과 숫자를 포함해야 합니다."
        }

        require(value.length in PASSWORD_RANGE){
            "비밀번호는 8~16자여야 합니다."
        }
    }


    sealed interface PasswordFail : SignUpInfoResult.Fail {
        data object Regex : PasswordFail
        data object Length : PasswordFail
    }

    companion object {

        fun from(value: String): SignUpInfoResult = when {
            value.isEmpty() -> SignUpInfoResult.Empty
            !value.matches(PASSWORD_REGEX) -> PasswordFail.Regex
            value.length !in PASSWORD_RANGE -> PasswordFail.Length
            else -> SignUpInfoResult.Success(Password(value))
        }

        private val PASSWORD_RANGE = 8..16

        private val PASSWORD_REGEX = Regex("^(?=.*[a-zA-Z])(?=.*[0-9]).+$")

    }
}