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

class UsernameInputValidationTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup() {
        composeTestRule.setContent {
            InputField(
                label = USERNAME_INPUT_FIELD_LABEL,
                value = "",
                onValueChange = {},
                keyboardType = KeyboardType.Text,
                paddingBottom = 36.dp,
                type = InputFieldType.USER_NAME,
            )
        }
    }

    @Test
    fun `사용자_이름은_2에서_5자_사이여야_한다`() {
        // when
        composeTestRule
            .onNodeWithText(USERNAME_INPUT_FIELD_LABEL)
            .performTextInput("알송")

        // then
        composeTestRule
            .onNodeWithText(USERNAME_LENGTH_ERROR)
            .assertDoesNotExist()
    }

    @Test
    fun `사용자_이름이_2에서_5자가_아니면_에러메시지가_노출된다`() {
        // when
        composeTestRule
            .onNodeWithText(USERNAME_INPUT_FIELD_LABEL)
            .performTextInput("나는아아알송")

        // then
        composeTestRule
            .onNodeWithText(USERNAME_LENGTH_ERROR)
            .assertExists()
    }

    @Test
    fun `사용자_이름에_숫자나_기호가_포함되지_않아야_한다`() {
        // when
        composeTestRule
            .onNodeWithText(USERNAME_INPUT_FIELD_LABEL)
            .performTextInput("아알송")

        // then
        composeTestRule
            .onNodeWithText(USERNAME_FORMAT_ERROR)
            .assertDoesNotExist()
    }

    @Test
    fun `사용자_이름에_숫자나_기호가_포함되면_에러메시지가_노출된다`() {
        // when
        composeTestRule
            .onNodeWithText(USERNAME_INPUT_FIELD_LABEL)
            .performTextInput("알송1")

        // then
        composeTestRule
            .onNodeWithText(USERNAME_FORMAT_ERROR)
            .assertExists()
    }

    companion object {
        private const val USERNAME_INPUT_FIELD_LABEL = "유저네임 입력필드 테스트!"
        private const val USERNAME_LENGTH_ERROR = "이름은 2~5자여야 합니다."
        private const val USERNAME_FORMAT_ERROR = "이름에는 숫자나 기호가 포함될 수 없습니다."
    }
}
