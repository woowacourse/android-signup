package nextstep.signup.presentation.signup

import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

// TODO: 다시 해보려고 합니다.
class SignUpScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val button = SemanticsMatcher.expectValue(
        SemanticsProperties.Role, Role.Button
    )

    @Test
    fun signup_is_not_enabled_when_signup_input_is_initial() {
        // given
        composeTestRule.setContent {
            SignUpScreen(
                SignUpInput.intial
            )
        }

        // then
        composeTestRule
            .onNode(button)
            .assertIsNotEnabled()
    }


    @Test
    fun signup_is_not_enabled_when_email_is_invalid() {
        // given
        composeTestRule.setContent {
            SignUpScreen(
                SignUpInput(
                    username = "test",
                    email = "qwer@qwer",
                    password = "qwer12345",
                    passwordConfirm = "qwer12345",
                )
            )
        }

        // then
        composeTestRule
            .onNode(button)
            .assertIsNotEnabled()
    }

    @Test
    fun signup_is_enabled_when_signup_condition_is_satisfied() {
        // given
        composeTestRule.setContent {
            SignUpScreen(
                SignUpInput(
                    username = "test",
                    email = "qwer@qwer.com",
                    password = "qwer12345",
                    passwordConfirm = "qwer12345",
                )
            )
        }

        // then
        composeTestRule
            .onNode(button)
            .assertIsEnabled()
    }
}
