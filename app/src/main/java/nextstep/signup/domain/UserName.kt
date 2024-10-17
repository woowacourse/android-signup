package nextstep.signup.domain

@JvmInline
value class UserName(val value: String) {
    init {
        require(value.isNotBlank()) { "이름은 공백일 수 없습니다." }
        require(value.isInLength()) { "이름은 2자 이상 5자 이하로 입력해주세요." }
        require(value.hasNumber().not()) { "이름에 숫자를 포함할 수 없습니다." }
        require(value.hasSpecialCharacter().not()) { "이름에 특수문자를 포함할 수 없습니다." }
    }

    companion object {
        private const val NAME_REGEX = "^.{2,5}$"
        private val NUMBER_REGEX = "\\d".toRegex()
        private val SPECIAL_CHAR_EXIST = "[!@#\$%^&*()\\-_+=]".toRegex()

        private fun String.hasNumber(): Boolean {
            return contains(NUMBER_REGEX)
        }

        private fun String.hasSpecialCharacter(): Boolean {
            return contains(SPECIAL_CHAR_EXIST)
        }

        private fun String.isInLength(): Boolean {
            return matches(NAME_REGEX.toRegex())
        }

        fun from(name: String): UserNameResult {
            return when {
                name.isBlank() -> UserNameResult.InvalidBlank
                name.isInLength().not() -> UserNameResult.InvalidOutOfLength
                name.hasNumber() -> UserNameResult.InvalidContainNumber
                name.hasSpecialCharacter() -> UserNameResult.InvalidContainSpecialCharacter
                else -> UserNameResult.Success(UserName(name))
            }
        }
    }
}

sealed interface UserNameResult {
    data class Success(val userName: UserName) : UserNameResult
    data object InvalidBlank : UserNameResult
    data object InvalidContainNumber : UserNameResult
    data object InvalidContainSpecialCharacter : UserNameResult
    data object InvalidOutOfLength : UserNameResult
}
