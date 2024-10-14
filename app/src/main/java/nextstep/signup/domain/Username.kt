package nextstep.signup.domain

data class Username(
    val name: String = ""
) {
    fun isValid(): Boolean = name.isNotBlank()
}
