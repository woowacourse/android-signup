package nextstep.signup.domain

data class Password(
    val value: String = ""
) {
    fun isValid(): Boolean = value.matches(PASSWORD_REGEX.toRegex())

    companion object {
        private const val PASSWORD_REGEX =  "^(?=.*[a-zA-Z])(?=.*[0-9]).{8,16}$"
    }
}
