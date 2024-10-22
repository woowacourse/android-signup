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
import nextstep.signup.model.Email
import nextstep.signup.model.Password
import nextstep.signup.model.PasswordConfirm
import nextstep.signup.model.User
import nextstep.signup.model.UserName
import nextstep.signup.ui.component.ButtonComponent
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SignUpButtonComposableTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private var isEnabled: Boolean by mutableStateOf(false)

    @Before
    fun setup() {
        composeTestRule.setContent {
            ButtonComponent(
                modifier = Modifier.testTag(BUTTON_TEST_TAG),
                enabled = isEnabled,
                description = stringResource(id = R.string.main_sign_up),
            )
        }
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
        private const val BUTTON_TEST_TAG = "test"
    }
}
