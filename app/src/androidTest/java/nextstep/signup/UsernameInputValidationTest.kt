package nextstep.signup

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.domain.Username
import nextstep.signup.ui.common.textfield.InputType
import nextstep.signup.ui.common.textfield.SingleLineTextInput
import nextstep.signup.ui.signup.SignUpValidator.validateUsername
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UsernameInputValidationTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val username = mutableStateOf(Username(""))

    @Before
    fun setup() {
        composeTestRule.setContent {
            SingleLineTextInput(
                label = "이름 테스트",
                value = username.value.value,
                onValueChange = { username.value = Username(it) },
                inputType = InputType.Username,
                supportingText = username.value.validateUsername(),
            )
        }
    }

    @Test
    fun `사용자_이름은_2에서_5자여야_한다`() {
        // when
        username.value = Username("원컴포즈")

        // then
        composeTestRule
            .onNodeWithText(USERNAME_LENGTH_ERROR)
            .assertDoesNotExist()
    }

    @Test
    fun `사용자_이름이_2에서_5자가_아니면_에러메시지가_노출된다`() {
        // when
        username.value = Username("원컴포즈입니다")

        // then
        composeTestRule
            .onNodeWithText(USERNAME_LENGTH_ERROR)
            .assertExists()
    }

    @Test
    fun `사용자_이름에_숫자나_기호가_포함되면_에러메시지가_노출된다`() {
        // when
        username.value = Username("원.컴포즈")

        // then
        composeTestRule
            .onNodeWithText(USERNAME_FORMAT_ERROR)
            .assertExists()
    }

    @Test
    fun `사용자_이름에_공백이_포함되면_에러메시지가_노출된다`() {
        // when
        username.value = Username("원컴 포즈")

        // then
        composeTestRule
            .onNodeWithText(USERNAME_FORMAT_ERROR)
            .assertExists()
    }

    companion object {
        private const val USERNAME_LENGTH_ERROR = "이름은 2~5자여야 합니다."
        private const val USERNAME_FORMAT_ERROR = "이름에는 숫자나 기호가 포함될 수 없습니다."
    }
}
