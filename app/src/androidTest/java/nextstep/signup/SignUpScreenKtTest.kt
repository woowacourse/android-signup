package nextstep.signup

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class SignUpScreenKtTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun signUpHeaderText() {
        // given
        composeTestRule.setContent {
            SignUpHeader()
        }

        // then
        composeTestRule
            .onNodeWithText("Welcome to Compose 🚀")
            .assertExists()
    }
}
