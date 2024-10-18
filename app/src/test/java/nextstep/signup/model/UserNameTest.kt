package nextstep.signup.model

import org.junit.Assert.assertEquals
import org.junit.Test

class UserNameTest {
    @Test
    fun `사용자_이름이_2에서_5자면_에러_메시지는_null이_반환된다`() {
        val errorMessage: String? = UserName("해나").getErrorMessage()
        assertEquals(null, errorMessage)
    }

    @Test
    fun `사용자_이름이_2에서_5자가 아니면_에러메시지가_반환된다`() {
        val errorMessage: String? = UserName("hannah").getErrorMessage()
        assertEquals(USERNAME_LENGTH_ERROR, errorMessage)
    }

    @Test
    fun `사용자_이름에_숫자나_기호가_포함되어_있지_않다면_에러_메시지는_null이_반환된다`() {
        val errorMessage: String? = UserName("해나").getErrorMessage()
        assertEquals(null, errorMessage)
    }

    @Test
    fun `사용자_이름에_숫자나_기호가_포함되어_있다면_에러메시지가_반환된다`() {
        val errorMessage: String? = UserName("해나1&").getErrorMessage()
        assertEquals(USERNAME_FORM_ERROR, errorMessage)
    }

    @Test
    fun `사용자_이름이_2~5자이고_숫자나_기호가_포함되어_있지_않다면_isInvalid의_값은_false이다`() {
        val isInvalid: Boolean = UserName("해나").isInvalid()
        assertEquals(false, isInvalid)
    }

    @Test
    fun `사용자_이름이_2~5자_이상이고_숫자나_기호가_포함되어_있다면_isInvalid의_값은_true이다`() {
        val isInvalid: Boolean = UserName("해나123&").isInvalid()
        assertEquals(true, isInvalid)
    }

    companion object {
        private const val USERNAME_LENGTH_ERROR = "이름은 2~5자여야 합니다."
        private const val USERNAME_FORM_ERROR = "이름에는 숫자나 기호가 포함될 수 없습니다."
    }
}
