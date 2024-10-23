package nextstep.signup.ui.auth.screen

import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.espresso.Espresso.onIdle
import nextstep.signup.domain.EmailValidateResult
import nextstep.signup.ui.auth.component.AuthEmailTextField
import nextstep.signup.ui.auth.component.toErrorMessage
import org.junit.Rule
import org.junit.Test

class AuthEmailTextFieldTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `이메일이_유효하지_않으면_에러_메시지가_표시된다`() {
        // given
        val invalidEmail = "invalid"
        var emailErrorMessage: String? = null
        composeTestRule.setContent {
            emailErrorMessage = EmailValidateResult.InvalidEmailFormat.toErrorMessage()
            AuthEmailTextField(
                email = invalidEmail,
                onEmailChange = {}
            )
        }

        // then
        onIdle()
        assert(emailErrorMessage != null)
        composeTestRule.onNodeWithText(emailErrorMessage.orEmpty())
            .isDisplayed()
    }

    @Test
    fun `이메일이_비어있으면_에러_메시지가_표시된다`() {
        // given
        val invalidEmail = "invalid"
        var emailErrorMessage: String? = null
        composeTestRule.setContent {
            emailErrorMessage = EmailValidateResult.InvalidBlank.toErrorMessage()
            AuthEmailTextField(
                email = invalidEmail,
                onEmailChange = {}
            )
        }

        // then
        onIdle()
        assert(emailErrorMessage != null)
        composeTestRule.onNodeWithText(emailErrorMessage.orEmpty())
            .isDisplayed()
    }

    @Test
    fun `유효한_이메일이_입력되면_에러_메시지가_표시되지_않는다`() {
        // given
        val validEmail = "valid.email@example.com"
        var emailErrorMessage: String? = null
        composeTestRule.setContent {
            emailErrorMessage = EmailValidateResult.Success.toErrorMessage()
            AuthEmailTextField(
                email = validEmail,
                onEmailChange = {}
            )
        }
        composeTestRule

        onIdle()
        assert(emailErrorMessage == null)
    }
}
