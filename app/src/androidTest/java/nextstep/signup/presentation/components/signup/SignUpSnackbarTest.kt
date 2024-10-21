package nextstep.signup.presentation.components.signup

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class SignUpSnackbarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 스낵바는_메세지를_보여준다() {
        val message = "회원가입 완료"
        composeTestRule.setContent {
            SignUpSnackbar(
                message = message,
                onDismiss = {}
            )
        }

        composeTestRule.onNodeWithText(message).assertIsDisplayed()
    }

    @Test
    fun 확인_버튼을_누르면_스낵바는_사라진다() {
        val message = "회원가입 완료"
        var dismissed = false
        composeTestRule.setContent {
            SignUpSnackbar(
                message = message,
                onDismiss = { dismissed = true }
            )
        }

        composeTestRule.onNodeWithText("확인").performClick()
        assert(dismissed)
    }
}
