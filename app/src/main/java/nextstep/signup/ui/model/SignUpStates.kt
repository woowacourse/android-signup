package nextstep.signup.ui.model

class SignUpStates(
    val states: List<SignUpState>
) {
    fun valid(): Boolean{
        return states.all { signUpState ->
            signUpState == SignUpState.Valid
        }
    }
}
