package nextstep.signup.fixtures.ui.main

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.R
import nextstep.signup.ui.component.SignUpField
import nextstep.signup.ui.model.UserName
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UserNameInputValidationTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val userName = mutableStateOf(UserName())

    @Before
    fun setup() {
        composeTestRule.setContent {
            SignUpField(
                labelId = R.string.signup_username_label,
                value = userName.value.value,
                onValueChange = { userName.value = userName.value.copy(value = it) },
                signUpResult = userName.value.validation,
            )
        }
    }

    @Test
    fun `사용자_이름은_2에서_5자여야_한다`() {
        // when
        userName.value = UserName(value = "남서기")

        // then
        composeTestRule
            .onNodeWithText(USERNAME_LENGTH_ERROR)
            .assertDoesNotExist()
    }

    @Test
    fun `사용자_이름이_2자_미만일_경우_에러메시지가_노출된다`() {
        // when
        userName.value = UserName(value = "남")

        // then
        composeTestRule
            .onNodeWithText(USERNAME_LENGTH_ERROR)
            .assertExists()
    }

    @Test
    fun `사용자_이름이_5자를_넘을_경우_에러메시지가_노출된다`() {
        // when
        userName.value = UserName(value = "남서기입니다")

        // then
        composeTestRule
            .onNodeWithText(USERNAME_LENGTH_ERROR)
            .assertExists()
    }

    @Test
    fun `사용자_이름은_숫자나_기호가_아닌_문자로_구성되어야_한다`() {
        // when
        userName.value = UserName(value = "abcde")

        // then
        composeTestRule
            .onNodeWithText(USERNAME_LENGTH_ERROR)
            .assertDoesNotExist()
    }

    @Test
    fun `사용자_이름에_숫자가_있으면_에러메시지가_노출된다`() {
        // when
        userName.value = UserName(value = "abcd1")

        // then
        composeTestRule
            .onNodeWithText(USERNAME_COMPOSITION_ERROR)
            .assertExists()
    }

    @Test
    fun `사용자_이름에_기호가_있으면_에러메시지가_노출된다`() {
        // when
        userName.value = UserName(value = "@bcde")

        // then
        composeTestRule
            .onNodeWithText(USERNAME_COMPOSITION_ERROR)
            .assertExists()
    }

    companion object {
        private const val USERNAME_LENGTH_ERROR = "이름은 2~5자여야 합니다."
        private const val USERNAME_COMPOSITION_ERROR = "이름에는 숫자나 기호가 포함될 수 없습니다."
    }
}
