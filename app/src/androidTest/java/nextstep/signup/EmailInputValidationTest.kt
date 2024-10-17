package nextstep.signup

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import nextstep.signup.model.fieldtype.InputFieldType
import nextstep.signup.presentation.component.InputField
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class EmailInputValidationTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup() {
        composeTestRule.setContent {
            InputField(
                label = EMAIL_INPUT_FIELD_LABEL,
                value = "",
                onValueChange = { _, _ -> },
                keyboardType = KeyboardType.Text,
                paddingBottom = 36.dp,
                type = InputFieldType.EMAIL,
            )
        }
    }

    @Test
    fun `이메일은_올바른_형식이어야_한다`() {
        // when
        composeTestRule
            .onNodeWithText(EMAIL_INPUT_FIELD_LABEL)
            .performTextInput("alsong@naver.com")

        // then
        composeTestRule
            .onNodeWithText(EMAIL_FORMAT_ERROR)
            .assertDoesNotExist()
    }

    @Test
    fun `이메일이_올바른_형식이_아니면_에러메시지가_노출된다`() {
        // when
        composeTestRule
            .onNodeWithText(EMAIL_INPUT_FIELD_LABEL)
            .performTextInput("나는아아알송")

        // then
        composeTestRule
            .onNodeWithText(EMAIL_FORMAT_ERROR)
            .assertExists()
    }

    companion object {
        private const val EMAIL_INPUT_FIELD_LABEL = "이메일 입력필드 테스트!"
        private const val EMAIL_FORMAT_ERROR = "이메일 형식이 올바르지 않습니다."
    }
}
