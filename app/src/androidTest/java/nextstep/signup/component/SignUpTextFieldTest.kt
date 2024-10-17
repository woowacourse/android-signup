package nextstep.signup.component

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import nextstep.signup.ui.component.SignUpTextField
import nextstep.signup.ui.model.UserName
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SignUpTextFieldTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val tag = "Chad"
    private val label = "SignUpTextField"
    private val text = "Bye"
    private val invalidLengthErrorMessage = "이름은 2~5자여야 합니다."
    private var userName by mutableStateOf(UserName(text))

    @Before
    fun setUp() {
        composeTestRule.setContent {
            SignUpTextField(
                modifier = Modifier.testTag(tag),
                label = label,
                value = userName.text,
                onValueChange = { value ->
                    userName = userName.copy(text = value)
                },
                isValid = userName.isValid(),
                errorMessage = userName.errorMessage(),
            )
        }
    }

    @Test
    fun label인자로_받은_label이_화면에_나타난다() {
        composeTestRule.onNodeWithText(label).assertExists()
    }

    @Test
    fun text인자로_받은_text가_화면에_나타난다() {
        composeTestRule.onNodeWithText(text).assertExists()
    }

    @Test
    fun 입력을_받으면_text가_변경된다() {
        val input = "Hi"
        composeTestRule.onNodeWithTag(tag).performTextInput(input)

        composeTestRule.onNodeWithTag(tag).assert(hasText(input + text))
    }

    @Test
    fun isValid인자로_받은_값이_true이면_에러_메시지가_나타나지_않는다() {
        userName = userName.copy(text = "안녕하세요")

        assertTrue(userName.isValid())
        assertEquals(userName.errorMessage(), "")
        composeTestRule.onNodeWithTag(tag).assert(!hasText(invalidLengthErrorMessage))
    }

    @Test
    fun isValid인자로_받은_값이_false이면_errorMessage로_받은_에러_메시지가_나타난다() {
        userName = userName.copy(text = "안녕하세요반갑습니다")

        assertFalse(userName.isValid())
        assertEquals(userName.errorMessage(), invalidLengthErrorMessage)
        composeTestRule.onNodeWithTag(tag).assert(hasText(invalidLengthErrorMessage))
    }
}
