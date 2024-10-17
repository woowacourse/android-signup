package nextstep.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import nextstep.signup.model.fieldtype.PasswordInputFieldType
import nextstep.signup.presentation.component.PasswordInputField
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PasswordInputValidationTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup() {
        composeTestRule.setContent {
            Column {
                PasswordInputField(
                    label = PASSWORD_INPUT_FIELD_LABEL,
                    value = "",
                    onValueChange = { _, _ -> },
                    keyboardType = KeyboardType.Password,
                    paddingBottom = 36.dp,
                    type = PasswordInputFieldType.PASSWORD,
                )

                PasswordInputField(
                    label = PASSWORD_CONFIRM_INPUT_FIELD_LABEL,
                    value = "",
                    onValueChange = { _, _ -> },
                    keyboardType = KeyboardType.Password,
                    paddingBottom = 36.dp,
                    type = PasswordInputFieldType.PASSWORD_CONFIRM,
                )
            }
        }
    }

    @Test
    fun `비밀번호는_8에서_16자_사이여야_한다`() {
        // when
        composeTestRule
            .onNodeWithText(PASSWORD_INPUT_FIELD_LABEL)
            .performTextInput("alsong1234")

        // then
        composeTestRule
            .onNodeWithText(PASSWORD_LENGTH_ERROR)
            .assertDoesNotExist()
    }

    @Test
    fun `비밀번호는_8에서_16자_사이가_아니면_에러메세지가_노출된다`() {
        // when
        composeTestRule
            .onNodeWithText(PASSWORD_INPUT_FIELD_LABEL)
            .performTextInput("alsong1")

        // then
        composeTestRule
            .onNodeWithText(PASSWORD_LENGTH_ERROR)
            .assertExists()
    }

    @Test
    fun `비밀번호는_영문과_숫자를_포함해야_한다`() {
        // when
        composeTestRule
            .onNodeWithText(PASSWORD_INPUT_FIELD_LABEL)
            .performTextInput("alsong1234")

        // then
        composeTestRule
            .onNodeWithText(PASSWORD_FORMAT_ERROR)
            .assertDoesNotExist()
    }

    @Test
    fun `비밀번호가_영문과_숫자를_포함하지_않으면_에러메세지를_노출시킨다`() {
        // when
        composeTestRule
            .onNodeWithText(PASSWORD_INPUT_FIELD_LABEL)
            .performTextInput("alsongalsong")

        // then
        composeTestRule
            .onNodeWithText(PASSWORD_FORMAT_ERROR)
            .assertExists()
    }

    @Test
    fun `비밀번호_확인_필드는_비밀번호와_일치해야_한다`() {
        // when
        composeTestRule
            .onNodeWithText(PASSWORD_INPUT_FIELD_LABEL)
            .performTextInput("alsong1234")

        composeTestRule
            .onNodeWithText(PASSWORD_CONFIRM_INPUT_FIELD_LABEL)
            .performTextInput("alsong1234")

        // then
        composeTestRule
            .onNodeWithText(PASSWORD_CONFIRM_NOT_MATCH_ERROR)
            .assertDoesNotExist()
    }

//    @Test
//    fun `비밀번호_확인_필드가_비밀번호와_일치하지_않으면_에러메세지가_노출된다`() {
//        // when
//        composeTestRule
//            .onNodeWithText(PASSWORD_INPUT_FIELD_LABEL)
//            .performTextInput("alsong1234")
//
//        composeTestRule
//            .onNodeWithText(PASSWORD_CONFIRM_INPUT_FIELD_LABEL)
//            .performTextInput("1234alsong")
//
//        // then
//        composeTestRule
//            .onNodeWithText(PASSWORD_CONFIRM_NOT_MATCH_ERROR)
//            .assertExists()
//    }

    companion object {
        private const val PASSWORD_INPUT_FIELD_LABEL = "비번 입력필드 테스트!"
        private const val PASSWORD_CONFIRM_INPUT_FIELD_LABEL = "비번 입력 확인 필드 테스트!"
        private const val PASSWORD_LENGTH_ERROR = "비밀번호는 8~16자여야 합니다."
        private const val PASSWORD_FORMAT_ERROR = "비밀번호는 영문과 숫자를 포함해야 합니다."
        private const val PASSWORD_CONFIRM_NOT_MATCH_ERROR = "비밀번호가 일치하지 않습니다."
    }
}
