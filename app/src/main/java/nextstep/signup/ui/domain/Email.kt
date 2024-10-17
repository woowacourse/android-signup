package nextstep.signup.ui.domain

data class Email(
    val address: String = DEFAULT_EMAIL_ADDRESS
) {

    fun isValid(): Boolean =
        address.matches(EMAIL_REGEX.toRegex())

    companion object {
        private const val DEFAULT_EMAIL_ADDRESS = ""
        private const val EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
    }
}
