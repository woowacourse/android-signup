package nextstep.signup

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.text.input.TextFieldValue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class EmailInputValidationTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val email = mutableStateOf(TextFieldValue(""))

    @Before
    fun setup() {
        composeTestRule.setContent {
            FakeSignUpField(
                textValue = email.value,
                onValueChange = { email.value = it },
                validateField = { SignupFieldValidation.isValidEmail(it) },
            )
        }
    }

    @Test
    fun `이메일_형식이_올바를_경우_에러메시지가_노출되지_않는다`() {
        // when
        email.value = TextFieldValue("seogi@seogida.com")

        // then
        composeTestRule
            .onNodeWithText(EMAIL_COMPOSITION_WARNING_MESSAGE)
            .assertDoesNotExist()
    }

    @Test
    fun `이메일_형식이_올바지_않을_경우_에러메시지가_노출된다_1`() {
        // when
        email.value = TextFieldValue("seogi@seogida")

        // then
        composeTestRule
            .onNodeWithText(EMAIL_COMPOSITION_WARNING_MESSAGE)
            .assertExists()
    }

    @Test
    fun `이메일_형식이_올바지_않을_경우_에러메시지가_노출된다_2`() {
        // when
        email.value = TextFieldValue("seogi.com")

        // then
        composeTestRule
            .onNodeWithText(EMAIL_COMPOSITION_WARNING_MESSAGE)
            .assertExists()
    }

    companion object {
        private const val EMAIL_COMPOSITION_WARNING_MESSAGE = "이메일 형식이 올바르지 않습니다."
    }
}
