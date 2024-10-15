package nextstep.signup.presentation.components.signup

import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.signup.fixture.signUpFixture
import org.junit.Rule
import org.junit.Test

class SignUpFormTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 모든_입력이_정상적이면_SignUp_버튼이_활성화된다() {
        // given & when
        composeTestRule.setContent {
            SignUpForm(
                signUpData = signUpFixture,
                onDataChange = {}
            )
        }

        // then
        composeTestRule
            .onNodeWithText("Sign Up")
            .assertIsEnabled()
    }

    @Test
    fun 입력값이_하나라도_비정상이면_SignUp_버튼이_비활성화된다() {
        // given & when
        composeTestRule.setContent {
            SignUpForm(
                signUpData = signUpFixture.copy(username = signUpFixture.username.copy(name = "")),
                onDataChange = {}
            )
        }

        // then
        composeTestRule
            .onNodeWithText("Sign Up")
            .assertIsNotEnabled()
    }

    @Test
    fun SignUp_버튼을_누르면_스낵바가_표시된다() {
        // given & when
        composeTestRule.setContent {
            SignUpForm(
                signUpData = signUpFixture,
                onDataChange = {},
                onClick = {}
            )
        }

        // then
        composeTestRule
            .onNodeWithText("Sign Up")
            .performClick()

        composeTestRule
            .onNodeWithText("회원가입 완료")
            .assertExists()
    }
}
