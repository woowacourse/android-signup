package nextstep.signup.ui.model

sealed interface Information {
    fun isValid(): Boolean

    fun errorMessage(): String
}
