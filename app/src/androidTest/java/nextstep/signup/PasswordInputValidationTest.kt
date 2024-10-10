package nextstep.signup

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.text.input.TextFieldValue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PasswordInputValidationTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val password = mutableStateOf(TextFieldValue(""))

    @Before
    fun setup() {
        composeTestRule.setContent {
            FakeSignUpField(
                textValue = password.value,
                onValueChange = { password.value = it },
                validateField = { SignupFieldValidation.isValidPassword(it) },
            )
        }
    }

    @Test
    fun `비밀번호는_8에서_16자여야_한다`() {
        // when
        password.value = TextFieldValue("abcdefg123")

        // then
        composeTestRule
            .onNodeWithText(PASSWORD_LENGTH_WARNING_MESSAGE)
            .assertDoesNotExist()
    }

    @Test
    fun `비밀번호가_8에서_16자가_아니면_에러메시지가_노출된다_1`() {
        // when
        password.value = TextFieldValue("abc4567")

        // then
        composeTestRule
            .onNodeWithText(PASSWORD_LENGTH_WARNING_MESSAGE)
            .assertExists()
    }

    @Test
    fun `비밀번호가_8에서_16자가_아니면_에러메시지가_노출된다_2`() {
        // when
        password.value = TextFieldValue("abcdefghijklmn123")

        // then
        composeTestRule
            .onNodeWithText(PASSWORD_LENGTH_WARNING_MESSAGE)
            .assertExists()
    }

    @Test
    fun `비밀번호는_영문과_숫자를_포함해야_한다`() {
        // when
        password.value = TextFieldValue("abcdefg123")

        // then
        composeTestRule
            .onNodeWithText(PASSWORD_LENGTH_WARNING_MESSAGE)
            .assertDoesNotExist()
    }

    @Test
    fun `비밀번호는_영문과_숫자를_포함하지_않으면_에러메시지가_노출된다_1`() {
        // when
        password.value = TextFieldValue("abcdefghi")

        // then
        composeTestRule
            .onNodeWithText(PASSWORD_COMPOSITION_WARNING_MESSAGE)
            .assertExists()
    }

    @Test
    fun `비밀번호는_영문과_숫자를_포함하지_않으면_에러메시지가_노출된다_2`() {
        // when
        password.value = TextFieldValue("123456789")

        // then
        composeTestRule
            .onNodeWithText(PASSWORD_COMPOSITION_WARNING_MESSAGE)
            .assertExists()
    }

    companion object {
        private const val PASSWORD_COMPOSITION_WARNING_MESSAGE = "비밀번호는 영문과 숫자를 포함해야 합니다."
        private const val PASSWORD_LENGTH_WARNING_MESSAGE = "비밀번호는 8~16자여야 합니다."
    }
}
