package nextstep.signup.ui

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.signup.ui.model.UserForm
import org.junit.Rule
import org.junit.Test

class SignUpScreenSnackbarTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private lateinit var userForm: UserForm

    @Test
    fun formValid_signUpButtonPressed_showsSnackbar() {
        // given
        userForm =
            UserForm(
                username = "abcde",
                email = "kmkim@pengcook.com",
                password = "abcd1234",
                passwordConfirmation = "abcd1234",
            )

        composeTestRule.setContent {
            SignUpScreen(userForm = userForm)
        }

        // when
        composeTestRule
            .onNodeWithText("Sign Up")
            .performClick()

        // then
        composeTestRule
            .onNode(
                matcher = hasText("회원가입이 완료되었습니다."),
                useUnmergedTree = true
            )
            .assertIsDisplayed()
    }

    @Test
    fun formInvalid_signUpButtonPressed_doesNotShowSnackbar() {
        // given
        userForm =
            UserForm(
                username = "abcde",
                email = "kmkim@pengcook.com",
                password = "abcd1234",
                passwordConfirmation = "abcd1235",
            )

        composeTestRule.setContent {
            SignUpScreen(userForm = userForm)
        }

        // when
        composeTestRule
            .onNodeWithText("Sign Up")
            .performClick()

        // then
        composeTestRule
            .onNode(
                matcher = hasText("회원가입이 완료되었습니다."),
                useUnmergedTree = true
            )
            .assertIsNotDisplayed()
    }
}
