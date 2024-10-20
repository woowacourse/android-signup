package nextstep.signup.model

import org.junit.Assert.assertEquals
import org.junit.Test

class UserNameTest {
    @Test
    fun `사용자 이름이 2자 이상이고 5자 이하이면 에러 메시지는 null이 반환된다`() {
        val errorMessage: String? = UserName("해나").getErrorMessage()
        assertEquals(null, errorMessage)
    }

    @Test
    fun `사용자 이름이 2자 미만이면 에러메시지가 반환된다`() {
        val errorMessage: String? = UserName("h").getErrorMessage()
        assertEquals(USERNAME_LENGTH_ERROR, errorMessage)
    }

    @Test
    fun `사용자 이름이 5자 초과이면 에러메시지가 반환된다`() {
        val errorMessage: String? = UserName("hannah").getErrorMessage()
        assertEquals(USERNAME_LENGTH_ERROR, errorMessage)
    }

    @Test
    fun `사용자 이름에 숫자나 기호가 포함되어 있지 않다면 에러 메시지는 null이 반환된다`() {
        val errorMessage: String? = UserName("해나").getErrorMessage()
        assertEquals(null, errorMessage)
    }

    @Test
    fun `사용자 이름에 숫자가 포함되어 있다면 에러메시지가 반환된다`() {
        val errorMessage: String? = UserName("해나731").getErrorMessage()
        assertEquals(USERNAME_FORM_ERROR, errorMessage)
    }

    @Test
    fun `사용자 이름에 기호가 포함되어 있다면 에러메시지가 반환된다`() {
        val errorMessage: String? = UserName("해나&#").getErrorMessage()
        assertEquals(USERNAME_FORM_ERROR, errorMessage)
    }

    @Test
    fun `사용자 이름에 숫자와 기호가 포함되어 있다면 에러메시지가 반환된다`() {
        val errorMessage: String? = UserName("해나1&").getErrorMessage()
        assertEquals(USERNAME_FORM_ERROR, errorMessage)
    }

    @Test
    fun `사용자 이름이 2~5자이고 숫자나 기호가 포함되어 있지 않다면 isValid의 값은 true이다`() {
        val isValid: Boolean = UserName("해나").isValid()
        assertEquals(true, isValid)
    }

    @Test
    fun `사용자 이름이 2자 미만이면 isValid의 값은 false이다`() {
        val isValid: Boolean = UserName("h").isValid()
        assertEquals(false, isValid)
    }

    @Test
    fun `사용자 이름이 5자 초과이면 isValid의 값은 false이다`() {
        val isValid: Boolean = UserName("hannah").isValid()
        assertEquals(false, isValid)
    }

    @Test
    fun `사용자 이름에 숫자가 포함되어 있다면 isValid의 값은 false이다`() {
        val isValid: Boolean = UserName("해나731").isValid()
        assertEquals(false, isValid)
    }

    @Test
    fun `사용자 이름에 기호가 포함되어 있다면 isValid의 값은 false이다`() {
        val isValid: Boolean = UserName("해나&#").isValid()
        assertEquals(false, isValid)
    }

    @Test
    fun `사용자 이름이 2~5자 이상이고 숫자나 기호가 포함되어 있다면 isValid의 값은 false이다`() {
        val isValid: Boolean = UserName("해나123&#").isValid()
        assertEquals(false, isValid)
    }

    @Test
    fun `사용자 이름이 비어있다면 isError의 값은 false이다`() {
        val isError: Boolean = UserName("").isError()
        assertEquals(false, isError)
    }

    companion object {
        private const val USERNAME_LENGTH_ERROR = "이름은 2~5자여야 합니다."
        private const val USERNAME_FORM_ERROR = "이름에는 숫자나 기호가 포함될 수 없습니다."
    }
}
