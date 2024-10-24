package nextstep.signup

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.ui.validation.CompositeValidation
import nextstep.signup.ui.validation.LengthValidation
import nextstep.signup.ui.validation.RegexValidation
import nextstep.signup.ui.signup.UsernameTextField
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class UserNameValidationTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private val username = mutableStateOf("")

    @Before
    fun setup() {
        val userNameLengthValidation =
            LengthValidation(2..5)
        val characterValidation = RegexValidation(
            "[a-zA-Z가-힣]+".toRegex()
        )
        val userNameValidation = CompositeValidation(userNameLengthValidation, characterValidation)
        composeTestRule.setContent {
            UsernameTextField(
                username = username,
                validation = userNameValidation,
            )
        }
    }

    @Test
    fun 사용자_이름은_2에서_5자여야_한다() {
        // when
        username.value = "김컴포즈"

        // then
        composeTestRule
            .onNodeWithText(USERNAME_LENGTH_ERROR)
            .assertDoesNotExist()
    }

    @Test
    fun 사용자_이름이_2에서_5자가_아니면_에러메시지가_노출된다() {
        // when
        username.value = "김컴포즈입니다"

        // then
        composeTestRule
            .onNodeWithText(USERNAME_LENGTH_ERROR)
            .assertExists()
    }

    @Test
    fun 사용자의_이름은_한글이거나_영어여야_한다() {
        // when
        username.value = "%%#@!"

        //then
        composeTestRule
            .onNodeWithText(USERNAME_CHARACTER_ERROR)
            .assertExists()
    }

    companion object {
        private const val USERNAME_LENGTH_ERROR = "이름은 2~5자여야 합니다."
        private const val USERNAME_CHARACTER_ERROR = "이름에는 숫자나 기호가 포함될 수 없습니다."
    }
}





