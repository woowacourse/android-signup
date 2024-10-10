package nextstep.signup

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.text.input.TextFieldValue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UserNameInputValidationTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val userName = mutableStateOf(TextFieldValue(""))

    @Before
    fun setup() {
        composeTestRule.setContent {
            FakeSignUpField(
                textValue = userName.value,
                onValueChange = { userName.value = it },
                validateField = { SignupFieldValidation.isValidUserName(it) },
            )
        }
    }

    @Test
    fun `사용자_이름은_2에서_5자여야_한다`() {
        // when
        userName.value = TextFieldValue("남서기")

        // then
        composeTestRule
            .onNodeWithText(USERNAME_LENGTH_ERROR)
            .assertDoesNotExist()
    }

    @Test
    fun `사용자_이름이_2에서_5자가_아니면_에러메시지가_노출된다_1`() {
        // when
        userName.value = TextFieldValue("남")

        // then
        composeTestRule
            .onNodeWithText(USERNAME_LENGTH_ERROR)
            .assertExists()
    }

    @Test
    fun `사용자_이름이_2에서_5자가_아니면_에러메시지가_노출된다_2`() {
        // when
        userName.value = TextFieldValue("남서기입니다")

        // then
        composeTestRule
            .onNodeWithText(USERNAME_LENGTH_ERROR)
            .assertExists()
    }

    @Test
    fun `사용자_이름은_숫자나_기호가_아닌_문자로_구성되어야_한다`() {
        // when
        userName.value = TextFieldValue("abcde")

        // then
        composeTestRule
            .onNodeWithText(USERNAME_LENGTH_ERROR)
            .assertDoesNotExist()
    }

    @Test
    fun `사용자_이름에_숫자나_기호가_있으면_에러메시지가_노출된다_1`() {
        // when
        userName.value = TextFieldValue("abcd1")

        // then
        composeTestRule
            .onNodeWithText(USERNAME_COMPOSITION_ERROR)
            .assertExists()
    }

    @Test
    fun `사용자_이름에_숫자나_기호가_있으면_에러메시지가_노출된다_2`() {
        // when
        userName.value = TextFieldValue("@bcde")

        // then
        composeTestRule
            .onNodeWithText(USERNAME_COMPOSITION_ERROR)
            .assertExists()
    }

    companion object {
        private const val USERNAME_LENGTH_ERROR = "이름은 2~5자여야 합니다."
        private const val USERNAME_COMPOSITION_ERROR = "이름에는 숫자나 기호가 포함될 수 없습니다."
    }
}
