package nextstep.signup.domain

data class Password(
    val value: String = ""
) {
    fun isValid(): Boolean {
        "^(?=.*[a-zA-Z])(?=.*[0-9]).{8,16}$".toRegex().let {
            return it.matches(value)
        }
    }
}
