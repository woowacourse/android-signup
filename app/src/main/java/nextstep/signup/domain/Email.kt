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
    fun isValid(): Boolean = id.isNotBlank()
}

data class EmailDomain(
    val domain: String
) {
    fun isValid(): Boolean = domain.contains(".") && domain.isNotBlank()
}
