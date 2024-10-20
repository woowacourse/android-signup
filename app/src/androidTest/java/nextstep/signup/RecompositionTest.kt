package nextstep.signup

import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class RecompositionTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private val username = mutableStateOf("")
    private val other = mutableStateOf("")
    private var count = 0

    @Before
    fun setup() {
        count = 0
    }

    @Composable
    private fun TestTextField(
        username: String,
        other: String
    ) {
        val usernameLengthError = (username.length !in 2..5).also { count++ }
        TextField(
            value = username,
            onValueChange = { },
            isError = usernameLengthError
        )
    }

    @Composable
    private fun TestTextFieldWithRemember(
        username: String,
        other: String
    ) {
        val usernameLengthError = remember(username) {
            (username.length !in 2..5).also { count++ }
        }
        TextField(
            value = username,
            onValueChange = { },
            isError = usernameLengthError
        )
    }

    @Test
    fun 리컴포지션될때_매번_유효성_검사() {
        // given
        composeTestRule.setContent {
            TestTextField(username = username.value, other = other.value)
        }
        count = 0

        // when
        username.value = "김컴포즈"
        composeTestRule.waitForIdle()
        // then
        assert(count == 1)

        // when
        other.value = "다른 값"
        composeTestRule.waitForIdle()
        // then
        assert(count == 2)
    }

    @Test
    fun 특정_값_변경시만_유효성_검사() {
        // given
        composeTestRule.setContent {
            TestTextFieldWithRemember(username = username.value, other = other.value)
        }
        count = 0

        // when
        username.value = "김컴포즈"
        composeTestRule.waitForIdle()
        // then
        assert(count == 1)

        // when
        other.value = "다른 값"
        composeTestRule.waitForIdle()
        // then
        assert(count == 1)
    }
}
