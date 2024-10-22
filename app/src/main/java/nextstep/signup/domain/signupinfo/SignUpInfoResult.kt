package nextstep.signup.domain.signupinfo

sealed interface SignUpInfoResult {

    data object Empty : SignUpInfoResult

    data class Success(val result: Any?) : SignUpInfoResult

    sealed interface Fail : SignUpInfoResult

}