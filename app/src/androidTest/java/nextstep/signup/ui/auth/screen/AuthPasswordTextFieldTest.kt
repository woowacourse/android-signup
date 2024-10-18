package nextstep.signup.ui.auth.screen

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.espresso.Espresso.onIdle
import nextstep.signup.domain.PasswordValidateResult
import nextstep.signup.ui.auth.component.AuthPasswordTextField
import nextstep.signup.ui.auth.model.toErrorMessage
import org.junit.Rule
import org.junit.Test

class AuthPasswordTextFieldTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `영어_없으면_에러_메시지가_표시된다`() {
        // given
        val password = "12345678"
        val passwordValidateResult = PasswordValidateResult.InValidNotContainAlpha
        var passwordErrorMessage: String? = null

        composeTestRule.setContent {
            passwordErrorMessage = passwordValidateResult.toErrorMessage()
            AuthPasswordTextField(
                password = password,
                onPasswordChange = {},
                passwordValidateResult = passwordValidateResult
            )
        }

        // then
        assert(passwordErrorMessage != null)
        composeTestRule.onNodeWithText(passwordErrorMessage.orEmpty())
            .assertExists()
    }

    @Test
    fun `숫자_없으면_에러_메시지가_표시된다`() {
        // given
        val password = "invalidpassword"
        val passwordValidateResult = PasswordValidateResult.InValidNotContainNumber
        var passwordErrorMessage: String? = null

        composeTestRule.setContent {
            passwordErrorMessage = passwordValidateResult.toErrorMessage()
            AuthPasswordTextField(
                password = password,
                onPasswordChange = {},
                passwordValidateResult = passwordValidateResult
            )
        }

        // then
        assert(passwordErrorMessage != null)
        composeTestRule.onNodeWithText(passwordErrorMessage.orEmpty())
            .assertExists()
    }

    @Test
    fun `비밀번호가_유효하면_에러_메시지가_표시되지_않는다`() {
        // given
        val password = "validPassword123"
        val passwordValidateResult = PasswordValidateResult.Success
        var passwordErrorMessage: String? = null

        composeTestRule.setContent {
            passwordErrorMessage = passwordValidateResult.toErrorMessage()
            AuthPasswordTextField(
                password = password,
                onPasswordChange = {},
                passwordValidateResult = passwordValidateResult
            )
        }

        // then
        onIdle()
        assert(passwordErrorMessage == null)
    }
}
