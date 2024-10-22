package nextstep.signup.componet

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import nextstep.signup.R
import nextstep.signup.presentation.componet.CustomButton
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CustomButtonTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val tag = "tag"
    private var isClicked by mutableStateOf(false)
    private var enabled by mutableStateOf(true)

    @Before
    fun setup() {
        composeTestRule.setContent {
            CustomButton(
                modifier = Modifier.testTag(tag),
                buttonTitle = stringResource(R.string.sign_up_button),
                enabled = enabled,
                onClick = { isClicked = true },
            )
        }
    }

    @Test
    fun `버튼의_텍스트가_올바르게_표시된다`() {
        // given
        val buttonText = "Sign Up"

        // then
        composeTestRule
            .onNodeWithTag(tag)
            .assertExists()
            .assert(hasText(buttonText))
    }

    @Test
    fun `버튼_클릭_시_클릭_상태가_반영된다`() {
        // given & when
        composeTestRule
            .onNodeWithTag(tag)
            .performClick()

        // then
        Assert.assertTrue(isClicked)
    }

    @Test
    fun `비활성화된_버튼이_클릭되지_않는다`() {
        // given
        enabled = false

        // when
        composeTestRule
            .onNodeWithTag(tag)
            .performClick()

        // then
        Assert.assertFalse(isClicked)
    }
}
