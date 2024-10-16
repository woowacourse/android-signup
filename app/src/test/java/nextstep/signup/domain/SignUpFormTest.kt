package nextstep.signup.domain

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class SignUpFormTest {
    private lateinit var signUpForm: SignUpForm

    @Before
    fun setUp() {
        signUpForm = SignUpForm.emptySignUpForm
    }

    @Test
    fun `유저 이름은 2글자 이하면 LENGTH_ERROR를 반환한다`() {
        signUpForm = signUpForm.copy(userName = "한")

        assertEquals(ValidationState.LENGTH_ERROR, signUpForm.validateUserName())
    }

    @Test
    fun `유저 이름은 5글자 이상이면 LENGTH_ERROR를 반환한다`() {
        signUpForm = signUpForm.copy(userName = "여섯글자이다")

        assertEquals(ValidationState.LENGTH_ERROR, signUpForm.validateUserName())
    }

    @Test
    fun `유저 이름에는 특수문자가 들어갈 수 없다`() {
        signUpForm = signUpForm.copy(userName = "$@")

        assertEquals(ValidationState.FORMAT_ERROR, signUpForm.validateUserName())
    }

    @Test
    fun `이메일에 @와 마침표가 들어가야 한다`() {
        signUpForm = signUpForm.copy(email = "temp@email.com")

        assertEquals(ValidationState.VALID, signUpForm.validateEmail())
    }

    @Test
    fun `이메일에 @와 마침표가 없으면 FORMAT_ERROR를 반환한다`() {
        signUpForm = signUpForm.copy(email = "tempmailcom")

        assertEquals(ValidationState.FORMAT_ERROR, signUpForm.validateEmail())
    }

    @Test
    fun `비밀번호는 영문과 숫자의 조합이다`() {
        signUpForm = signUpForm.copy(password = "password123")

        assertEquals(ValidationState.VALID, signUpForm.validatePassword())
    }

    @Test
    fun `비밀번호는 8글자 이상이다`() {
        signUpForm = signUpForm.copy(password = "pass123")

        assertEquals(ValidationState.LENGTH_ERROR, signUpForm.validatePassword())
    }

    @Test
    fun `비밀번호는 16글자 이하이다`() {
        signUpForm = signUpForm.copy(password = "a17lengthPassword")

        assertEquals(ValidationState.LENGTH_ERROR, signUpForm.validatePassword())
    }

    @Test
    fun `비밀번호는 영문과 숫자의 조합이 아니면 FORMAT_ERROR를 반환한다`() {
        signUpForm = signUpForm.copy(password = "onlyEnglish")

        assertEquals(ValidationState.FORMAT_ERROR, signUpForm.validatePassword())
    }
}
