package woowacourse.signup.domain

class InvalidEmailException : IllegalArgumentException("이메일 형식이 올바르지 않습니다.")

class Email(private val value: String) {
    init {
        if (!value.matches(Regex(INVALIDATION_REGEX))) throw InvalidEmailException()
    }

    companion object {
        private const val INVALIDATION_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
    }
}
