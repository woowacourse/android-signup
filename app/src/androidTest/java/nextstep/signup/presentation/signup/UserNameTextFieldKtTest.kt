package nextstep.signup.presentation.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UserNameTextFieldKtTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private var userNameContent by mutableStateOf("")

    @Before
    fun setup() {
        composeTestRule.setContent {
            UserNameTextField(
                name = userNameContent,
                onValueChange = { userNameContent = it }
            )
        }
    }

    @Test
    fun when_input_is_empty__no_invalid_length_error_message() {
        // when
        userNameContent = ""

        // then
        composeTestRule
            .onNodeWithText("이름은 2~5자여야 합니다.")
            .assertDoesNotExist()
    }

    @Test
    fun when_input_is_less_than_2_or_bigger_than_5__invalid_length_error_message_is_shown() {
        // when
        userNameContent = "qwertyu"

        // then
        composeTestRule
            .onNodeWithText("이름은 2~5자여야 합니다.")
            .assertExists()
    }

    @Test
    fun when_input_contains_number_or_symbol_invalid_format_error_message_is_shown() {
        // when
        userNameContent = "12w3"

        // then
        composeTestRule
            .onNodeWithText("이름에는 숫자나 기호가 포함될 수 없습니다.")
            .assertExists()
    }

    @Test
    fun when_input_is_valid_length_and_valid_format__no_invalid_error_message_is_shown() {
        // when
        userNameContent = "qwer"

        // then
        composeTestRule
            .onNodeWithText("이름은 2~5자여야 합니다.")
            .assertDoesNotExist()

        composeTestRule
            .onNodeWithText("이름에는 숫자나 기호가 포함될 수 없습니다.")
            .assertDoesNotExist()
    }
}
