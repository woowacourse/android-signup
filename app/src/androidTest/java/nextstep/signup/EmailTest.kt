package nextstep.signup

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.ui.component.SignUpTextFieldComponent
import nextstep.signup.ui.model.Email
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class EmailTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val email = mutableStateOf("")

    @Before
    fun setup() {
        composeTestRule.setContent {
            SignUpTextFieldComponent(
                signUpModel = Email(text = email.value),
                onTextChange = { email.value = it },
                labelText = stringResource(R.string.email_label)
            )
        }
    }

    @Test
    fun 이메일이_빈_값일_때_Blank_상태를_반환한다() {
        email.value = ""
        composeTestRule
            .onNodeWithText(stringResource(R.string.email_label))
            .assertExists()
    }

    @Test
    fun 이메일_형식이_유효하지_않을_때_Email_에러를_반환한다() {
        email.value = "invalid_email"
        composeTestRule
            .onNodeWithText(stringResource(R.string.email_label))
            .assertExists()
    }

    @Test
    fun 이메일이_유효할_때_유효_상태인_Valid를_반환한다() {
        email.value = "test@example.com"
        composeTestRule
            .onNodeWithText(stringResource(R.string.email_label))
            .assertExists()
    }
}

