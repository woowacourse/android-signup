package nextstep.signup.domain

data class Email(
    val address: String = ""
) {
    private val id: EmailId = EmailId(address.substringBefore("@"))
    private val domain: EmailDomain = EmailDomain(address.substringAfter("@"))

    fun isValid(): Boolean = id.isValid() && domain.isValid() && address.contains("@")
}

data class EmailId(
    val id: String
) {
    fun isValid(): Boolean = id.matches(EMAIL_ID_REGEX.toRegex())

    companion object {
        private const val EMAIL_ID_REGEX = "^[a-zA-Z0-9._%+-]$"
    }
}

data class EmailDomain(
    val domain: String
) {
    fun isValid(): Boolean = domain.matches(EMAIL_DOMAIN_REGEX.toRegex())

    companion object {
        private const val EMAIL_DOMAIN_REGEX = "^[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
    }
}
