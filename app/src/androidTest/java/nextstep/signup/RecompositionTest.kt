package nextstep.signup

import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class RecompositionTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private var count = 0

    @Composable
    fun UsernameTextField(
        username: String,
        other: String,
    ) {
        val usernameLengthError = (username.length !in 2..5).also { count++ }
        TextField(
            value = username,
            onValueChange = {},
            isError = usernameLengthError,
        )
    }

    @Composable
    fun UsernameTextFieldWithRemember(
        username: String,
        other: String,
    ) {
        val usernameLengthError = remember(username) {
            (username.length !in 2..5).also { count++ }
        }
        TextField(
            value = username,
            onValueChange = {},
            isError = usernameLengthError,
        )
    }

    @Test
    fun 리컴포지션될때_매번_유효성_검사() {
        // given
        var username by mutableStateOf("")
        composeTestRule.setContent {
            UsernameTextField(username = username, other = "")
        }
        count = 0

        // when
        username = "김컴포즈"
        composeTestRule.waitForIdle()

        // then
        assertEquals(1, count)
    }

    @Test
    fun 불필요한_리컴포지션() {
        // given
        var other by mutableStateOf("")
        composeTestRule.setContent {
            UsernameTextField(username = "", other = other)
        }
        count = 0

        // when
        other = "불필요한 값 넣음"
        composeTestRule.waitForIdle()

        // then
        assertEquals(1, count)
    }

    @Test
    fun 특정_값_변경시만_유효성_검사() {
        // given
        var username by mutableStateOf("")
        var other by mutableStateOf("")
        composeTestRule.setContent {
            UsernameTextFieldWithRemember(username = username, other = other)
        }
        count = 0

        // when & then
        username = "김컴포즈"
        composeTestRule.waitForIdle()
        assertEquals(1, count)

        other = "불필요한 값 넣음"
        composeTestRule.waitForIdle()
        assertEquals(1, count)
    }
}
