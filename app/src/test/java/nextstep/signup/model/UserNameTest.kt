package nextstep.signup.model

import nextstep.signup.ui.model.UserName
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class UserNameTest {
    private val invalidLengthErrorMessage = "이름은 2~5자여야 합니다."
    private val invalidPatternErrorMessage = "이름에는 숫자나 기호가 포함될 수 없습니다."

    @Test
    fun `이름이 유효한 길이와 패턴을 만족하는 경우 에러가 발생하지 않는다`() {
        val validUserName = UserName("Chad")

        assertTrue(validUserName.isValid())
        assertEquals("", validUserName.errorMessage())
    }

    @Test
    fun `이름이 2글자 미만 경우 길이 에러가 발생한다`() {
        val shortUserName = UserName("C")

        assertFalse(shortUserName.isValid())
        assertEquals(invalidLengthErrorMessage, shortUserName.errorMessage())
    }

    @Test
    fun `이름이 5글자 초과인 경우 길이 에러가 발생한다`() {
        val longUserName = UserName("Chaddd")

        assertFalse(longUserName.isValid())
        assertEquals(invalidLengthErrorMessage, longUserName.errorMessage())
    }

    @Test
    fun `이름에 숫자가 포함된 경우 패턴 에러가 발생한다`() {
        val invalidPatternUserName = UserName("Chad1")

        assertFalse(invalidPatternUserName.isValid())
        assertEquals(invalidPatternErrorMessage, invalidPatternUserName.errorMessage())
    }

    @Test
    fun `이름에 특수문자가 포함된 경우 패턴 에러가 발생한다`() {
        val invalidPatternUserName = UserName("Chad@")

        assertFalse(invalidPatternUserName.isValid())
        assertEquals(invalidPatternErrorMessage, invalidPatternUserName.errorMessage())
    }
}
