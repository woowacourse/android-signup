package nextstep.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.model.Email
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class EmailComposableTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private var email by mutableStateOf(Email(""))

    @Before
    fun setup() {
        composeTestRule.setContent {
            EmailComposable(email = email, onEmailChange = { email = email.copy(email = it) })
        }
    }

    @Test
    fun `이메일_형식이_올바르면_에러메시지가_노출되지_않는다`() {
        // when
        email = Email("hannah@naver.com")

        // then
        composeTestRule
            .onNodeWithText(EMAIL_FORM_ERROR)
            .assertDoesNotExist()
    }

    @Test
    fun `이메일_형식이_올바르지_않으면_에러메시지가_노출된다`() {
        // when
        email = Email("hannahnaver.com")

        // then
        composeTestRule
            .onNodeWithText(EMAIL_FORM_ERROR)
            .assertExists()
    }

    companion object {
        private const val EMAIL_FORM_ERROR = "이메일 형식이 올바르지 않습니다."
    }
}
