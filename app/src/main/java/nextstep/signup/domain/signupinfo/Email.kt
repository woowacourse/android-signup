package nextstep.signup.domain.signupinfo

class Email private constructor(
    val value: String
):SignUpInfoResult.Success {

    init {
        require(value.matches(EMAIL_REGEX)) {
            "이메일 형식이 올바르지 않습니다"
        }
    }


    sealed interface EmailFail : SignUpInfoResult.Fail {
        data object Regex : EmailFail
    }

    companion object {

        fun from(value: String): SignUpInfoResult = when {
            value.isEmpty() -> SignUpInfoResult.Empty
            !value.matches(EMAIL_REGEX) -> EmailFail.Regex
            else -> Email(value)
        }

        private val EMAIL_REGEX = Regex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")
    }
}