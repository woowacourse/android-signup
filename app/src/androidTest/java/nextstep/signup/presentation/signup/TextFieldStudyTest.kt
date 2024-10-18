package nextstep.signup.presentation.signup

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.domain.UserName
import org.junit.Before
import org.junit.Rule
import org.junit.Test

// study
class TextFieldStudyTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private var userNameContent by mutableStateOf("")

    @Before
    fun setup() {
        composeTestRule.setContent {
            val userNameEmpty = userNameContent.isEmpty()
            val userNameLengthError = userNameContent.length !in 2..5
            val userNameFormatError = !userNameContent.matches(UserName.regex)
            val isError = !userNameEmpty && userNameLengthError

            TextField(
                value = userNameContent,
                onValueChange = { userNameContent = it },
                isError = isError,
                supportingText = {
                    if (userNameEmpty) return@TextField
                    if (userNameLengthError) Text(text = "이름은 2~5자여야 합니다.")
                    if (userNameFormatError) Text(text = "이름에는 숫자나 기호가 포함될 수 없습니다.")
                }
            )
        }
    }

    @Test
    fun 사용자_이름이_2에서_5자가_아니면_에러메시지가_노출된다_5자_초과일_때() {
        // when
        userNameContent = "abcdefg"

        // then
        composeTestRule
            .onNodeWithText("이름은 2~5자여야 합니다.")
            .assertExists()
    }

    @Test
    fun 사용자_이름이_2에서_5자가_아니면_에러메시지가_노출된다_2자_미만일_떄() {
        // when
        userNameContent = "a"

        // then
        composeTestRule
            .onNodeWithText("이름은 2~5자여야 합니다.")
            .assertExists()
    }

    @Test
    fun 사용자_이름은_2에서_5자여야_한다() {
        // when
        userNameContent = "abc"

        // then
        composeTestRule
            .onNodeWithText("이름은 2~5자여야 합니다.")
            .assertDoesNotExist()
    }

    @Test
    fun 사용자_이름에_숫자가_들어가면_에러_메시지() {
        // when
        userNameContent = "1234"

        // then
        composeTestRule
            .onNodeWithText("이름에는 숫자나 기호가 포함될 수 없습니다.")
            .assertExists()
    }
}
