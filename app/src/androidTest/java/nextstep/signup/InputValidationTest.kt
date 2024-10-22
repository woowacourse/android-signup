package nextstep.signup

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.ui.Validator.getUserNameError
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class InputValidationTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val userName = mutableStateOf("")
    private val userNameError = mutableStateOf("")

    @Before
    fun setUp() {
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
    }

    @Test
    fun username_with_exactly_2_characters_shows_no_error() {
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
