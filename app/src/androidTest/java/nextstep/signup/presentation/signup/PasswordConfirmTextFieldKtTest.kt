package nextstep.signup.presentation.signup

import androidx.compose.runtime.Composable
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

class PasswordConfirmTextFieldKtTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private var passwordContent by mutableStateOf("")
    private var passwordConfirmContent by mutableStateOf("")

    private var count = 0

    @Before
    fun setUp() {
        composeTestRule.setContent {
            PasswordConfirmTextField(
                modifier = Modifier.testTag("test"),
                password = passwordContent,
                passwordConfirm = passwordConfirmContent,
                onValueChange = { passwordConfirmContent = it }
            )
        }
    }

    @Test
    fun when_passwordConfirm_input_is_empty__no_error_message() {
        // when
        passwordContent = "qwer12345"
        passwordConfirmContent = ""

        // then
        composeTestRule
            .onNodeWithText("비밀번호가 일치하지 않습니다.")
            .assertDoesNotExist()
    }

    @Test
    fun when_passwordConfirm_input_is_not_same_with_password_input__not_same_error_is_shown() {
        // when
        passwordContent = "qwer12345"
        passwordConfirmContent = "qwer1234"

        // then
        composeTestRule
            .onNodeWithText("비밀번호가 일치하지 않습니다.")
            .assertExists()
    }

    @Composable
    fun RecompositionTestPasswordConfirmTextField(
        modifier: Modifier = Modifier,
        passwordContent: String,
        passwordConfirmContent: String
    ) {
        val passwordConfirmIsEmpty = (passwordConfirmContent.isNotEmpty()).also { count++ }

        PasswordConfirmTextField(
            password = passwordContent,
            passwordConfirm = passwordConfirmContent,
            onValueChange = {}

        )
    }

    @Test
    fun recomposition() {
        // given
        composeTestRule.setContent {
            PasswordConfirmTextField(
                modifier = Modifier.testTag("test"),
                password = passwordContent,
                passwordConfirm = passwordConfirmContent,
                onValueChange = { passwordConfirmContent = it }
            )
        }

        passwordContent = "qwer1234"
        count = 0

        // when

        // then
    }
}
