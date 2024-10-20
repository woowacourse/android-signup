package nextstep.signup.ui.auth.screen

import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.espresso.Espresso.onIdle
import nextstep.signup.R
import nextstep.signup.domain.EmailValidateResult
import nextstep.signup.ui.auth.component.AuthEmailTextField
import nextstep.signup.ui.auth.model.toErrorMessage
import org.junit.Rule
import org.junit.Test

class AuthEmailTextFieldTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `이메일이_유효하지_않으면_에러_메시지가_표시된다`() {
        // given
        val invalidEmail = "invalid"
        val emailValidateResult = EmailValidateResult.InvalidEmailFormat
        var emailLabel = ""
        var emailErrorMessage: String? = null
        composeTestRule.setContent {
            emailLabel = stringResource(id = R.string.sign_up_email_form)
            emailErrorMessage = emailValidateResult.toErrorMessage()
            AuthEmailTextField(
                email = invalidEmail,
                onEmailChange = {},
                emailValidateResult = emailValidateResult
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
        val emailValidateResult = EmailValidateResult.InvalidBlank
        var emailLabel = ""
        var emailErrorMessage: String? = null
        composeTestRule.setContent {
            emailLabel = stringResource(id = R.string.sign_up_email_form)
            emailErrorMessage = emailValidateResult.toErrorMessage()
            AuthEmailTextField(
                email = invalidEmail,
                onEmailChange = {},
                emailValidateResult = emailValidateResult
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
        val emailValidateResult = EmailValidateResult.Success
        var emailErrorMessage: String? = null
        composeTestRule.setContent {
            emailErrorMessage = emailValidateResult.toErrorMessage()
            AuthEmailTextField(
                email = validEmail,
                onEmailChange = {},
                emailValidateResult = EmailValidateResult.Success
            )
        }

        onIdle()
        assert(emailErrorMessage == null)
    }
}
