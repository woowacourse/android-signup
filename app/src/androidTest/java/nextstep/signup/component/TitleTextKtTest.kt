package nextstep.signup.component

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class TitleTextKtTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `TitleText가_정상적으로_렌더링된다`() {
        val title = "Welcome to Compose"
        // given
        composeTestRule.setContent {
            TitleText(
                title = title
            )
        }

        // then
        composeTestRule
            .onNodeWithText(title)
            .assertExists()
    }
}
