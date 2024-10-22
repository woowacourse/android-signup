package nextstep.signup.domain.signupinfo

class UserName private constructor(
    val value: String
) : SignUpInfoResult.Success {

    sealed interface UserNameFail : SignUpInfoResult.Fail {
        data object Regex : UserNameFail

        data object Length : UserNameFail
    }

    companion object {

        fun from(value: String, regex: Regex): SignUpInfoResult = when {
            value.isEmpty() -> SignUpInfoResult.Empty
            !value.matches(regex) -> UserNameFail.Regex
            value.length !in USER_NAME_RANGE -> UserNameFail.Length
            else -> UserName(value)
        }


        private val USER_NAME_RANGE = 2..5

    }
}

