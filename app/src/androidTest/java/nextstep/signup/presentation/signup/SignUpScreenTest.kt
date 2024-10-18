package nextstep.signup.presentation.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SignUpScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private var userNameContent by mutableStateOf("")
    private var emailContent by mutableStateOf("")
    private var passwordContent by mutableStateOf("")
    private var passwordContentContent by mutableStateOf("")

    @Before
    fun setUp() {
        composeTestRule.setContent {
            SignUpScreen()
        }
    }

    // username 이 공백이면 회원가입 불가능
    @Test
    fun signup_is_not_enabled_when_signup_condition_is_not_satisfied() {
        // given
        composeTestRule.setContent {
        }

        // then
        composeTestRule.onNode(hasText("Sign Up")).assertIsNotEnabled()
    }

    @Test
    fun signup_is_enabled_when_signup_condition_is_satisfied() {
        // given
        composeTestRule.setContent {
// //            SignUpScreen3(
// //                initialSignUp = SignUp3(
// //                    userName = UserName("악어"),
// //                    email = Email(
// //                        EmailId("sh1mj1"),
// //                        EmailDomain("wooteco.com")
// //                    ),
// //                    password = Password3(
// //                        password = "1234",
// //                        passwordConfirm = "1234"
// //                    )
// //                )
//            )
        }

        // then
        composeTestRule.onNode(hasText("Sign Up")).assertIsEnabled()
    }
}
