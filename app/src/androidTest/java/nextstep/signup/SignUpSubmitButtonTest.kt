package nextstep.signup

import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.component.SignUpSubmitButton
import nextstep.signup.domain.validation.Email
import nextstep.signup.domain.validation.Password
import nextstep.signup.domain.validation.PasswordConfirm
import nextstep.signup.domain.validation.SignUpState
import nextstep.signup.domain.validation.Username
import org.junit.Rule
import org.junit.Test

class SignUpSubmitButtonTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 유효성_검사에_하나라도_실패하면_버튼이_비활성화_상태로_노출된다() {
        // given
        val invalidName = "k"
        val validEmail = "kshyun@naver.com"
        val validPassword = "1234567a"
        val validPasswordConfirm = "1234567a"
        val signUpState = SignUpState(
            username = Username(invalidName),
            email = Email(validEmail),
            password = Password(validPassword),
            passwordConfirm = PasswordConfirm(validPassword, validPasswordConfirm)
        )

        // when
        composeTestRule.setContent {
            SignUpSubmitButton(text = "sign up", onClick = { }, enabled = signUpState.isValid())
        }

        // then
        composeTestRule
            .onNodeWithText("sign up")
            .assertIsNotEnabled()
    }

    @Test
    fun 유효성_검사에_모두_통과하면_버튼이_활성화_상태로_노출된다() {
        // given
        val validName = "sang"
        val validEmail = "kshyun@naver.com"
        val validPassword = "1234567a"
        val validPasswordConfirm = "1234567a"
        val signUpState = SignUpState(
            username = Username(validName),
            email = Email(validEmail),
            password = Password(validPassword),
            passwordConfirm = PasswordConfirm(validPassword, validPasswordConfirm)
        )

        // when
        composeTestRule.setContent {
            SignUpSubmitButton(text = "sign up", onClick = { }, enabled = signUpState.isValid())
        }

        // then
        composeTestRule
            .onNodeWithText("sign up")
            .assertIsEnabled()
    }
}
