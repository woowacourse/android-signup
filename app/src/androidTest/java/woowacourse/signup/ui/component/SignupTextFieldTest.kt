package woowacourse.signup.ui.component

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import org.assertj.core.api.Assertions.assertThat
import org.junit.Rule
import org.junit.Test

class SignupTextFieldTest {
    @get:Rule
    val composeTestRule: ComposeContentTestRule = createComposeRule()

    @Test
    fun 입력값이_변경되면_onValueChange이_호출된다() {
        // given
        var value by mutableStateOf("")
        composeTestRule.setContent {
            SignupTextField(
                labelText = signupTextFieldLabel,
                inputValue = value,
                isError = false,
                errorText = ""
            ) {
                value = "메롱"
            }
        }

        // when
        composeTestRule
            .onNodeWithText(signupTextFieldLabel)
            .performTextInput("input field value changed")

        // then
        composeTestRule.waitForIdle()
        assertThat(value).isEqualTo("메롱")
    }
    @Test
    fun 에러면_에러_메시지가_노출된다() {
        // when
        composeTestRule.setContent {
            SignupTextField(
                labelText = signupTextFieldLabel,
                inputValue = "input value",
                isError = true,
                errorText = "error message")
        }

        // then
        composeTestRule.waitForIdle()
        composeTestRule
            .onNodeWithText("error message")
            .assertExists()
    }

    @Test
    fun 에러가_아니면_에러_메시지가_노출되지_않는다() {
        // when
        composeTestRule.setContent {
            SignupTextField(
                labelText = signupTextFieldLabel,
                inputValue = "input value",
                isError = false,
                errorText = "error message")
        }

        // then
        composeTestRule.waitForIdle()
        composeTestRule
            .onNodeWithText("error message")
            .assertDoesNotExist()
    }

    @Test
    fun 아무것도_입력되지_않았다면_에러여도_에러_메시지가_노출되지_않는다() {
        // when
        composeTestRule.setContent {
            SignupTextField(
                labelText = signupTextFieldLabel,
                inputValue = "",
                isError = true,
                errorText = "error message")
        }

        // then
        composeTestRule.waitForIdle()
        composeTestRule
            .onNodeWithText("error message")
            .assertDoesNotExist()
    }
}
