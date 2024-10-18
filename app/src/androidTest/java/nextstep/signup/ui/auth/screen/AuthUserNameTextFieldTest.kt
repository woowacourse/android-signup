package nextstep.signup.ui.auth.screen

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.espresso.Espresso.onIdle
import nextstep.signup.domain.UserNameValidateResult
import nextstep.signup.ui.auth.component.AuthUserNameTextField
import nextstep.signup.ui.auth.model.toErrorMessage
import org.junit.Rule
import org.junit.Test

class AuthUserNameTextFieldTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `2글자_이상_5글자_이하가_아니면_에러_메시지가_표시된다`() {
        // given
        val userName = "invalidName"
        val userNameValidateResult = UserNameValidateResult.InvalidOutOfLength
        var userNameErrorMessage: String? = null

        composeTestRule.setContent {
            userNameErrorMessage = userNameValidateResult.toErrorMessage()
            AuthUserNameTextField(
                userName = userName,
                onUserNameChange = {},
                userNameValidateResult = userNameValidateResult
            )
        }

        // then
        assert(userNameErrorMessage != null)
        composeTestRule.onNodeWithText(userNameErrorMessage.orEmpty())
            .assertExists()
    }

    @Test
    fun `숫자가_포함되면_에러_메시지가_표시된다`() {
        // given
        val userName = "in1"
        val userNameValidateResult = UserNameValidateResult.InvalidContainNumber
        var userNameErrorMessage: String? = null

        composeTestRule.setContent {
            userNameErrorMessage = userNameValidateResult.toErrorMessage()
            AuthUserNameTextField(
                userName = userName,
                onUserNameChange = {},
                userNameValidateResult = userNameValidateResult
            )
        }

        // then
        assert(userNameErrorMessage != null)
        composeTestRule.onNodeWithText(userNameErrorMessage.orEmpty())
            .assertExists()
    }

    @Test
    fun `특수문자가_포함되면_에러_메시지가_표시된다`() {
        // given
        val userName = "in$"
        val userNameValidateResult = UserNameValidateResult.InvalidContainSpecialCharacter
        var userNameErrorMessage: String? = null

        composeTestRule.setContent {
            userNameErrorMessage = userNameValidateResult.toErrorMessage()
            AuthUserNameTextField(
                userName = userName,
                onUserNameChange = {},
                userNameValidateResult = userNameValidateResult
            )
        }

        // then
        assert(userNameErrorMessage != null)
        composeTestRule.onNodeWithText(userNameErrorMessage.orEmpty())
            .assertExists()
    }

    @Test
    fun `유저_이름이_유효하면_에러_메시지가_표시되지_않는다`() {
        // given
        val userName = "Name"
        val userNameValidateResult = UserNameValidateResult.Success
        var userNameErrorMessage: String? = null

        composeTestRule.setContent {
            userNameErrorMessage = userNameValidateResult.toErrorMessage()
            AuthUserNameTextField(
                userName = userName,
                onUserNameChange = {},
                userNameValidateResult = userNameValidateResult
            )
        }

        // then
        onIdle()
        assert(userNameErrorMessage == null)
    }
}
