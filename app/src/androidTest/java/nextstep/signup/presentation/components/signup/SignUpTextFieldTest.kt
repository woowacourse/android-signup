package nextstep.signup.presentation.components.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import nextstep.signup.domain.Email
import nextstep.signup.domain.Error
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SignUpTextFieldTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private val email = mutableStateOf(Email())

    @Test
    fun SignUpTextField의_label과_value값을_정상적으로_표시된다() {
        email.value = Email("test@example.com")

        composeTestRule.setContent {
            SignUpTextField(
                value = email.value.address,
                onValueChange = {},
                label = "Email",
                errorMessage = email.value.errorMessage()?.message ?: ""
            )
        }

        composeTestRule
            .onNodeWithText("test@example.com")
            .assertExists()

        composeTestRule
            .onNodeWithText("Email")
            .assertExists()
    }

    // 에러메세지가 보여지지 않는 경우
    @Test
    fun 에러메세지가_없다면_에러메세지가_뜨지_않는다() {
        email.value = Email("test@example.com")

        composeTestRule.setContent {
            SignUpTextField(
                value = email.value.address,
                onValueChange = {},
                label = "Email",
                errorMessage = email.value.errorMessage()?.message ?: ""
            )
        }

        composeTestRule
            .onNodeWithText(Error.INVALID_EMAIL.message)
            .assertDoesNotExist()
    }

    @Test
    fun 에러메세지가_존재하면_에러메세지를_보여준다() {
        composeTestRule.setContent {
            SignUpTextField(
                value = "",
                onValueChange = {},
                label = "",
                errorMessage = "Invalid email format"
            )
        }

        composeTestRule
            .onNodeWithText("Invalid email format")
            .assertExists()
    }
}
