package nextstep.signup.ui.auth.screen

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.espresso.Espresso.onIdle
import nextstep.signup.domain.PasswordConfirmValidateResult
import nextstep.signup.ui.auth.component.AuthPasswordConfirmTextField
import nextstep.signup.ui.auth.model.toErrorMessage
import org.junit.Rule
import org.junit.Test

class AuthPasswordConfirmTextFieldTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `비밀번호_확인이_유효하지_않으면_에러_메시지가_표시된다`() {
        // given
        val passwordConfirm = "password123"
        val passwordConfirmValidateResult = PasswordConfirmValidateResult.InValid
        var passwordConfirmErrorMessage: String? = null

        composeTestRule.setContent {
            passwordConfirmErrorMessage = passwordConfirmValidateResult.toErrorMessage()
            AuthPasswordConfirmTextField(
                passwordConfirm = passwordConfirm,
                onPasswordConfirmChange = {},
                passwordConfirmValidateResult = passwordConfirmValidateResult
            )
        }

        // then
        assert(passwordConfirmErrorMessage != null)
        composeTestRule.onNodeWithText(passwordConfirmErrorMessage.orEmpty())
            .assertExists()
    }

    @Test
    fun `비밀번호_확인이_유효하면_에러_메시지가_표시되지_않는다`() {
        // given
        val passwordConfirm = "password123"
        val passwordConfirmValidateResult = PasswordConfirmValidateResult.Success
        var passwordConfirmErrorMessage: String? = null

        composeTestRule.setContent {
            passwordConfirmErrorMessage = passwordConfirmValidateResult.toErrorMessage()
            AuthPasswordConfirmTextField(
                passwordConfirm = passwordConfirm,
                onPasswordConfirmChange = {},
                passwordConfirmValidateResult = passwordConfirmValidateResult
            )
        }

        // then
        onIdle()
        assert(passwordConfirmErrorMessage == null)
    }
}