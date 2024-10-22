package nextstep.signup

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.ui.Validator.getUserNameError
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class InputValidationTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private var userName = ""
    private var userNameError = ""

    @Before
    fun setUp() {
        composeTestRule.setContent {
            TestFixture.InitializeStrings()

            TestFixture.TestCustomTextField(
                valueState = userName,
                errorState = userNameError,
                label = TestFixture.USERNAME_LABEL,
                onValueChange = {
                    userNameError = getUserNameError(
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
            userName = "길동"
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
            userName = "김철수김"
        }

        // then
        composeTestRule
            .onNodeWithText(TestFixture.USERNAME_LENGTH_ERROR)
            .assertDoesNotExist()
    }
}
