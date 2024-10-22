package nextstep.signup.component

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import nextstep.signup.model.Name
import nextstep.signup.ui.InputFieldConfig
import org.junit.Rule
import org.junit.Test

class CustomTextFieldTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val textFieldTag = "CustomTextField"

    @Test
    fun `CustomTextField에_에러메시지가_정상적으로_표시된다`() {
        // Given
        val errorMessage = "이름은 2~5자여야 합니다."
        val errorFieldConfig = InputFieldConfig(
            value = "d",
            onValueChange = {},
            model = Name(value = "d"),
            label = "Username"
        )

        composeTestRule.setContent {
            InputField(
                modifier = Modifier.testTag(textFieldTag),
                config = errorFieldConfig,
                showError = true
            )
        }

        // Then
        composeTestRule
            .onNodeWithTag(textFieldTag)
            .assertTextContains(errorMessage)
    }

    @Test
    fun `InputField가_비어있을때_초기상태를_유지한다`() {
        // Given
        composeTestRule.setContent {
            InputField(
                modifier = Modifier.testTag(textFieldTag),
                config = InputFieldConfig(
                    value = "",
                    onValueChange = {},
                    model = Name(""),
                    label = "Username"
                ),
                showError = false
            )
        }

        // Then
        composeTestRule
            .onNodeWithTag(textFieldTag)
            .assert(hasText(""))
    }

    @Test
    fun `isPassword가_true일때_비밀번호_가리기가_정상적으로_동작한다`() {
        // Given
        val password = "password"
        composeTestRule.setContent {
            InputField(
                modifier = Modifier.testTag(textFieldTag),
                config = InputFieldConfig(
                    value = password,
                    onValueChange = {},
                    model = Name(password),
                    label = "Password"
                ),
                showError = false,
                isPassword = true
            )
        }

        // Then
        composeTestRule
            .onNodeWithTag(textFieldTag)
            .assert(hasText("••••••••"))
    }
}
