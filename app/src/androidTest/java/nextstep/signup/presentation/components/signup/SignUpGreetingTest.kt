package nextstep.signup.presentation.components.signup

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.R
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SignUpGreetingTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup() {
        composeTestRule.setContent {
            SignUpGreeting()
        }
    }

    @Test
    fun `SignUpGreeting이_정상적으로_표시된다`() {
        composeTestRule.onNodeWithText("Welcome to Compose \uD83D\uDE80")
            .assertExists()
    }
}
