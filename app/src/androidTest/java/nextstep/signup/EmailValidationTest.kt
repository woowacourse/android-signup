package nextstep.signup

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.isNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.components.EmailTextField
import nextstep.signup.state.EmailState
import nextstep.signup.state.InputValidationResult
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class EmailValidationTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private var emailState = mutableStateOf(EmailState())

    @Before
    fun setup() {
        composeTestRule.setContent {
            EmailTextField(
                email = emailState.value.email,
                onValueChange = { emailState.value = emailState.value.copy(email = it) },
                label = "",
                inputValidationResult = InputValidationResult.Valid
            )
        }
    }

    @Test
    fun 이메일은_빈값이면_에러메시지가_노출된다() {
        // when
        emailState.value = emailState.value.copy(email = "")

        // then
        composeTestRule
            .onNodeWithText(INPUT_LENGTH_ERROR)
            .isDisplayed()
    }

    @Test
    fun 이메일은_이메일_형식여야_한다() {
        // when
        emailState.value = emailState.value.copy(email = "hello@naver.com")

        // then
        composeTestRule
            .onNodeWithText(EMAIL_FORMAT_ERROR)
            .isNotDisplayed()
    }

    @Test
    fun 이메일은_이메일_형식이_아니면_에러메시지가_노출된다() {
        // when
        emailState.value = emailState.value.copy(email = "hello")

        // then
        composeTestRule
            .onNodeWithText(EMAIL_FORMAT_ERROR)
            .isDisplayed()
    }

    companion object {
        private const val INPUT_LENGTH_ERROR = "필수 입력란 입니다."
        private const val EMAIL_FORMAT_ERROR = "이메일 형식이 올바르지 않습니다."
    }
}
