package woowacourse.signup.ui.component

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.assertj.core.api.Assertions.assertThat
import org.junit.Rule
import org.junit.Test

class SignupButtonTest {
    @get:Rule
    val composeTestRule: ComposeContentTestRule = createComposeRule()

    @Test
    fun `버튼을_누르면_onClick이_호출된다`() {
        // given
        var state by mutableStateOf(false)

        composeTestRule.setContent {
            SignupButton(
                text = BUTTON_TEXT,
                enabled = true,
                onClick = { state = true },
            )
        }

        // when
        composeTestRule
            .onNodeWithText(BUTTON_TEXT)
            .performClick()

        // then
        composeTestRule.waitForIdle()
        assertThat(state).isTrue
    }

    companion object {
        private const val BUTTON_TEXT = "SignupButtonText"
    }
}
