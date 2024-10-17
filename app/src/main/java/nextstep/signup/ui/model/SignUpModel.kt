package nextstep.signup.ui.model

interface SignUpModel {
    val text : String
    fun validState(): SignUpState
    fun isBlank(): Boolean
}
