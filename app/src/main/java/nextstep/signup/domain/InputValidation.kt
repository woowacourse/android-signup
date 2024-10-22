package nextstep.signup.domain

data class InputValidation(
    val errorCode: ErrorCode? = null,
    val isError: Boolean,
)
