package nextstep.signup.domain

data class Email(
    val id: EmailId,
    val domain: EmailDomain,
) {
    fun isValid(): Boolean = id.isValid() && domain.isValid()
}

@JvmInline
value class EmailId(
    val id: String,
) {
    fun isValid(): Boolean = id.isNotBlank()
}

@JvmInline
value class EmailDomain(
    val domain: String,
) {
    fun isValid(): Boolean = domain.isNotBlank()
}

