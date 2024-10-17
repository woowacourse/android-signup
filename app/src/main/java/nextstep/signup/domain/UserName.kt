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
        val regex = Regex(USERNAME_REGEX)

        fun from(input: String): UserNameResult {
            if (input == "") return EmptyField
            if (input.length !in NAME_RANGE) return InvalidNameLength
            if (!input.matches(regex)) return InvalidNameFormat
            return Success(UserName(input))
        }
    }
}

sealed interface UserNameResult

data class Success(val userName: UserName) : UserNameResult

data object EmptyField : UserNameResult

sealed interface Failure : UserNameResult

data object InvalidNameLength : Failure

data object InvalidNameFormat : Failure
