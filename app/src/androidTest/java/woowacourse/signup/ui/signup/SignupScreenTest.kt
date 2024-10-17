package woowacourse.signup.ui.signup

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import woowacourse.signup.R
import woowacourse.signup.ui.testStringResource

class SignupScreenTest {
    @get:Rule
    val composeTestRule: ComposeContentTestRule = createComposeRule()

    @Before
    fun setup() {
        composeTestRule.setContent {
            SignupScreen()
        }
    }

    @Test
    fun `모든_입력값이_에러_없이_채워졌다면_회원가입_버튼이_활성화된다`() {
        // when
        composeTestRule
            .performInputSignupInfo(
                userName = "올리브",
                email = "olive@wooteco.com",
                password = "olive123",
                passwordConfirm = "olive123",
            )

        // then
        composeTestRule.waitForIdle()
        composeTestRule
            .onNodeWithText(testStringResource(id = R.string.sign_up_button))
            .assertIsEnabled()
    }

    @Test
    fun `입력값에_에러가_있다면_회원가입_버튼이_비활성화된다`() {
        // when
        composeTestRule
            .performInputSignupInfo(
                userName = "올",
                email = "olive",
                password = "ol",
                passwordConfirm = "olive",
            )

        // then
        composeTestRule.waitForIdle()
        composeTestRule
            .onNodeWithText(testStringResource(id = R.string.sign_up_button))
            .assertIsNotEnabled()
    }

    @Test
    fun `회원가입_버튼을_누르면_회원가입_완료_스낵바가_노출된다`() {
        // given
        composeTestRule
            .performInputSignupInfo(
                userName = "올리브",
                email = "olive@wooteco.com",
                password = "olive123",
                passwordConfirm = "olive123",
            )

        // when
        composeTestRule
            .onNodeWithText(testStringResource(id = R.string.sign_up_button))
            .performClick()

        // then
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithText(testStringResource(id = R.string.complete_join))
            .assertIsDisplayed()
    }

    private fun ComposeContentTestRule.performInputSignupInfo(
        userName: String,
        email: String,
        password: String,
        passwordConfirm: String,
    ) {
        composeTestRule
            .onNodeWithText(testStringResource(id = R.string.username_input))
            .performTextInput(userName)

        composeTestRule
            .onNodeWithText(testStringResource(id = R.string.email_input))
            .performTextInput(email)

        composeTestRule
            .onNodeWithText(testStringResource(id = R.string.password_input))
            .performTextInput(password)

        composeTestRule
            .onNodeWithText(testStringResource(id = R.string.password_confirm_input))
            .performTextInput(passwordConfirm)
    }
}
