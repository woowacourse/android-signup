package nextstep.signup.domain

data class Email2(
    val content: String
) {
    init {
        require(regex.matches(content)) { "the email format is not correct" }
    }

    companion object {
        private const val EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
        private val regex = Regex(EMAIL_REGEX)
    }
}

data class Email(
    val id: EmailId,
    val domain: EmailDomain
) {
    fun isValid(): Boolean = id.isValid() && domain.isValid()

    fun whole(): String = id.id
}

@JvmInline
value class EmailId(
    val id: String
) {
    fun isValid(): Boolean = id.isNotBlank()
}

@JvmInline
value class EmailDomain(
    val domain: String
) {
    fun isValid(): Boolean = domain.isNotBlank()

    companion object {
        val DEFAULT = EmailDomain("wooteco.com")
    }
}
