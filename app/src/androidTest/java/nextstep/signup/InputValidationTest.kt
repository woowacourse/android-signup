package nextstep.signup

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class InputValidationTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun username_with_exactly_2_characters_shows_no_error() {
        // given
        val userName = mutableStateOf("")
        val userNameError = mutableStateOf("")

        composeTestRule.setContent {
            TestFixture.TestCustomTextField(
                valueState = userName,
                errorState = userNameError,
                label = "Username",
                onValueChange = {
                    userNameError.value = getUserNameError(
                        it,
                        TestFixture.USERNAME_LENGTH_ERROR,
                        TestFixture.USERNAME_FORMAT_ERROR
                    )
                }
            )
        }

        // when
        composeTestRule.runOnUiThread {
            userName.value = "길동"
        }

        // then
        composeTestRule
            .onNodeWithText(TestFixture.USERNAME_LENGTH_ERROR)
            .assertDoesNotExist()
    }


    @Test
    fun username_with_exactly_5_characters_shows_no_error() {
        // given
        val userName = mutableStateOf("")
        val userNameError = mutableStateOf("")

        composeTestRule.setContent {
            TestFixture.TestCustomTextField(
                valueState = userName,
                errorState = userNameError,
                label = "Username",
                onValueChange = {
                    userNameError.value = getUserNameError(
                        it,
                        TestFixture.USERNAME_LENGTH_ERROR,
                        TestFixture.USERNAME_FORMAT_ERROR
                    )
                }
            )
        }

        // when
        composeTestRule.runOnUiThread {
            userName.value = "김철수김"
        }

        // then
        composeTestRule
            .onNodeWithText(TestFixture.USERNAME_LENGTH_ERROR)
            .assertDoesNotExist()
    }
}
