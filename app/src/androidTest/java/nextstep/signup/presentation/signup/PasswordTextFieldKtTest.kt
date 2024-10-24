package nextstep.signup.presentation.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PasswordTextFieldKtTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private var passwordContent by mutableStateOf("")

    @Before
    fun setUp() {
        composeTestRule.setContent {
            PasswordTextField(
                modifier = Modifier.testTag("test"),
                password = passwordContent,
                onValueChange = { passwordContent = it }
            )
        }
    }

    @Test
    fun when_input_is_empty__no_invalid_length_error_message() {
        // when
        passwordContent = ""

        // then
        composeTestRule
            .onNodeWithText("비밀번호는 8~16자여야 합니다.")
            .assertDoesNotExist()

        composeTestRule
            .onNodeWithText("비밀번호는 영문과 숫자를 포함해야 합니다.")
            .assertDoesNotExist()
    }

    @Test
    fun when_input_is_less_than_8_or_greater_than_16__invalid_length_error_is_shown() {
        // when
        passwordContent = "qwer123"

        // then
        composeTestRule
            .onNodeWithText("비밀번호는 8~16자여야 합니다.")
            .assertExists()
    }

    @Test
    fun when_input_is_less_than_8_or_greater_than_16__invalid_format_error_is_shown() {
        // when
        passwordContent = "qwer123"

        // then
        composeTestRule
            .onNodeWithText("비밀번호는 8~16자여야 합니다.")
            .assertExists()
    }
}
