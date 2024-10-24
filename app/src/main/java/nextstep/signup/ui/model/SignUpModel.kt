package nextstep.signup.ui.model

interface SignUpModel {
    val text: String
    fun isValidState(): SignUpState
    fun isBlank(): Boolean
}
