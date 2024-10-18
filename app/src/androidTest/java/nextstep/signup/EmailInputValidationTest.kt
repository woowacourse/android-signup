package nextstep.signup

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.ui.common.textfield.InputType
import nextstep.signup.ui.common.textfield.SingleLineTextInput
import nextstep.signup.ui.common.textfield.validateEmailInput
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class EmailInputValidationTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val email = mutableStateOf("")

    @Before
    fun setup() {
        composeTestRule.setContent {
            SingleLineTextInput(
                label = "이메일 테스트",
                value = email.value,
                onValueChange = { email.value = it },
                inputType = InputType.Email,
                validateInput = { validateEmailInput(email.value) },
            )
        }
    }

    @Test
    fun 입력된_이메일이_형식에_맞아야_한다() {
        // when
        email.value = "abcdef@test.xyz"

        // then
        composeTestRule
            .onNodeWithText(EMAIL_FORMAT_ERROR)
            .assertDoesNotExist()
    }

    @Test
    fun 입력된_이메일이_형식에_어긋나면_에러메시지가_노출된다() {
        // when
        email.value = "thisisnot.valid.email@"

        // then
        composeTestRule
            .onNodeWithText(EMAIL_FORMAT_ERROR)
            .assertExists()
    }

    companion object {
        private const val EMAIL_FORMAT_ERROR = "이메일 형식이 올바르지 않습니다."
    }
}
