package nextstep.signup.domain

data class Email(
    val address: String = ""
) : ErrorHandler {
    private val id: EmailId = EmailId(address.substringBefore("@"))
    private val domain: EmailDomain = EmailDomain(address.substringAfter("@"))

    override val error: Error
        get() = when {
            address.isBlank() -> Error.NO_ERROR
            !isValid() -> Error.INVALID_EMAIL
            else -> Error.NO_ERROR
        }

    fun isValid(): Boolean = id.isValid() && domain.isValid() && address.contains("@")
}

private data class EmailId(
    val id: String
) {
    fun isValid(): Boolean = id.matches(EMAIL_ID_REGEX.toRegex())

    companion object {
        private const val EMAIL_ID_REGEX = "^[a-zA-Z0-9._%+-]+\$"
    }
}

private data class EmailDomain(
    val domain: String
) {
    fun isValid(): Boolean = domain.matches(EMAIL_DOMAIN_REGEX.toRegex())

    companion object {
        private const val EMAIL_DOMAIN_REGEX = "^[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
    }
}
