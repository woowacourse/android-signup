package nextstep.signup.component

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.presentation.componet.CustomText
import org.junit.Rule
import org.junit.Test

class CustomTextTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `값을_정확하게_표시한다`() {
        // given
        val expectedText = "Username"

        composeTestRule.setContent {
            CustomText(
                modifier = Modifier,
                title = expectedText,
            )
        }

        // then
        composeTestRule
            .onNodeWithText(expectedText)
            .assertIsDisplayed()
    }
}
