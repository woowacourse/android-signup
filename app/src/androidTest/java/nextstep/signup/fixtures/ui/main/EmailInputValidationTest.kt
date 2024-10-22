package nextstep.signup.fixtures.ui.main

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.R
import nextstep.signup.ui.component.SignUpField
import nextstep.signup.ui.model.Email
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class EmailInputValidationTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val email = mutableStateOf(Email())

    @Before
    fun setup() {
        composeTestRule.setContent {
            SignUpField(
                labelId = R.string.signup_email_label,
                value = email.value.value,
                onValueChange = { email.value = email.value.copy(value = it) },
                signUpResult = email.value.validation,
            )
        }
    }

    @Test
    fun `이메일_형식이_올바를_경우_에러메시지가_노출되지_않는다`() {
        // when
        email.value = Email(value = "seogi@seogida.com")

        // then
        composeTestRule
            .onNodeWithText(EMAIL_COMPOSITION_WARNING_MESSAGE)
            .assertDoesNotExist()
    }

    @Test
    fun `이메일_형식에_최상위_도메인이_없을_경우_에러메시지가_노출된다`() {
        // when
        email.value = Email(value = "seogi@seogida")

        // then
        composeTestRule
            .onNodeWithText(EMAIL_COMPOSITION_WARNING_MESSAGE)
            .assertExists()
    }

    @Test
    fun `이메일_형식에_도메인이_없을_경우_에러메시지가_노출된다`() {
        // when
        email.value = Email(value = "seogi.com")

        // then
        composeTestRule
            .onNodeWithText(EMAIL_COMPOSITION_WARNING_MESSAGE)
            .assertExists()
    }

    companion object {
        private const val EMAIL_COMPOSITION_WARNING_MESSAGE = "이메일 형식이 올바르지 않습니다."
    }
}
