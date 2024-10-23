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
    fun `이름 값이 2자 미만일 때 올바른 에러를 반환한다`() {
        // given
        val name = Name("a")

        // when
        val error = name.getValidationError()

        // then
        assertEquals(InputError.NameError.InvalidLength, error)
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
    fun `이름 값이 5자 초과일 때 올바른 에러를 반환한다`() {
        // given
        val name = Name("abcdef")

        // when
        val error = name.getValidationError()

        // then
        assertEquals(InputError.NameError.InvalidLength, error)
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
    fun `이름 값에 특수문자가 포함되어 있을 때 올바른 에러를 반환한다`() {
        // given
        val name = Name("a!")

        // when
        val error = name.getValidationError()

        // then
        assertEquals(InputError.NameError.InvalidFormat, error)
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
    fun `이름 값이 조건에 부합할 때 에러메시지는 을 반환한다`() {
        // given
        val name = Name(VALID_NAME)

        // when
        val error = name.getValidationError()

        // then
        assertEquals(InputError.None, error)
    }
}
