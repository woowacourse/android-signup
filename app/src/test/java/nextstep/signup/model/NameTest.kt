package nextstep.signup.model

import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test

class NameTest {
    @Test
    fun `이름 값이 2자 미만일 때 isInvalid는 true이다`() {
        // given
        val name = Name("a")

        // when
        val result = name.isInvalid()

        // then
        Assert.assertTrue(result)
    }

    @Test
    fun `이름 값이 2자 미만일 때 올바른 에러 메시지를 반환한다`() {
        // given
        val name = Name("a")

        // when
        val errorMessage = name.getErrorMessage()

        // then
        assertEquals(Name.ERROR_USER_NAME_LENGTH, errorMessage)
    }

    @Test
    fun `이름 값이 5자 초과일 때 isInvalid는 true이다`() {
        // given
        val name = Name("abcdef")

        // when
        val result = name.isInvalid()

        // then
        Assert.assertTrue(result)
    }

    @Test
    fun `이름 값이 5자 초과일 때 올바른 에러 메시지를 반환한다`() {
        // given
        val name = Name("abcdef")

        // when
        val errorMessage = name.getErrorMessage()

        // then
        assertEquals(Name.ERROR_USER_NAME_LENGTH, errorMessage)
    }

    @Test
    fun `이름 값에 특수문자가 포함되어 있을 때 isInvalid는 true이다`() {
        // given
        val name = Name("a!")

        // when
        val result = name.isInvalid()

        // then
        Assert.assertTrue(result)
    }

    @Test
    fun `이름 값에 특수문자가 포함되어 있을 때 올바른 에러 메시지를 반환한다`() {
        // given
        val name = Name("a!")

        // when
        val errorMessage = name.getErrorMessage()

        // then
        assertEquals(Name.ERROR_USER_NAME_REGEX, errorMessage)
    }

    @Test
    fun `이름 값이 조건에 부합할 때 isInvalid는 false이다`() {
        // given
        val name = Name("abcde")

        // when
        val result = name.isInvalid()

        // then
        Assert.assertFalse(result)
    }

    @Test
    fun `이름 값이 조건에 부합할 때 에러메시지는 null을 반환한다`() {
        // given
        val name = Name(VALID_NAME)

        // when
        val errorMessage = name.getErrorMessage()

        // then
        assertEquals(null, errorMessage)
    }
}
