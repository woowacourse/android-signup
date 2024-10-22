package nextstep.signup.domain

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class EmailTest {
    @Test
    fun `로컬 파트에 대소문자와 숫자 일부 특수문자 이외의 문자가 존재하면 유효하지 않다`() {
        // when
        val email = Email("wow!@test.com")

        // then
        assertFalse(email.isValid)
    }

    @Test
    fun `로컬 파트에 공백 문자가 존재하면 유효하지 않다`() {
        // when
        val email = Email("spa ce@test.com")

        // then
        assertFalse(email.isValid)
    }

    @Test
    fun `로컬 파트는 최소 1글자 이상이어야 한다`() {
        // when
        val email = Email("@test.com")

        // then
        assertFalse(email.isValid)
    }

    @Test
    fun `@ 문자가 존재하지 않으면 유효하지 않다`() {
        // when
        val email = Email("invalidEmail.com")

        // then
        assertFalse(email.isValid)
    }

    @Test
    fun `도메인 이름에는 대소문자, 숫자, 점, 하이픈이 들어갈 수 있다`() {
        // when
        val email = Email("local@wtc.6-hodu.com")

        // then
        assertTrue(email.isValid)
    }

    @Test
    fun `도메인 이름에 한글이 존재하면 유효하지 않다`() {
        // when
        val email = Email("local@우테코.com")

        // then
        assertFalse(email.isValid)
    }

    @Test
    fun `도메인 이름에 점, 하이픈 이외의 특수 문자가 존재하면 유효하지 않다`() {
        // when
        val email = Email("local@ops*&%strange.com")

        // then
        assertFalse(email.isValid)
    }

    @Test
    fun `도메인 이름에 공백 문자가 존재하면 유효하지 않다`() {
        // when
        val email = Email("local@spa ce.com")

        // then
        assertFalse(email.isValid)
    }

    @Test
    fun `도메인 이름은 최소 1글자 이상이어야 한다`() {
        // when
        val email = Email("invalid@.com")

        // then
        assertFalse(email.isValid)
    }

    @Test
    fun `최상위 도메인 이름에는 대소문자가 들어간다`() {
        // when
        val email = Email("local@domain.Korea")

        // then
        assertTrue(email.isValid)
    }

    @Test
    fun `최상위 도메인 이름에 공백 문자가 들어가면 유효하지 않다`() {
        // when
        val email = Email("local@domain.k r")

        // then
        assertFalse(email.isValid)
    }

    @Test
    fun `최상위 도메인 이름에 특수 문자가 들어가면 유효하지 않다`() {
        // when
        val email = Email("local@domain.\$sign")

        // then
        assertFalse(email.isValid)
    }

    @Test
    fun `최상위 도메인 글자 수가 2 보다 작으면 안된다`() {
        // when
        val email = Email("local@domain.a")

        // then
        assertFalse(email.isValid)
    }

    @Test
    fun `최상위 도메인 글자 수가 6 보다 크면 안된다`() {
        // when
        val email = Email("local@domain.wootech")

        // then
        assertFalse(email.isValid)
    }
}
