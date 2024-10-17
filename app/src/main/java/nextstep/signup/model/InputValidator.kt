package nextstep.signup.model

sealed interface InputValidator {
    fun isValid(): Boolean

    fun getErrorMessage(): String?
}
