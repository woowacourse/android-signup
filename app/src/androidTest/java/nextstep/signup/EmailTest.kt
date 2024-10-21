package nextstep.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.ui.component.SignUpTextFieldComponent
import nextstep.signup.ui.model.Email
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class EmailTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private var email by mutableStateOf(Email())

    private var errorEmail = ""

    @Before
    fun setup() {
        composeTestRule.setContent {
            errorEmail = stringResource(R.string.error_email)

            SignUpTextFieldComponent(
                signUpModel = email,
                onTextChange = { email = Email(it) },
                labelText = stringResource(R.string.email_label)
            )
        }
    }

    @Test
    fun 이메일이_빈_값일_때_Blank_상태를_반환한다() {
        email = Email("")
        composeTestRule
            .onAllNodesWithText("")
            .assertCountEquals(2)
    }

    @Test
    fun 이메일이_유효하지_않을_때_Email_에러를_반환한다() {
        email = Email("invalid_email")
        composeTestRule
            .onNodeWithText(errorEmail)
            .assertExists()
    }

    @Test
    fun 이메일이_형식이_유효하지_않을_때_Email_에러를_반환한다() {
        email = Email("test@examplecom")
        composeTestRule
            .onNodeWithText(errorEmail)
            .assertExists()
    }
}
