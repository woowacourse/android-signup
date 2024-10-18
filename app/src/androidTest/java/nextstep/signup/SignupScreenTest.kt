package nextstep.signup

import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import nextstep.signup.presentation.component.SignUpScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SignupScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup() {
        composeTestRule.setContent {
            SignUpScreen()
        }
    }

    @Test
    fun `텍스트_필드_중_유효하지_않은_것이_있으면_회원가입_버튼이_비활성화_상태이다`() {
        // when
        composeTestRule
            .onNodeWithText("Username")
            .performTextInput("알송")

        composeTestRule
            .onNodeWithText("Email")
            .performTextInput("alsong@naver.com")

        composeTestRule
            .onNodeWithText("Password")
            .performTextInput("alsong1234")

        composeTestRule
            .onNodeWithText("Password Confirm")
            .performTextInput("1234alsong")

        // then
        composeTestRule
            .onNodeWithText("Sign Up")
            .assertIsNotEnabled()
    }

    @Test
    fun `모든_텍스트_필드가_유효하면_회원가입_버튼이_활성화_상태이다`() {
        // when
        composeTestRule
            .onNodeWithText("Username")
            .performTextInput("알송")

        composeTestRule
            .onNodeWithText("Email")
            .performTextInput("alsong@naver.com")

        composeTestRule
            .onNodeWithText("Password")
            .performTextInput("alsong1234")

        composeTestRule
            .onNodeWithText("Password Confirm")
            .performTextInput("alsong1234")

        // then
        composeTestRule
            .onNodeWithText("Sign Up")
            .assertIsEnabled()
    }
}
