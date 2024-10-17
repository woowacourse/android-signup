package nextstep.signup.ui.domain

interface SignUpModel {
    val text : String
    fun validState(): SignUpState
}
