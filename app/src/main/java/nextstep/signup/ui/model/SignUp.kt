package nextstep.signup.ui.model

class SignUp(
    private vararg val information: SignUpInformation,
) {
    fun isEligible(): Boolean =
        information.all { information ->
            information.text.isNotEmpty() && information.isValid()
        }
}
