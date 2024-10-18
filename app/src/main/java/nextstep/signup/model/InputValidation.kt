package nextstep.signup.model

interface InputValidation {
    fun isInValid(): Boolean

    fun getErrorMessage(): String?
}
