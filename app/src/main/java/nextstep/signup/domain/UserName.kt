package nextstep.signup.domain

@JvmInline
value class UserName(
    val name: String
) {
    init {
        require(name.length in NAME_RANGE) { "name has to be in $NAME_RANGE" }
        require(name.matches(regex)) { "name must not include number or symbol" }
    }

    fun isValid(): Boolean = name.isNotBlank()

    companion object {
        private const val MIN_NAME_LENGTH = 2
        private const val MAX_NAME_LENGTH = 5
        private val NAME_RANGE = MIN_NAME_LENGTH..MAX_NAME_LENGTH

        private const val USERNAME_REGEX = "^[a-zA-Z가-힣]+$"
        private val regex = Regex(USERNAME_REGEX)
    }
}
