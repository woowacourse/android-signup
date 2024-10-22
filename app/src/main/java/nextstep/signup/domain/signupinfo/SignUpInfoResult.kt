package nextstep.signup.domain.signupinfo

sealed interface SignUpInfoResult {

    data object Empty : SignUpInfoResult

    interface Success : SignUpInfoResult

    sealed interface Fail : SignUpInfoResult

}