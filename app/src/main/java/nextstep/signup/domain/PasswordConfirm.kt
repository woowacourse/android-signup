package nextstep.signup.domain

data class PasswordConfirm(val value: String = EMPTY_PASSWORDCONFIRM) {
    fun isMatchWithPassword(password: String): Boolean = value == password

    companion object {
        private const val EMPTY_PASSWORDCONFIRM = ""
    }
}
