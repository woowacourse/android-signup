package nextstep.signup.model

import nextstep.signup.R
import org.junit.Assert
import org.junit.Test

class UserNameTest {
    @Test
    fun `사용자 이름이 비어있을 때 유효성 검사가 통과된다`() {
        // given
        val userName = UserName("")

        // when
        val result = userName.validate()

        // then
        Assert.assertFalse(result.isError)
    }

    @Test
    fun `사용자 이름이 2자 이상 5자 이하일 경우 유효성 검사가 통과된다`() {
        // given
        val userName = UserName("준장")

        // when
        val result = userName.validate()

        // then
        Assert.assertFalse(result.isError)
    }

    @Test
    fun `사용자 이름이 2자 미만일 경우 유효성 검사가 실패한다`() {
        // given
        val userName = UserName("J")

        // when
        val result = userName.validate()

        // then
        Assert.assertTrue(result.isError)
        Assert.assertEquals(result.stringRes, R.string.error_username_length)
    }

    @Test
    fun `사용자 이름이 5자를 초과할 경우 유효성 검사가 실패한다`() {
        // given
        val userName = UserName("준장조준장장")

        // when
        val result = userName.validate()

        // then
        Assert.assertTrue(result.isError)
        Assert.assertEquals(result.stringRes, R.string.error_username_length)
    }

    @Test
    fun `사용자 이름에 특수 문자가 포함되면 유효성 검사가 실패한다`() {
        // given
        val userName = UserName("준장!")

        // when
        val result = userName.validate()

        // then
        Assert.assertTrue(result.isError)
        Assert.assertEquals(result.stringRes, R.string.error_username_invalid_characters)
    }

    @Test
    fun `사용자 이름에 숫자가 포함되면 유효성 검사가 실패한다`() {
        // given
        val userName = UserName("준장1")

        // when
        val result = userName.validate()

        // then
        Assert.assertTrue(result.isError)
        Assert.assertEquals(result.stringRes, R.string.error_username_invalid_characters)
    }

    @Test
    fun `사용자 이름이 알파벳과 한글로만 구성될 경우 유효성 검사가 통과된다`() {
        // given
        val userName = UserName("Jun장")

        // when
        val result = userName.validate()

        // then
        Assert.assertFalse(result.isError)
    }
}
