package nextstep.signup.fixtures.ui.main

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.R
import nextstep.signup.ui.component.SignUpField
import nextstep.signup.ui.model.ConfirmedPassword
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ConfirmedPasswordInputValidationTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val confirmedPassword = mutableStateOf(ConfirmedPassword(password = "password123"))

    @Before
    fun setup() {
        composeTestRule.setContent {
            SignUpField(
                labelId = R.string.signup_password_confirm_label,
                value = confirmedPassword.value.value,
                onValueChange = {
                    confirmedPassword.value = confirmedPassword.value.copy(value = it)
                },
                signUpResult = confirmedPassword.value.validation,
            )
        }
    }

    @Test
    fun `비밀번호_재입력_시_입력한_비밀번호와_일치해야_한다`() {
        // when
        confirmedPassword.value = confirmedPassword.value.copy(value = "password123")

        // then
        composeTestRule
            .onNodeWithText(PASSWORD_CONFIRM_WARNING_MESSAGE)
            .assertDoesNotExist()
    }

    @Test
    fun `비밀번호_재입력_시_입력한_비밀번호와_일치하지_않으면_에러메시지가_노출된다`() {
        // when
        confirmedPassword.value = confirmedPassword.value.copy(value = "passward123")

        // then
        composeTestRule
            .onNodeWithText(PASSWORD_CONFIRM_WARNING_MESSAGE)
            .assertExists()
    }

    companion object {
        private const val PASSWORD_CONFIRM_WARNING_MESSAGE = "비밀번호가 일치하지 않습니다."
    }
}
