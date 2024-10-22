package nextstep.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.model.Password
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PasswordComposableTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private var password by mutableStateOf(Password(""))

    @Before
    fun setup() {
        composeTestRule.setContent {
            PasswordComposable(password = password, onPasswordChange = { password = password.copy(password = it) })
        }
    }

    @Test
    fun `비밀번호는_8에서_16자여야_한다`() {
        password = Password("hannah0731")

        composeTestRule
            .onNodeWithText(PASSWORD_LENGTH_ERROR)
            .assertDoesNotExist()
    }

    @Test
    fun `비밀번호가_8에서_16자가_아니면_에러메시지가_노출된다`() {
        password = Password("hye731")

        composeTestRule
            .onNodeWithText(PASSWORD_LENGTH_ERROR)
            .assertExists()
    }

    @Test
    fun `비밀번호는_영문과_숫자를_포함해야_한다`() {
        password = Password("hannah0731")

        composeTestRule
            .onNodeWithText(PASSWORD_FORM_ERROR)
            .assertDoesNotExist()
    }

    @Test
    fun `비밀번호는_영문과_숫자를_포함하지_않으면_에러메시지가_노출된다`() {
        password = Password("gonghyeyeon")
        composeTestRule
            .onNodeWithText(PASSWORD_FORM_ERROR)
            .assertExists()
    }

    companion object {
        private const val PASSWORD_LENGTH_ERROR = "비밀번호는 8~16자여야 합니다."
        private const val PASSWORD_FORM_ERROR = "비밀번호는 영문과 숫자를 포함해야 합니다."
    }
}
