package nextstep.signup.ui.auth.screen

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.espresso.Espresso.onIdle
import nextstep.signup.domain.UserNameValidateResult
import nextstep.signup.ui.auth.component.AuthUserNameTextField
import nextstep.signup.ui.auth.component.toErrorMessage
import org.junit.Rule
import org.junit.Test

class AuthUserNameTextFieldTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `2글자_이상_5글자_이하가_아니면_에러_메시지가_표시된다`() {
        // given
        val userName = "invalidName"
        var userNameErrorMessage: String? = null

        composeTestRule.setContent {
            userNameErrorMessage = UserNameValidateResult.InvalidOutOfLength.toErrorMessage()
            AuthUserNameTextField(
                userName = userName,
                onUserNameChange = {},
            )
        }

        // then
        onIdle()
        assert(userNameErrorMessage != null)
        composeTestRule.onNodeWithText(userNameErrorMessage.orEmpty())
            .assertExists()
    }

    @Test
    fun `숫자가_포함되면_에러_메시지가_표시된다`() {
        // given
        val userName = "in1"
        var userNameErrorMessage: String? = null

        composeTestRule.setContent {
            userNameErrorMessage = UserNameValidateResult.InvalidContainNumber.toErrorMessage()
            AuthUserNameTextField(
                userName = userName,
                onUserNameChange = {},
            )
        }

        // then
        onIdle()
        assert(userNameErrorMessage != null)
        composeTestRule.onNodeWithText(userNameErrorMessage.orEmpty())
            .assertExists()
    }

    @Test
    fun `특수문자가_포함되면_에러_메시지가_표시된다`() {
        // given
        val userName = "in$"
        var userNameErrorMessage: String? = null

        composeTestRule.setContent {
            userNameErrorMessage =
                UserNameValidateResult.InvalidContainSpecialCharacter.toErrorMessage()
            AuthUserNameTextField(
                userName = userName,
                onUserNameChange = {},
            )
        }

        // then
        onIdle()
        assert(userNameErrorMessage != null)
        composeTestRule.onNodeWithText(userNameErrorMessage.orEmpty())
            .assertExists()
    }

    @Test
    fun `유저_이름이_유효하면_에러_메시지가_표시되지_않는다`() {
        // given
        val userName = "Name"
        var userNameErrorMessage: String? = null

        composeTestRule.setContent {
            userNameErrorMessage = UserNameValidateResult.Success.toErrorMessage()
            AuthUserNameTextField(
                userName = userName,
                onUserNameChange = {},
            )
        }

        // then
        onIdle()
        assert(userNameErrorMessage == null)
    }
}
