package nextstep.signup.model

import org.junit.Assert.assertEquals
import org.junit.Test

class PasswordTest {
    @Test
    fun `비밀번호가 8자 이상 16자 이하라면 PasswordValidResult는 Success가 반환된다`() {
        val passwordValidResult: PasswordValidResult = Password("hannah0731").validate()
        assertEquals(PasswordValidResult.Success, passwordValidResult)
    }

    @Test
    fun `비밀번호가 8자 미만이라면 PasswordValidResult는 InvalidLength가 반환된다`() {
        val passwordValidResult: PasswordValidResult = Password("hye731").validate()
        assertEquals(PasswordValidResult.InvalidLength, passwordValidResult)
    }

    @Test
    fun `비밀번호가 16자 초과라면 PasswordValidResult는 InvalidLength가 반환된다`() {
        val passwordValidResult: PasswordValidResult = Password("hannah731gonghyeyeon").validate()
        assertEquals(PasswordValidResult.InvalidLength, passwordValidResult)
    }

    @Test
    fun `비밀번호가 영문과 숫자를 포함하고 있다면 PasswordValidResult는 Success가 반환된다`() {
        val passwordValidResult: PasswordValidResult = Password("hannah0731").validate()
        assertEquals(PasswordValidResult.Success, passwordValidResult)
    }

    @Test
    fun `비밀번호가 숫자를 포함하지 않으면 PasswordValidResult는 InvalidCharacter가 반환된다`() {
        val passwordValidResult: PasswordValidResult = Password("gonghyeyeon").validate()
        assertEquals(PasswordValidResult.InvalidCharacter, passwordValidResult)
    }

    @Test
    fun `비밀번호가 영문을 포함하지 않으면 PasswordValidResult는 InvalidCharacter가 반환된다`() {
        val passwordValidResult: PasswordValidResult = Password("1234567899").validate()
        assertEquals(PasswordValidResult.InvalidCharacter, passwordValidResult)
    }

    @Test
    fun `비밀번호가 영문과 숫자를 포함하지 않으면 PasswordValidResult는 InvalidCharacter가 반환된다`() {
        val passwordValidResult: PasswordValidResult = Password("해나해나해나@#$").validate()
        assertEquals(PasswordValidResult.InvalidCharacter, passwordValidResult)
    }

    @Test
    fun `비밀번호가 8~16자이고 영문과 숫자를 포함하고 있다면 isValid의 값은 true이다`() {
        val isValid: Boolean = Password("hannah0731").isValid()
        assertEquals(true, isValid)
    }

    @Test
    fun `비밀번호가 8자 미만이라면 isValid의 값은 false이다`() {
        val isValid: Boolean = Password("hye731").isValid()
        assertEquals(false, isValid)
    }

    @Test
    fun `비밀번호가 16자 초과라면 isValid의 값은 false이다`() {
        val isValid: Boolean = Password("hannah731gonghyeyeon").isValid()
        assertEquals(false, isValid)
    }

    @Test
    fun `비밀번호가 숫자를 포함하지 않으면 isValid의 값은 false이다`() {
        val isValid: Boolean = Password("gonghyeyeon").isValid()
        assertEquals(false, isValid)
    }

    @Test
    fun `비밀번호가 영문을 포함하지 않으면 isValid의 값은 false이다`() {
        val isValid: Boolean = Password("1234567899").isValid()
        assertEquals(false, isValid)
    }

    @Test
    fun `비밀번호가 8~16자가 아니고 영문과 숫자를 포함하고 있지 않다면 isValid의 값은 false이다`() {
        val isValid: Boolean = Password("해나@#\$").isValid()
        assertEquals(false, isValid)
    }

    @Test
    fun `비밀번호가 비어있다면 isError의 값은 false이다`() {
        val isError: Boolean = Password("").isError()
        assertEquals(false, isError)
    }
}
