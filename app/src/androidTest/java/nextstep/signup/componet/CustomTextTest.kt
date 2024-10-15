package nextstep.signup.component

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.R
import nextstep.signup.componet.CustomText
import org.junit.Rule
import org.junit.Test

class CustomTextTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    /**
     * 흠 좋은 테스트 코드는 아닌 것 같음,,
     *
     * */
    @Test
    fun `CustomText가_제목을_정확하게_표시한다`() {
        // given
        val expectedText = "Username"

        composeTestRule.setContent {
            CustomText(
                modifier = Modifier,
                titleResId = R.string.username_input,
            )
        }

        // then
        composeTestRule
            .onNodeWithText(expectedText)
            .assertIsDisplayed()
    }
}
