package nextstep.signup

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.text.input.TextFieldValue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ConfirmedPasswordInputValidationTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val confirmedPassword = mutableStateOf(TextFieldValue(""))

    @Before
    fun setup() {
        composeTestRule.setContent {
            FakeSignUpField(
                textValue = confirmedPassword.value,
                onValueChange = { confirmedPassword.value = it },
                validateField = {
                    SignupFieldValidation.isValidConfirmedPassword(
                        password = "password123",
                        it,
                    )
                },
            )
        }
    }

    @Test
    fun `비밀번호_재입력_시_입력한_비밀번호와_일치해야_한다`() {
        // when
        confirmedPassword.value = TextFieldValue("password123")

        // then
        composeTestRule
            .onNodeWithText(PASSWORD_CONFIRM_WARNING_MESSAGE)
            .assertDoesNotExist()
    }

    @Test
    fun `비밀번호_재입력_시_입력한_비밀번호와_일치하지_않으면_에러메시지가_노출된다`() {
        // when
        confirmedPassword.value = TextFieldValue("passward123")

        // then
        composeTestRule
            .onNodeWithText(PASSWORD_CONFIRM_WARNING_MESSAGE)
            .assertExists()
    }

    companion object {
        private const val PASSWORD_CONFIRM_WARNING_MESSAGE = "비밀번호가 일치하지 않습니다."
    }
}
