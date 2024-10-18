package nextstep.signup

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.domain.Email
import nextstep.signup.ui.common.textfield.InputType
import nextstep.signup.ui.common.textfield.SingleLineTextInput
import nextstep.signup.ui.signup.SignUpValidator.validateEmail
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class EmailInputValidationTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val email = mutableStateOf(Email())

    @Before
    fun setup() {
        composeTestRule.setContent {
            SingleLineTextInput(
                label = "이메일 테스트",
                value = email.value.value,
                onValueChange = { email.value = Email(it) },
                inputType = InputType.Email,
                validateInput = { email.value.validateEmail() },
            )
        }
    }

    @Test
    fun 입력된_이메일이_형식에_맞아야_한다() {
        // when
        email.value = Email("abcdef@test.xyz")

        // then
        composeTestRule
            .onNodeWithText(EMAIL_FORMAT_ERROR)
            .assertDoesNotExist()
    }

    @Test
    fun 입력된_이메일이_형식에_어긋나면_에러메시지가_노출된다() {
        // when
        email.value = Email("thisisnot.valid.email@")

        // then
        composeTestRule
            .onNodeWithText(EMAIL_FORMAT_ERROR)
            .assertExists()
    }

    companion object {
        private const val EMAIL_FORMAT_ERROR = "이메일 형식이 올바르지 않습니다."
    }
}
