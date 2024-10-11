package nextstep.signup.domain

@JvmInline
value class UserName(
    val name: String
) {
    fun isValid(): Boolean = name.isNotBlank()
}
