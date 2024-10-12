package nextstep.signup.domain

data class Email(
    val email: String
) {
    private val id: EmailId = EmailId(email.substringBefore("@"))
    private val domain: EmailDomain = EmailDomain(email.substringAfter("@"))

    fun isValid(): Boolean = id.isValid() && domain.isValid() && email.contains("@")
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
