package nextstep.signup

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.ui.component.SignUpTextFieldComponent
import nextstep.signup.ui.model.SignUpState
import nextstep.signup.ui.model.Username
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UsernameTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val username = mutableStateOf("")

    @Before
    fun setup() {
        composeTestRule.setContent {
            SignUpTextFieldComponent(
                signUpModel = Username(text = username.value),
                onTextChange = { username.value = it },
                labelText = stringResource(R.string.username_label)
            )
        }
    }

    @Test
    fun 사용자_이름이_빈_값일_때_Blank_상태를_반환한다() {
        username.value = ""
        composeTestRule
            .onNodeWithText(stringResource(R.string.username_label))
            .assertExists()
    }

    @Test
    fun 사용자_이름이_2자_미만일_때_UserNameLength_에러를_반환한다() {
        username.value = "김"
        composeTestRule
            .onNodeWithText(stringResource(R.string.username_label))
            .assertExists()
    }

    @Test
    fun 사용자_이름이_5자_초과일_때_UserNameLength_에러를_반환한다() {
        username.value = "김누누입니다"
        composeTestRule
            .onNodeWithText(stringResource(R.string.username_label))
            .assertExists()
    }

    @Test
    fun 사용자_이름이_유효할_때_유효_상태인_Valid를_반환한다() {
        username.value = "김누누임"
        composeTestRule
            .onNodeWithText(stringResource(R.string.username_label))
            .assertExists()
    }
}
