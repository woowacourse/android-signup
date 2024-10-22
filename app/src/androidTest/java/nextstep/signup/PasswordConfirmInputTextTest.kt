package nextstep.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.model.PasswordConfirm
import nextstep.signup.ui.component.InputText
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PasswordConfirmInputTextTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val password = "password12"
    private var passwordConfirm by mutableStateOf(PasswordConfirm("", password = password))

    @Before
    fun setup() {
        composeTestRule.setContent {
            InputText(
                title = R.string.sign_up_user_name_title,
                content = passwordConfirm.content,
                inputValidator = passwordConfirm,
            )
        }
    }

    @Test
    fun `비밀번호_확인란_값이_비밀번호와_같지않은_경우_에러메세지가_표시된다`() {
        // when
        passwordConfirm = passwordConfirm.copy(content = "password34")

        // then
        composeTestRule
            .onNodeWithText(PasswordConfirm.ERROR_PASSWORD_CONFIRM_MESSAGE)
            .assertExists()
    }

    @Test
    fun `비밀번호_확인란의_값은_비밀번호와_같아야한다`() {
        // when
        passwordConfirm = passwordConfirm.copy(content = "password12")

        // then
        composeTestRule
            .onNodeWithText(PasswordConfirm.ERROR_PASSWORD_CONFIRM_MESSAGE)
            .assertDoesNotExist()
    }
}
