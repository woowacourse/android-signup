package nextstep.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.model.Email
import nextstep.signup.model.Password
import nextstep.signup.model.PasswordConfirm
import nextstep.signup.model.User
import nextstep.signup.model.UserName
import nextstep.signup.ui.component.ButtonComponent
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class InputValidationTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private var username by mutableStateOf(UserName(""))
    private var email by mutableStateOf(Email(""))
    private var password by mutableStateOf(Password(""))
    private var passwordConfirm by mutableStateOf(PasswordConfirm(""))
    private var isEnabled: Boolean by mutableStateOf(false)

    @Before
    fun setup() {
        composeTestRule.setContent {
            UserNameComposable(userName = username, onUserNameChange = { username = username.copy(userName = it) })
            EmailComposable(email = email, onEmailChange = { email = email.copy(email = it) })
            PasswordComposable(password = password, onPasswordChange = { password = password.copy(password = it) })
            PasswordConfirmComposable(
                password = password,
                passwordConfirm = passwordConfirm,
                onPasswordConfirmChange = { passwordConfirm = passwordConfirm.copy(passwordConfirm = it) },
            )
            ButtonComponent(
                modifier = Modifier.testTag(BUTTON_TEST_TAG),
                enabled = isEnabled,
                description = stringResource(id = R.string.main_sign_up),
            )
        }
    }

    @Test
    fun `사용자_이름은_2에서_5자여야_한다`() {
        // when
        username = UserName("해나")

        // then
        composeTestRule
            .onNodeWithText(USERNAME_LENGTH_ERROR)
            .assertDoesNotExist()
    }

    @Test
    fun `사용자_이름이_2에서_5자가_아니면_에러메시지가_노출된다`() {
        // when
        username = UserName("해나해나입니다")

        // then
        composeTestRule
            .onNodeWithText(USERNAME_LENGTH_ERROR)
            .assertExists()
    }

    @Test
    fun `사용자_이름에는_숫자나_기호가_포함되지_않아야_한다`() {
        // when
        username = UserName("해나")

        // then
        composeTestRule
            .onNodeWithText(USERNAME_FORM_ERROR)
            .assertDoesNotExist()
    }

    @Test
    fun `사용자_이름에_숫자나_기호가_포함되어_있다면_에러메시지가_노출된다`() {
        // when
        username = UserName("해1&")

        // then
        composeTestRule
            .onNodeWithText(USERNAME_FORM_ERROR)
            .assertExists()
    }

    @Test
    fun `이메일_형식이_올바르면_에러메시지가_노출되지_않는다`() {
        // when
        email = Email("hannah@naver.com")

        // then
        composeTestRule
            .onNodeWithText(EMAIL_FORM_ERROR)
            .assertDoesNotExist()
    }

    @Test
    fun `이메일_형식이_올바르지_않으면_에러메시지가_노출된다`() {
        // when
        email = Email("hannahnaver.com")

        // then
        composeTestRule
            .onNodeWithText(EMAIL_FORM_ERROR)
            .assertExists()
    }

    @Test
    fun `비밀번호는_8에서_16자여야_한다`() {
        password = Password("hannah0731")

        composeTestRule
            .onNodeWithText(PASSWORD_LENGTH_ERROR)
            .assertDoesNotExist()
    }

    @Test
    fun `비밀번호가_8에서_16자가_아니면_에러메시지가_노출된다`() {
        password = Password("hye731")

        composeTestRule
            .onNodeWithText(PASSWORD_LENGTH_ERROR)
            .assertExists()
    }

    @Test
    fun `비밀번호는_영문과_숫자를_포함해야_한다`() {
        password = Password("hannah0731")

        composeTestRule
            .onNodeWithText(PASSWORD_FORM_ERROR)
            .assertDoesNotExist()
    }

    @Test
    fun `비밀번호는_영문과_숫자를_포함하지_않으면_에러메시지가_노출된다`() {
        password = Password("gonghyeyeon")
        composeTestRule
            .onNodeWithText(PASSWORD_FORM_ERROR)
            .assertExists()
    }

    @Test
    fun `비밀번호와_확인용_비밀번호는_일치해야_한다`() {
        password = Password("hannah0731")
        passwordConfirm = PasswordConfirm("hannah0731")

        composeTestRule
            .onNodeWithText(PASSWORD_CONFIRM_ERROR)
            .assertDoesNotExist()
    }

    @Test
    fun `비밀번호와_확인용_비밀번호가_일치하지_않으면_에러메시지가_노출된다`() {
        password = Password("hannah0731")
        passwordConfirm = PasswordConfirm("hannah07")

        composeTestRule
            .onNodeWithText(PASSWORD_CONFIRM_ERROR)
            .assertExists()
    }

    @Test
    fun `회원가입_정보가_모두_유효하다면_회원가입_버튼의_isEnabled_상태는_true이다`() {
        val user =
            User(
                UserName("해나"),
                Email("hannah@naver.com"),
                Password("hannah0731"),
                PasswordConfirm("hannah0731"),
            )
        isEnabled = user.isAbleToSubmit()

        composeTestRule
            .onNodeWithTag("test")
            .assertIsEnabled()
    }

    @Test
    fun `사용자_이름이_유효하지_않다면_회원가입_버튼의_isEnabled_상태는_false이다`() {
        val user =
            User(
                UserName("해나해나해나"),
                Email("hannah@naver.com"),
                Password("hannah0731"),
                PasswordConfirm("hannah0731"),
            )
        isEnabled = user.isAbleToSubmit()

        composeTestRule
            .onNodeWithTag("test")
            .assertIsNotEnabled()
    }

    @Test
    fun `Email_형식이_유효하지_않다면_회원가입_버튼의_isEnabled_상태는_false이다`() {
        val user =
            User(
                UserName("해나"),
                Email("hannahnaver.com"),
                Password("hannah0731"),
                PasswordConfirm("hannah0731"),
            )
        isEnabled = user.isAbleToSubmit()

        composeTestRule
            .onNodeWithTag("test")
            .assertIsNotEnabled()
    }

    @Test
    fun `비밀번호_형식이_유효하지_않다면_회원가입_버튼의_isEnabled_상태는_false이다`() {
        val user =
            User(
                UserName("해나"),
                Email("hannah@naver.com"),
                Password("gonghyeyeon"),
                PasswordConfirm("gonghyeyeon"),
            )
        isEnabled = user.isAbleToSubmit()

        composeTestRule
            .onNodeWithTag("test")
            .assertIsNotEnabled()
    }

    @Test
    fun `비밀번호와_확인용_비밀번호가_일치하지_않는다면_회원가입_버튼의_isEnabled_상태는_false이다`() {
        val user =
            User(
                UserName("해나"),
                Email("hannah@naver.com"),
                Password("hannah0731"),
                PasswordConfirm("hannah07"),
            )
        isEnabled = user.isAbleToSubmit()

        composeTestRule
            .onNodeWithTag("test")
            .assertIsNotEnabled()
    }

    @Test
    fun `입력란이_모두_비어있다면_회원가입_버튼의_isEnabled_상태는_false이다`() {
        val user =
            User(
                UserName(""),
                Email(""),
                Password(""),
                PasswordConfirm(""),
            )
        isEnabled = user.isAbleToSubmit()

        composeTestRule
            .onNodeWithTag(BUTTON_TEST_TAG)
            .assertIsNotEnabled()
    }

    companion object {
        private const val USERNAME_LENGTH_ERROR = "이름은 2~5자여야 합니다."
        private const val USERNAME_FORM_ERROR = "이름에는 숫자나 기호가 포함될 수 없습니다."

        private const val EMAIL_FORM_ERROR = "이메일 형식이 올바르지 않습니다."

        private const val PASSWORD_LENGTH_ERROR = "비밀번호는 8~16자여야 합니다."
        private const val PASSWORD_FORM_ERROR = "비밀번호는 영문과 숫자를 포함해야 합니다."

        private const val PASSWORD_CONFIRM_ERROR = "비밀번호가 일치하지 않습니다."

        private const val BUTTON_TEST_TAG = "test"
    }
}
