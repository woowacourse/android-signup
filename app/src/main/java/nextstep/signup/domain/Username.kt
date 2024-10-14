package nextstep.signup.domain

data class Username(
    val name: String = ""
) {
    fun isValid(): Boolean = name.matches(USERNAME_REGEX.toRegex())

    companion object {
        private const val USERNAME_REGEX = "^[a-zA-Z가-힣]{2,5}$"
    }
}
