package nextstep.signup

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.isNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.signup.ui.SignUpButton
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SignUpButtonTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val isButtonEnable = mutableStateOf(false)


    @Before
    fun setUp() {
        composeTestRule.setContent {
            SignUpButton(isButtonEnable.value)
        }
    }

    @Test
    fun 버튼이_비활성화되면_클릭해도_스낵바가_노출되지_않는다() {
        // given
        composeTestRule.onNodeWithText(BUTTON_CONTENT).assertIsNotEnabled()

        // when
        composeTestRule.onNodeWithText(BUTTON_CONTENT).performClick()

        // then
        composeTestRule.onNodeWithText(SNACKBAR_MESSAGE).isNotDisplayed()
    }

    @Test
    fun 버튼이_활성화되면_클릭했을_때_스낵바가_노출된다() {
        // given
        isButtonEnable.value = true
        composeTestRule.onNodeWithText(BUTTON_CONTENT).assertIsEnabled()

        // when
        composeTestRule.onNodeWithText( BUTTON_CONTENT).performClick()

        // then
        composeTestRule.onNodeWithText(SNACKBAR_MESSAGE).isDisplayed()
    }

    companion object {
        private const val BUTTON_CONTENT = "Sign Up"
        private const val SNACKBAR_MESSAGE = "회원가입이 완료되었습니다."
    }

}