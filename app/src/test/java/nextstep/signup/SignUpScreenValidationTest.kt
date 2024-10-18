package nextstep.signup

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.ui.signup.SignUpScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class SignUpScreenValidationTest{

    @get:Rule
    val composeTestRule = createComposeRule()
    private val username = mutableStateOf("")
    private val email = mutableStateOf("")
    private val password = mutableStateOf("")
    private val passwordConfirm = mutableStateOf("")

    @Before
    fun setup() {
        composeTestRule.setContent {
            SignUpScreen(
                userName = username,
                email = email,
                password = password,
                passwordConfirm = passwordConfirm,
            )
        }
    }

    @Test
    fun 모든_입력칸에_에러가_없으면_회원가입이_활성화된다() {
        // when

        username.value = "김형석"
        email.value = "aprilgom@gmail.com"
        password.value = "a11111111"
        passwordConfirm.value = "a11111111"

        // then
        composeTestRule
            .onNodeWithText(SIGN_UP_BUTTON_NAME)
            .assertIsEnabled()
    }

    @Test
    fun 입력칸에_에러가_하나라도_있으면_회원가입이_비활성화된다() {

        // when
        username.value = "123456"
        email.value = "aprilgom@gmail.com"
        password.value = "a11111111"
        passwordConfirm.value = "a11111111"

        // then
        composeTestRule
            .onNodeWithText(SIGN_UP_BUTTON_NAME)
            .assertIsNotEnabled()
    }

    companion object {
        private const val SIGN_UP_BUTTON_NAME = "Sign Up"
    }
}
