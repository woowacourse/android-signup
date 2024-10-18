package nextstep.signup

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.isNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.components.UsernameTextField
import nextstep.signup.state.InputValidationResult
import nextstep.signup.state.UsernameState
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UserNameValidationTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private var usernameState = mutableStateOf(UsernameState())

    @Before
    fun setup() {
        composeTestRule.setContent {
            UsernameTextField(
                value = usernameState.value.username,
                onValueChange = { usernameState.value = usernameState.value.copy(username = it) },
                label = "",
                inputValidationResult = InputValidationResult.Valid
            )
        }
    }

    @Test
    fun 사용자_이름은_빈값이면_에러메시지가_노출된다() {
        // when
        usernameState.value = usernameState.value.copy(username = "")

        // then
        composeTestRule
            .onNodeWithText(INPUT_LENGTH_ERROR)
            .isDisplayed()
    }

    @Test
    fun 사용자_이름은_2에서_5자여야_한다() {
        // when
        usernameState.value = usernameState.value.copy(username = "김컴포즈")

        // then
        composeTestRule
            .onNodeWithText(USERNAME_LENGTH_ERROR)
            .isNotDisplayed()
    }

    @Test
    fun 사용자_이름이_2에서_5자가_아니면_에러메시지가_노출된다() {
        // when
        usernameState.value = usernameState.value.copy("김컴포즈입니다")

        // then
        composeTestRule
            .onNodeWithText(USERNAME_LENGTH_ERROR)
            .isDisplayed()
    }

    @Test
    fun 사용자_이름은_영어나_한글여야_한다() {
        // when
        usernameState.value = usernameState.value.copy(username = "hi")

        // then
        composeTestRule
            .onNodeWithText(USERNAME_FORMAT_ERROR)
            .isNotDisplayed()
    }

    @Test
    fun 사용자_이름에_숫자가_있으면_에러메시지가_노출된다() {
        // when
        usernameState.value = usernameState.value.copy(username = "hi1")

        // then
        composeTestRule
            .onNodeWithText(USERNAME_FORMAT_ERROR)
            .isDisplayed()
    }

    @Test
    fun 사용자_이름에_기호가_있으면_에러메시지가_노출된다() {
        // when
        usernameState.value = usernameState.value.copy(username = "hi@")

        // then
        composeTestRule
            .onNodeWithText(USERNAME_FORMAT_ERROR)
            .isDisplayed()
    }

    companion object {
        private const val INPUT_LENGTH_ERROR = "필수 입력란 입니다."
        private const val USERNAME_LENGTH_ERROR = "이름은 2~5자여야 합니다."
        private const val USERNAME_FORMAT_ERROR = "이름에는 숫자나 기호가 포함될 수 없습니다."
    }
}
