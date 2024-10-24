package nextstep.signup.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.domain.ValidationState
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SignUpTextFieldKtTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private var value by mutableStateOf("")
    private var state by mutableStateOf(ValidationState.VALID)

    @Before
    fun setup() {
        composeTestRule.setContent {
            SignUpTextField(
                value = value,
                hint = "test hint",
                errorMessage = "에러 메시지",
            ) { value = it }
        }
    }

    @Test
    fun `입력값이_존재하며_유효할_시_에러_메시지가_노출되지_않는다`() {
        // when
        value = "입력값"
        state = ValidationState.LENGTH_ERROR

        // then
        composeTestRule
            .onNodeWithText(LENGTH_ERROR_MESSAGE)
            .assertExists()
    }

    @Test
    fun `입력값이_존재하며_길이_오류일_시_해당하는_에러_메시지가_노출된다`() {
        // when
        value = "입력값"
        state = ValidationState.LENGTH_ERROR

        // then
        composeTestRule
            .onNodeWithText(LENGTH_ERROR_MESSAGE)
            .assertExists()
    }

    @Test
    fun `입력값이_존재하며_형식_오류일_시_해당하는_에러_메시지가_노출된다`() {
        // when
        value = "입력값"
        state = ValidationState.FORMAT_ERROR

        // then
        composeTestRule
            .onNodeWithText(FORMAT_ERROR_MESSAGE)
            .assertExists()
    }

    @Composable
    private fun getErrorMessage(state: ValidationState): String {
        return when (state) {
            ValidationState.VALID -> ""
            ValidationState.FORMAT_ERROR -> FORMAT_ERROR_MESSAGE
            ValidationState.LENGTH_ERROR -> LENGTH_ERROR_MESSAGE
        }
    }

    companion object {
        private const val FORMAT_ERROR_MESSAGE = "형식 오류 메시지"
        private const val LENGTH_ERROR_MESSAGE = "길이 오류 메시지"
    }
}
