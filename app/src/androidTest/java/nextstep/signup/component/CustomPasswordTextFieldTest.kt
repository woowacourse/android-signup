package nextstep.signup.component

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import org.junit.Rule
import org.junit.Test

class CustomPasswordTextFieldTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val textFieldTag = "CustomTextField"

    @Test
    fun `CustomTextField에_에러메시지가_정상적으로_표시된다`() {
        // Given
        val errorMessage = "Invalid input"
        composeTestRule.setContent {
            CustomTextField(
                modifier = Modifier.testTag(textFieldTag),
                value = "InvalidInput",
                onValueChange = {},
                label = "Username",
                isError = true,
                errorMessage = errorMessage
            )
        }

        // Then
        composeTestRule
            .onNodeWithTag(textFieldTag)
            .assertTextContains(errorMessage)
    }

    @Test
    fun `CustomTextField가_비어있을때_초기상태를_유지한다`() {
        // Given
        composeTestRule.setContent {
            CustomTextField(
                modifier = Modifier.testTag(textFieldTag),
                value = "",
                onValueChange = {},
                label = "Username",
                isError = false
            )
        }

        // Then
        composeTestRule
            .onNodeWithTag(textFieldTag)
            .assert(hasText(""))
    }
}
