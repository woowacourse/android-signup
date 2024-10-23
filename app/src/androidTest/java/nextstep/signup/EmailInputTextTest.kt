package nextstep.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.model.Email
import nextstep.signup.ui.ERROR_EMAIL_MESSAGE
import nextstep.signup.ui.component.InputText
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class EmailInputTextTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private var email by mutableStateOf(Email(""))

    @Before
    fun setup() {
        composeTestRule.setContent {
            InputText(
                title = R.string.sign_up_user_name_title,
                content = email.content,
                inputValidator = email,
            )
        }
    }

    @Test
    fun `유효한_형식의_이메일을_입력해야_한다`() {
        // when
        email = Email("choco@naver.com")

        // then
        composeTestRule
            .onNodeWithText(ERROR_EMAIL_MESSAGE)
            .assertDoesNotExist()
    }

    @Test
    fun `유효하지_않은_형식의_이메일을_입력할_경우_에러메세지가_표시된다`() {
        // when
        email = Email("choco")

        // then
        composeTestRule
            .onNodeWithText(ERROR_EMAIL_MESSAGE)
            .assertExists()
    }
}
