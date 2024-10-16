package woowacourse.signup.domain

class InvalidPasswordLengthException : IllegalArgumentException("비밀번호는 8~16자여야 합니다.")

class InvalidPasswordCompositionException : IllegalArgumentException("비밀번호는 영문과 숫자를 포함해야 합니다.")

class Password(private val value: String) {
    init {
        if (value.length !in LENGTH_RANGE) throw InvalidPasswordLengthException()
        if (!value.matches(Regex(INVALIDATION_REGEX))) throw InvalidPasswordCompositionException()
    }

    companion object {
        private const val MIN_LENGTH = 8
        private const val MAX_LENGTH = 16
        private val LENGTH_RANGE = MIN_LENGTH..MAX_LENGTH
        private const val INVALIDATION_REGEX = "^(?=.*[a-zA-Z])(?=.*[0-9]).*$"
    }
}
