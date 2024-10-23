package nextstep.signup.model

import org.junit.Assert.assertEquals
import org.junit.Test

class UserNameTest {
    @Test
    fun `사용자_이름이_2자에서_5자_사이라면_유효하다`() {
        val userName = UserName("예니")

        val result = userName.validate()
        val expect = ValidationState.Valid
        assertEquals(expect, result)
    }

    @Test
    fun `사용자_이름이_2에서_5자가_아니면_유효하지_않다 - 2글자보다 적은 경우`() {
        val userName = UserName("조")

        val result = userName.validate()
        val expect = ValidationState.Invalid.UserName.Length
        assertEquals(expect, result)
    }

    @Test
    fun `사용자_이름이_2에서_5자가_아니면_유효하지_않다 - 5글자보다 많은 경우`() {
        val userName = UserName("안드로이드짱")

        val result = userName.validate()
        val expect = ValidationState.Invalid.UserName.Length
        assertEquals(expect, result)
    }

    @Test
    fun `사용자_이름에는_숫자나_기호가_포함되지_않는다`() {
        val userName = UserName("예니")

        val result = userName.validate()
        val expect = ValidationState.Valid
        assertEquals(expect, result)
    }

    @Test
    fun `사용자_이름에_숫자나_기호가_포함될_경우_유효하지_않다 - 숫자가 포함될 경우`() {
        val userName = UserName("예니12")

        val result = userName.validate()
        val expect = ValidationState.Invalid.UserName.Format
        assertEquals(expect, result)
    }

    @Test
    fun `사용자_이름에_숫자나_기호가_포함될_경우_유효하지_않다 - 기호가 포함될 경우`() {
        val userName = UserName("예니^^")

        val result = userName.validate()
        val expect = ValidationState.Invalid.UserName.Format
        assertEquals(expect, result)
    }
}
