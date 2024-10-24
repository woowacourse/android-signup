package nextstep.signup.model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class UserNameTest {
    @Test
    fun `사용자 이름이 2자 이상이고 5자 이하이면 유효성 검증에 성공한다`() {
        val userNameValidResult: UserNameValidResult = UserName("해나").validate()
        assertEquals(UserNameValidResult.Success, userNameValidResult)
    }

    @Test
    fun `사용자 이름이 2자 미만이면 길이 유효성 검증에 실패한다`() {
        val userNameValidResult: UserNameValidResult = UserName("h").validate()
        assertEquals(UserNameValidResult.InvalidLength, userNameValidResult)
    }

    @Test
    fun `사용자 이름이 5자 초과이면 길이 유효성 검증에 실패한다`() {
        val userNameValidResult: UserNameValidResult = UserName("hannah").validate()
        assertEquals(UserNameValidResult.InvalidLength, userNameValidResult)
    }

    @Test
    fun `사용자 이름에 숫자나 기호가 포함되어 있지 않다면 유효성 검증에 성공한다`() {
        val userNameValidResult: UserNameValidResult = UserName("해나").validate()
        assertEquals(UserNameValidResult.Success, userNameValidResult)
    }

    @Test
    fun `사용자 이름에 숫자가 포함되어 있다면 문자 유효성 검증에 실패한다`() {
        val userNameValidResult: UserNameValidResult = UserName("해나731").validate()
        assertEquals(UserNameValidResult.InvalidCharacter, userNameValidResult)
    }

    @Test
    fun `사용자 이름에 기호가 포함되어 있다면 문자 유효성 검증에 실패한다`() {
        val userNameValidResult: UserNameValidResult = UserName("해나&#").validate()
        assertEquals(UserNameValidResult.InvalidCharacter, userNameValidResult)
    }

    @Test
    fun `사용자 이름에 숫자와 기호가 포함되어 있다면 문자 유효성 검증에 실패한다`() {
        val userNameValidResult: UserNameValidResult = UserName("해나1&").validate()
        assertEquals(UserNameValidResult.InvalidCharacter, userNameValidResult)
    }

    @Test
    fun `사용자 이름이 2~5자이고 숫자나 기호가 포함되어 있지 않다면 유효하다`() {
        val isValid: Boolean = UserName("해나").isValid()
        assertTrue(isValid)
    }

    @Test
    fun `사용자 이름이 2자 미만이면 유효하지 않다`() {
        val isValid: Boolean = UserName("h").isValid()
        assertFalse(isValid)
    }

    @Test
    fun `사용자 이름이 5자 초과이면 유효하지 않다`() {
        val isValid: Boolean = UserName("hannah").isValid()
        assertFalse(isValid)
    }

    @Test
    fun `사용자 이름에 숫자가 포함되어 있다면 유효하지 않다`() {
        val isValid: Boolean = UserName("해나731").isValid()
        assertFalse(isValid)
    }

    @Test
    fun `사용자 이름에 기호가 포함되어 있다면 유효하지 않다`() {
        val isValid: Boolean = UserName("해나&#").isValid()
        assertFalse(isValid)
    }

    @Test
    fun `사용자 이름이 2~5자 이상이고 숫자나 기호가 포함되어 있다면 유효하지 않다`() {
        val isValid: Boolean = UserName("해나123&#").isValid()
        assertFalse(isValid)
    }

    @Test
    fun `사용자 이름이 비어있는 상태는 오류가 아니다`() {
        val isError: Boolean = UserName("").isError()
        assertFalse(isError)
    }
}
