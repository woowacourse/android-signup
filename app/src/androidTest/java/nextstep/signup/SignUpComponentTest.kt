package nextstep.signup

import androidx.annotation.StringRes
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SignUpComponentTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val appContext = InstrumentationRegistry.getInstrumentation().targetContext

    @Before
    fun setup() {
        composeTestRule.setContent {
            SignUpComponent()
        }
    }

    @Test
    fun `모든_입력값들이_입력되지_않았다면_버튼은_비활성화_된다`() {
        // then
        composeTestRule
            .onNodeWithText("Sign Up")
            .assertIsNotEnabled()
    }

    @Test
    fun `입력값_중_한_개라도_유효하지_않다면_버튼은_비활성화_된다`() {
        // when
        composeTestRule
            .onNodeWithText(stringResource(R.string.sign_up_user_name_title))
            .performTextInput("yenny")
        composeTestRule
            .onNodeWithText(stringResource(R.string.sign_up_email_title))
            .performTextInput("choco@naver.com")
        composeTestRule
            .onNodeWithText(stringResource(R.string.sign_up_password_title))
            .performTextInput("password12")
        composeTestRule
            .onNodeWithText(stringResource(R.string.sign_up_password_confirm_title))
            .performTextInput("password")

        // then
        composeTestRule
            .onNodeWithText(stringResource(R.string.sign_up_button_title))
            .assertIsNotEnabled()
    }

    @Test
    fun `모든_입력값들이_유효하다면_버튼은_활성화_된다`() {
        // when
        composeTestRule
            .onNodeWithText(stringResource(R.string.sign_up_user_name_title))
            .performTextInput("yenny")
        composeTestRule
            .onNodeWithText(stringResource(R.string.sign_up_email_title))
            .performTextInput("choco@naver.com")
        composeTestRule
            .onNodeWithText(stringResource(R.string.sign_up_password_title))
            .performTextInput("password12")
        composeTestRule
            .onNodeWithText(stringResource(R.string.sign_up_password_confirm_title))
            .performTextInput("password12")

        // then
        composeTestRule
            .onNodeWithText(stringResource(R.string.sign_up_button_title))
            .assertIsEnabled()
    }

    private fun stringResource(
        @StringRes resource: Int,
    ): String = appContext.resources.getString(resource)
}
