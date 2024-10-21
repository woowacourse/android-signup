package woowacourse.signup.domain

class InvalidUserNameLengthException : IllegalArgumentException("이름은 2~5자여야 합니다.")

class InvalidUserNameCompositionException : IllegalArgumentException("이름에는 숫자나 기호가 포함될 수 없습니다.")

class UserName(private val value: String) {
    init {
        if (value.length !in LENGTH_RANGE) throw InvalidUserNameLengthException()
        if (!value.matches(Regex(INVALIDATION_REGEX))) throw InvalidUserNameCompositionException()
    }

    companion object {
        private const val MIN_LENGTH = 2
        private const val MAX_LENGTH = 5
        private val LENGTH_RANGE = MIN_LENGTH..MAX_LENGTH
        private const val INVALIDATION_REGEX = "^[a-zA-Z가-힣]+$"
    }
}
