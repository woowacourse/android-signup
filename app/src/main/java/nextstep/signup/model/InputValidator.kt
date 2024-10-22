package nextstep.signup.model

sealed interface InputValidator {
    fun validate(): ValidationState
}
