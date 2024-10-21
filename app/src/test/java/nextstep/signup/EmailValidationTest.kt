package nextstep.signup

import nextstep.signup.ui.signup.EmailTextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.model.validation.RegexValidation
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class EmailValidationTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private val email = mutableStateOf("")

    @Before
    fun setup() {
        val emailValidation =
            RegexValidation(
                "[a-zA-Z0-9._-]+@[a-zA-Z]+\\.+[a-zA-Z]+".toRegex(),
                EMAIL_FORM_ERROR
            )
        composeTestRule.setContent {
            EmailTextField(
                label = "email",
                text = email,
                validation = emailValidation,
            )
        }
    }

    @Test
    fun 이메일_표준_형식을_지키지_않았을_경우_오류_메시지가_노출된다() {
        // when
        email.value = "!!!!babo@gmail*com"

        // then
        composeTestRule
            .onNodeWithText(EMAIL_FORM_ERROR)
            .assertExists()
    }

    companion object {
        private const val EMAIL_FORM_ERROR = "이메일 형식이 올바르지 않습니다."
    }
}





