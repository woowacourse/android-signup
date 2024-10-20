package nextstep.signup.presentation.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class EmailTextFieldKtTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private var emailContent by mutableStateOf("")

    @Before
    fun setup() {
        composeTestRule.setContent {
            EmailTextField(
                email = emailContent,
                onValueChange = { emailContent = it }
            )
        }
    }

    @Test
    fun when_input_is_empty__no_invalid_length_error_message() {
        // when
        emailContent = ""

        // then
        composeTestRule
            .onNodeWithText("이메일 형식이 올바르지 않습니다.")
            .assertDoesNotExist()
    }

    @Test
    fun when_email_input_is_invalid_format__invalid_format_error_message_is_shown() {
        // when
        emailContent = "qwe@cc"

        // then
        composeTestRule
            .onNodeWithText("이메일 형식이 올바르지 않습니다.")
            .assertExists()
    }

    @Test
    fun when_email_input_is_valid_format__no_error_message_is_shown() {
        // when
        emailContent = "qwer@wooteco.com"

        // then
        composeTestRule
            .onNodeWithText("이메일 형식이 올바르지 않습니다.")
            .assertDoesNotExist()
    }
}
