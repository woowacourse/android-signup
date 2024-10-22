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
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SignUpButtonKtTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private var signUpIsEnabled: Boolean by mutableStateOf(false)

    @Before
    fun setUp() {
        composeTestRule.setContent {
            SignUpButton(
                enabled = signUpIsEnabled,
                modifier = Modifier.testTag("test")
            )
        }
    }

    @Test
    fun when_signup_is_failure___button_is_not_enabled() {
        // when
        signUpIsEnabled = false

        // then
        composeTestRule
            .onNodeWithTag("test")
            .assertIsNotEnabled()
    }

    @Test
    fun when_signup_is_success___button_is__enabled() {
        // when
        signUpIsEnabled = true

        // then
        composeTestRule
            .onNodeWithTag("test")
            .assertIsEnabled()
    }
}
