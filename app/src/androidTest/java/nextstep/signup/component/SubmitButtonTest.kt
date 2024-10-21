package nextstep.signup.component

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import nextstep.signup.ui.component.SubmitButton
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SubmitButtonTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val tag = "Chad"
    private val text = "SignUpButton"
    private var isClicked = false
    private var enabled by mutableStateOf(true)

    @Before
    fun setUp() {
        composeTestRule.setContent {
            SubmitButton(modifier = Modifier.testTag(tag), text = text, onclick = {
                isClicked = true
            }, enabled = enabled)
        }
    }

    @Test
    fun text인자로_받은_text가_화면에_나타난다() {
        composeTestRule.onNodeWithText(text).assertExists()
    }

    @Test
    fun 클릭하면_onClick인자로_받은_이벤트가_발생한다() {
        composeTestRule
            .onNodeWithTag(tag)
            .performClick()

        assertTrue(isClicked)
    }

    @Test
    fun enabled가_true일때_클릭이_된다() {
        composeTestRule
            .onNodeWithTag(tag)
            .performClick()

        assertTrue(isClicked)
    }

    @Test
    fun enabled가_false일때_클릭되지_않는다() {
        enabled = false

        composeTestRule
            .onNodeWithTag(tag)
            .performClick()

        assertFalse(isClicked)
    }
}
