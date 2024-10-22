package nextstep.signup

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.ui.signup.SignUpScreen
import nextstep.signup.ui.signup.SignUpUiModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SignUpScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private val signUpInfo = mutableStateOf(SignUpUiModel())

    @Before
    fun setUp() {
        composeTestRule.setContent {
            SignUpScreen(signUpInfo.value) {
                signUpInfo.value = it
            }
        }
    }

    @Test
    fun 사용자_이름이_올바르면_에러메시지가_노출되지_않는다() {
        // when
        signUpInfo.value = signUpInfo.value.copy(userName = "test")

        // then
        composeTestRule
            .onNodeWithText(USER_NAME_LENGTH_ERROR)
            .assertDoesNotExist()
        composeTestRule
            .onNodeWithText(USER_NAME_REGEX_ERROR)
            .assertDoesNotExist()
    }

    @Test
    fun 사용자_이름이_2에서_5자가_아니면_에러메시지가_노출된다() {
        // when
        signUpInfo.value = signUpInfo.value.copy(userName = "composeTest")

        // then
        composeTestRule.onNodeWithText(
            USER_NAME_LENGTH_ERROR
        ).assertExists()
    }

    @Test
    fun 사용자_이름에_숫자가_들어가면_에러메시지가_노출된다() {
        // when
        signUpInfo.value = signUpInfo.value.copy(userName = "test1")

        // then
        composeTestRule.onNodeWithText(USER_NAME_REGEX_ERROR).assertExists()
    }

    @Test
    fun 이메일_형식이_올바르면_에러메시지가_노출되지_않는다() {
        // when
        signUpInfo.value = signUpInfo.value.copy(email = "test@gmail.com")

        // then
        composeTestRule.onNodeWithText(
            EMAIL_REGEX_ERROR
        ).assertDoesNotExist()
    }

    @Test
    fun 이메일_형식이_올바르지_않으면_에러메시지_노출된다() {
        // when
        signUpInfo.value = signUpInfo.value.copy(email = "test")

        // then
        composeTestRule.onNodeWithText(
            EMAIL_REGEX_ERROR
        ).assertExists()
    }

    @Test
    fun 비밀번호_형식이_올바르면_에러메시지가_노출되지_않는다() {
        // when
        signUpInfo.value = signUpInfo.value.copy(password = "test1234")

        // then
        composeTestRule.onNodeWithText(
            PASSWORD_REGEX_ERROR
        ).assertDoesNotExist()

        composeTestRule.onNodeWithText(PASSWORD_LENGTH_ERROR)
            .assertDoesNotExist()
    }

    @Test
    fun 비밀번호가_8에서_16자가_아니면_에러메시지가_노출된다() {
        // when
        signUpInfo.value = signUpInfo.value.copy(password = "test12")

        // then
        composeTestRule.onNodeWithText(PASSWORD_LENGTH_ERROR).assertExists()
    }

    @Test
    fun 비밀번호에_영어_혹은_숫자가_없으면_에러메시지가_노출된다() {
        // when
        signUpInfo.value = signUpInfo.value.copy(password = "test")

        // then
        composeTestRule.onNodeWithText(PASSWORD_REGEX_ERROR).assertExists()
    }

    @Test
    fun 비밀번호와_비밀번호_확인이_서로_같으면_에러메시지가_노출되지_않는다() {
        // when
        signUpInfo.value =
            signUpInfo.value.copy(password = "test1234", passwordConfirm = "test1234")

        // then
        composeTestRule.onNodeWithText(PASSWORD_CONFIRM_ERROR).assertDoesNotExist()
    }

    @Test
    fun 비밀번호와_비밀번호_확인이_서로_다르면_에러메시지가_노출된다() {
        // when
        signUpInfo.value =
            signUpInfo.value.copy(password = "test1234", passwordConfirm = "test5678")

        // then
        composeTestRule.onNodeWithText(PASSWORD_CONFIRM_ERROR).assertExists()

    }

    @Test
    fun 모든_정보가_올바르게_입력되면_버튼이_활성화된다() {
        // when
        signUpInfo.value = signUpInfo.value.copy(
            userName = "bari",
            email = "test@gmail.com",
            password = "test1234",
            passwordConfirm = "test1234"
        )

        // then
        composeTestRule.onNodeWithText("Sign Up").assertIsEnabled()

    }

    @Test
    fun 하나라도_입력이_올바르지_않으면_버튼이_비활성화_된다() {
        // when
        signUpInfo.value = signUpInfo.value.copy(
            userName = "bari",
            email = "test",
            password = "test1234",
            passwordConfirm = "test1234"
        )

        // then
        composeTestRule.onNodeWithText("Sign Up").assertIsNotEnabled()
    }

    companion object {
        private const val USER_NAME_LENGTH_ERROR = "이름은 2~5자여야 합니다."
        private const val USER_NAME_REGEX_ERROR = "이름에는 숫자나 기호가 포함될 수 없습니다."
        private const val EMAIL_REGEX_ERROR = "이메일 형식이 올바르지 않습니다."
        private const val PASSWORD_REGEX_ERROR = "비밀번호는 영문과 숫자를 포함해야 합니다."
        private const val PASSWORD_LENGTH_ERROR = "비밀번호는 8~16자여야 합니다."
        private const val PASSWORD_CONFIRM_ERROR = "비밀번호가 일치하지 않습니다."
    }
}