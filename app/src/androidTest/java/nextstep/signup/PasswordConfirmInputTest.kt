package nextstep.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.model.Password
import nextstep.signup.model.PasswordConfirm
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PasswordConfirmInputTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private var password by mutableStateOf(Password(""))
    private var passwordConfirm by mutableStateOf(PasswordConfirm(""))

    @Before
    fun setup() {
        composeTestRule.setContent {
            PasswordComposable(
                password = password,
                onPasswordChange = { password = password.copy(password = it) },
            )
            PasswordConfirmComposable(
                password = password,
                passwordConfirm = passwordConfirm,
                onPasswordConfirmChange = {
                    passwordConfirm = passwordConfirm.copy(passwordConfirm = it)
                },
            )
        }
    }

    @Test
    fun `비밀번호와_확인용_비밀번호는_일치해야_한다`() {
        password = Password("hannah0731")
        passwordConfirm = PasswordConfirm("hannah0731")

        composeTestRule.onNodeWithText(PASSWORD_CONFIRM_ERROR).assertDoesNotExist()
    }

    @Test
    fun `비밀번호와_확인용_비밀번호가_일치하지_않으면_에러메시지가_노출된다`() {
        password = Password("hannah0731")
        passwordConfirm = PasswordConfirm("hannah07")

        composeTestRule.onNodeWithText(PASSWORD_CONFIRM_ERROR).assertExists()
    }

    companion object {
        private const val PASSWORD_CONFIRM_ERROR = "비밀번호가 일치하지 않습니다."
    }
}
