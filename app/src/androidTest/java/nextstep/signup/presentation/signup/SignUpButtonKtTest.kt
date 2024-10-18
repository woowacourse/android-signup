package nextstep.signup.presentation.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import nextstep.signup.domain.Email
import nextstep.signup.domain.Password
import nextstep.signup.domain.PasswordConfirm
import nextstep.signup.domain.SignUp
import nextstep.signup.domain.SignUpResult
import nextstep.signup.domain.UserName
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SignUpButtonKtTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private var signUpResult: SignUpResult by mutableStateOf(SignUpResult.Initial)

    @Before
    fun setUp() {
        composeTestRule.setContent {
            SignUpButton(
                signUpResult = signUpResult,
                modifier = Modifier.testTag("test")
            )
        }
    }

    @Test
    fun when_signup_is_initial___button_is_not_enabled() {
        // when
        signUpResult = SignUpResult.Initial

        // then
        composeTestRule
            .onNodeWithTag("test")
            .assertIsNotEnabled()
    }

    @Test
    fun when_signup_is_failure___button_is_not_enabled() {
        // when
        signUpResult = SignUpResult.Failure

        // then
        composeTestRule
            .onNodeWithTag("test")
            .assertIsNotEnabled()
    }

    @Test
    fun when_signup_is_success___button_is__enabled() {
        // when
        signUpResult = SignUpResult.Success(
            signUp = SignUp(
                userName = UserName("qwer"),
                email = Email("qwer@wooteco.com"),
                password = Password("qwer12345"),
                passwordConfirm = PasswordConfirm("qwer12345")
            )
        )

        // then
        composeTestRule
            .onNodeWithTag("test")
            .assertIsEnabled()
    }
}
