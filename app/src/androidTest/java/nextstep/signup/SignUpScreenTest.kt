package nextstep.signup

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class SignUpScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun signUpTitleText() {
        composeTestRule.setContent {
            SignUpTitle("wellcome~!")
        }

        composeTestRule
            .onNodeWithText("wellcome~!")
            .assertExists()
    }
}
