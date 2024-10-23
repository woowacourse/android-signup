package nextstep.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.model.Password
import nextstep.signup.ui.ERROR_PASSWORD_FORMAT_MESSAGE
import nextstep.signup.ui.ERROR_PASSWORD_LENGTH_MESSAGE
import nextstep.signup.ui.component.InputText
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PasswordInputTextTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private var password by mutableStateOf(Password(""))

    @Before
    fun setup() {
        composeTestRule.setContent {
            InputText(
                title = R.string.sign_up_user_name_title,
                content = password.content,
                inputValidator = password,
            )
        }
    }

    @Test
    fun `비밀번호는_8에서_16글자_사이의_영문과_숫자를_포함한다`() {
        // when
        password = Password("password1")

        // then
        composeTestRule
            .onNodeWithText(ERROR_PASSWORD_LENGTH_MESSAGE)
            .assertDoesNotExist()
    }

    @Test
    fun `비밀번호가_8에서_16글자_사이가_아니라면_에러메세지가_노출된다`() {
        // when
        password = Password("pw")

        // then
        composeTestRule
            .onNodeWithText(ERROR_PASSWORD_LENGTH_MESSAGE)
            .assertExists()
    }

    @Test
    fun `비밀번호가_영문과_숫자를_포함하지_않는_경우_에러메세지가_노출된다`() {
        // when
        password = Password("password")

        // then
        composeTestRule
            .onNodeWithText(ERROR_PASSWORD_FORMAT_MESSAGE)
            .assertExists()
    }
}
