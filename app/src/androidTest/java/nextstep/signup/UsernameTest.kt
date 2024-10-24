package nextstep.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.ui.component.SignUpTextFieldComponent
import nextstep.signup.ui.model.Username
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UsernameTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private var username by mutableStateOf(Username())
    private var errorUsernameLength = ""
    private var errorUsernameType = ""

    @Before
    fun setup() {
        composeTestRule.setContent {
            errorUsernameLength = stringResource(R.string.error_username_length)
            errorUsernameType = stringResource(R.string.error_username_type)

            SignUpTextFieldComponent(
                signUpModel = username,
                onTextChange = { username = Username(it) },
                labelText = stringResource(R.string.username_label)
            )
        }
    }

    @Test
    fun 사용자_이름이_빈_값일_때_Blank_메시지를_표시한다() {
        username = Username("")
        composeTestRule
            .onAllNodesWithText("")
    }

    @Test
    fun 사용자_이름이_2자_미만일_때_UserNameLength_에러_메시지를_표시한다() {
        username = Username("김")
        composeTestRule
            .onNodeWithText(errorUsernameLength)
            .assertExists()
    }

    @Test
    fun 사용자_이름이_5자_초과일_때_UserNameLength_에러_메시지를_표시한다() {
        username = Username("김누누입니다")
        composeTestRule
            .onNodeWithText(errorUsernameLength)
            .assertExists()
    }
}
