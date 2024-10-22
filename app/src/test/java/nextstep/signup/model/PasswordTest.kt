package nextstep.signup.model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PasswordTest {
    @Test
    fun `비밀번호 값이 8자 미만일 때 isInvalid는 true이다`() {
        // given
        val password = Password("1q")

        // when
        val result = password.isInvalid()

        // then
        assertTrue(result)
    }

    @Test
    fun `비밀번호 값이 8자 미만일 때 올바른 에러를 반환한다`() {
        // given
        val password = Password("1q")

        // when
        val error = password.getValidationError()

        // then
        assertEquals(
            InputError.PasswordError.InvalidLength,
            error
        )
    }

    @Test
    fun `비밀번호 값이 16자 초과일 때 isInvalid는 true이다`() {
        // given
        val password = Password("1q2w3e4r5t6y7u8i9o0p1q2w3e4r5t6y7u8i9o0p")

        // when
        val result = password.isInvalid()

        // then
        assertTrue(result)
    }

    @Test
    fun `비밀번호 값이 16자 초과일 때 올바른 에러를 반환한다`() {
        // given
        val password = Password("1q2w3e4r5t6y7u8i9o0p1q2w3e4r5t6y7u8i9o0p")

        // when
        val error = password.getValidationError()

        // then
        assertEquals(InputError.PasswordError.InvalidLength, error)
    }

    @Test
    fun `비밀번호 값에 특수문자가 포함되어 있지 않을 때 isInvalid는 true이다`() {
        // given
        val password = Password("1q2w3e4r5t")

        // when
        val result = password.isInvalid()

        // then
        assertTrue(result)
    }

    @Test
    fun `비밀번호 값에 특수문자가 포함되어 있지 않을 때 올바른 에러를 반환한다`() {
        // given
        val password = Password("1q2w3e4r5t")

        // when
        val error = password.getValidationError()

        // then
        assertEquals(InputError.PasswordError.InvalidFormat, error)
    }

    @Test
    fun `비밀번호 값이 조건에 부합할 때 isInvalid는 false이다`() {
        // given
        val password = Password(VALID_PASSWORD)

        // when
        val result = password.isInvalid()

        // then
        assertFalse(result)
    }

    @Test
    fun `비밀번호 값이 조건에 부합할 때 None을 반환한다`() {
        // given
        val password = Password(VALID_PASSWORD)

        // when
        val error = password.getValidationError()

        // then
        assertEquals(InputError.None, error)
    }
}
