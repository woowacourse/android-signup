package nextstep.signup.model

interface InputValidation {
    fun isInvalid(): Boolean

    fun getErrorMessage(): String?
}
