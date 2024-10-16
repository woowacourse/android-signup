package nextstep.signup

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CheckerTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private val checked: MutableState<Boolean> = mutableStateOf(false)

    @Before
    fun setup() {
        composeTestRule.setContent {
            CheckerView(onCheckedChange = {}, checked = checked.value)
        }
    }

    @Test
    fun 체크박스_체크되지_않았으면_텍스트_미노출() {
        // when
        checked.value = false

        // then
        composeTestRule
            .onNodeWithText("체크됨!!!")
            .assertDoesNotExist()
    }

    @Test
    fun 체크박스_체크되면_텍스트_노출() {
        // when
        checked.value = true

        // then
        composeTestRule
            .onNodeWithText("체크됨!!!")
            .assertExists()
    }
}
