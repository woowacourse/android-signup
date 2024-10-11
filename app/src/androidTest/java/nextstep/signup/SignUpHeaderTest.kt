package nextstep.signup

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.presentation.signup.SignUpHeader
import org.junit.Rule
import org.junit.Test

class SignUpHeaderTest {
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
