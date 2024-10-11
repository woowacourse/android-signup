package nextstep.signup.presentation.signup

import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import nextstep.signup.domain.Email
import nextstep.signup.domain.EmailDomain
import nextstep.signup.domain.EmailId
import nextstep.signup.domain.Password
import nextstep.signup.domain.SignUp
import nextstep.signup.domain.UserName
import org.junit.Rule
import org.junit.Test

class SignUpScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    // username 이 공백이면 회원가입 불가능
    @Test
    fun signup_is_enabled_when_signup_condition_is_not_satisfied() {
        // given
        composeTestRule.setContent {
            SignUpScreen(initialSignUp = SignUp.INITIAL)
        }

        // then
        composeTestRule.onNode(hasText("Sign Up")).assertIsNotEnabled()
    }

    @Test
    fun signup_is_enabled_when_signup_condition_is_satisfied() {
        // given
        composeTestRule.setContent {
            SignUpScreen(
                initialSignUp = SignUp(
                    userName = UserName("악어"),
                    email = Email(
                        EmailId("sh1mj1"),
                        EmailDomain("wooteco.com")
                    ),
                    password = Password(
                        password = "1234",
                        passwordConfirm = "1234"
                    )
                )
            )
        }

        // then
        composeTestRule.onNode(hasText("Sign Up")).assertIsEnabled()
    }
}
