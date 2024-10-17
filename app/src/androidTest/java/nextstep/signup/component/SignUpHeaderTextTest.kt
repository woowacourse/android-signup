package nextstep.signup.component

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.ui.component.SignUpHeaderText
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SignUpHeaderTextTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val text = "SignUpHeaderText"

    @Before
    fun setUp() {
        composeTestRule.setContent {
            SignUpHeaderText(text = text)
        }
    }

    @Test
    fun text인자로_받은_text가_화면에_나타난다() {
        composeTestRule.onNodeWithText(text).assertExists()
    }
}
