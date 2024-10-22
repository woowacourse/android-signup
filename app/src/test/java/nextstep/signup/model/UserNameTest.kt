package nextstep.signup.model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class UserNameTest {
    @Test
    fun `사용자 이름이 2자 이상이고 5자 이하이면 userNameValidResult는 Success가 반환된다`() {
        val userNameValidResult: UserNameValidResult = UserName("해나").validate()
        assertEquals(UserNameValidResult.Success, userNameValidResult)
    }

    @Test
    fun `사용자 이름이 2자 미만이면 userNameValidResult는 InvalidLength가 반환된다`() {
        val userNameValidResult: UserNameValidResult = UserName("h").validate()
        assertEquals(UserNameValidResult.InvalidLength, userNameValidResult)
    }

    @Test
    fun `사용자 이름이 5자 초과이면 userNameValidResult는 InvalidLength가 반환된다`() {
        val userNameValidResult: UserNameValidResult = UserName("hannah").validate()
        assertEquals(UserNameValidResult.InvalidLength, userNameValidResult)
    }

    @Test
    fun `사용자 이름에 숫자나 기호가 포함되어 있지 않다면 userNameValidResult는 Success가 반환된다`() {
        val userNameValidResult: UserNameValidResult = UserName("해나").validate()
        assertEquals(UserNameValidResult.Success, userNameValidResult)
    }

    @Test
    fun `사용자 이름에 숫자가 포함되어 있다면 userNameValidResult는 InvalidCharacter가 반환된다`() {
        val userNameValidResult: UserNameValidResult = UserName("해나731").validate()
        assertEquals(UserNameValidResult.InvalidCharacter, userNameValidResult)
    }

    @Test
    fun `사용자 이름에 기호가 포함되어 있다면 userNameValidResult는 InvalidCharacter가 반환된다`() {
        val userNameValidResult: UserNameValidResult = UserName("해나&#").validate()
        assertEquals(UserNameValidResult.InvalidCharacter, userNameValidResult)
    }

    @Test
    fun `사용자 이름에 숫자와 기호가 포함되어 있다면 userNameValidResult는 InvalidCharacter가 반환된다`() {
        val userNameValidResult: UserNameValidResult = UserName("해나1&").validate()
        assertEquals(UserNameValidResult.InvalidCharacter, userNameValidResult)
    }

    @Test
    fun `사용자 이름이 2~5자이고 숫자나 기호가 포함되어 있지 않다면 isValid의 값은 true이다`() {
        val isValid: Boolean = UserName("해나").isValid()
        assertTrue(isValid)
    }

    @Test
    fun `사용자 이름이 2자 미만이면 isValid의 값은 false이다`() {
        val isValid: Boolean = UserName("h").isValid()
        assertFalse(isValid)
    }

    @Test
    fun `사용자 이름이 5자 초과이면 isValid의 값은 false이다`() {
        val isValid: Boolean = UserName("hannah").isValid()
        assertFalse(isValid)
    }

    @Test
    fun `사용자 이름에 숫자가 포함되어 있다면 isValid의 값은 false이다`() {
        val isValid: Boolean = UserName("해나731").isValid()
        assertFalse(isValid)
    }

    @Test
    fun `사용자 이름에 기호가 포함되어 있다면 isValid의 값은 false이다`() {
        val isValid: Boolean = UserName("해나&#").isValid()
        assertFalse(isValid)
    }

    @Test
    fun `사용자 이름이 2~5자 이상이고 숫자나 기호가 포함되어 있다면 isValid의 값은 false이다`() {
        val isValid: Boolean = UserName("해나123&#").isValid()
        assertFalse(isValid)
    }

    @Test
    fun `사용자 이름이 비어있다면 isError의 값은 false이다`() {
        val isError: Boolean = UserName("").isError()
        assertFalse(isError)
    }
}
