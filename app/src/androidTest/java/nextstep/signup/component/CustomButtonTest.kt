package nextstep.signup.component

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class CustomButtonTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val buttonTag = "CustomButtonTag"
    private var isClicked by mutableStateOf(false)

    @Test
    fun `CustomButton이_비활성화상태일때_assertIsNotEnabled를_통과한다`() {
        composeTestRule.setContent {
            CustomButton(
                modifier = Modifier.testTag(buttonTag),
                onClick = { isClicked = true },
                buttonText = "Sign Up",
                enabled = false
            )
        }

        // When
        composeTestRule
            .onNodeWithTag(buttonTag)
            .assertIsNotEnabled()

        composeTestRule
            .onNodeWithTag(buttonTag)
            .performClick()

        // Then
        assertFalse(isClicked)
    }

    @Test
    fun `CustomButton이_활성화상태일때_assertIsEnabled를_통과한다`() {
        // Given
        composeTestRule.setContent {
            CustomButton(
                modifier = Modifier.testTag(buttonTag),
                onClick = { isClicked = true },
                buttonText = "Sign Up",
                enabled = true // 활성화된 상태
            )
        }

        // When
        composeTestRule
            .onNodeWithTag(buttonTag)
            .assertIsEnabled()

        composeTestRule
            .onNodeWithTag(buttonTag)
            .performClick()

        // Then
        assertTrue(isClicked)
    }
}
