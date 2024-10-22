package nextstep.signup

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.unit.dp
import nextstep.signup.domain.Email
import nextstep.signup.domain.Password
import nextstep.signup.domain.PasswordConfirm
import nextstep.signup.domain.Username
import nextstep.signup.ui.signup.SignUpButton
import nextstep.signup.ui.signup.SignUpInputs
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SignUpInteractionLayerTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val username = mutableStateOf(Username())
    private val email = mutableStateOf(Email())
    private val password = mutableStateOf(Password())
    private val passwordConfirm = mutableStateOf(PasswordConfirm())
    private val isFormatValid =
        derivedStateOf {
            username.value.isValid && email.value.isValid && password.value.isValid && passwordConfirm.value.isMatchWithPassword(
                password.value.value
            )
        }

    @Before
    fun setup() {
        username.value = validUsername
        email.value = validEmail
        password.value = validPassword
        passwordConfirm.value = validPasswordConfirm

        composeTestRule.setContent {
            val modifier = Modifier.fillMaxWidth()
            SignUpInputs(
                modifier = modifier.testTag(SIGN_UP_INPUTS_TAG),
                username = username.value,
                email = email.value,
                password = password.value,
                passwordConfirm = passwordConfirm.value,
                onUsernameChanged = { username.value = Username(value = it) },
                onEmailChanged = { email.value = Email(value = it) },
                onPasswordChanged = { password.value = Password(value = it) },
                onPasswordConfirmChanged = { passwordConfirm.value = PasswordConfirm(value = it) },
            )
            SignUpButton(
                modifier = modifier
                    .requiredHeight(50.dp)
                    .testTag(SIGN_UP_BUTTON_TAG),
                isSignUpAvailiable = isFormatValid.value,
                onButtonClicked = { },
            )
        }
    }

    @Test
    fun `모든_입력_값이_비어있는_초기에는_회원가입_버튼이_비활성화되어_있다`() {
        // when
        username.value = Username()
        email.value = Email()
        password.value = Password()
        passwordConfirm.value = PasswordConfirm()

        // then
        assertFalse(isFormatValid.value)
        composeTestRule
            .onNodeWithTag(SIGN_UP_BUTTON_TAG)
            .assertIsNotEnabled()
    }

    @Test
    fun `모든_입력_값을_올바르게_입력한_상태이면_회원가입_버튼이_활성화된다`() {
        assertTrue(isFormatValid.value)
        composeTestRule
            .onNodeWithTag(SIGN_UP_BUTTON_TAG)
            .assertIsEnabled()
    }

    @Test
    fun `사용자_이름의_길이가_올바르지_않으면_버튼이_비활성화된다`() {
        // given
        assertTrue(isFormatValid.value)
        composeTestRule
            .onNodeWithTag(SIGN_UP_BUTTON_TAG)
            .assertIsEnabled()

        // when
        username.value = invalidLengthUsername

        // then
        assertFalse(isFormatValid.value)
        composeTestRule
            .onNodeWithTag(SIGN_UP_BUTTON_TAG)
            .assertIsNotEnabled()
    }

    @Test
    fun `사용자_이름의_형식이_올바르지_않으면_버튼이_비활성화된다`() {
        // given
        assertTrue(isFormatValid.value)
        composeTestRule
            .onNodeWithTag(SIGN_UP_BUTTON_TAG)
            .assertIsEnabled()

        // when
        username.value = invalidFormatUsername

        // then
        assertFalse(isFormatValid.value)
        composeTestRule
            .onNodeWithTag(SIGN_UP_BUTTON_TAG)
            .assertIsNotEnabled()
    }

    @Test
    fun `이메일의_형식이_올바르지_않으면_버튼이_비활성화된다`() {
        // given
        assertTrue(isFormatValid.value)
        composeTestRule
            .onNodeWithTag(SIGN_UP_BUTTON_TAG)
            .assertIsEnabled()

        // when
        email.value = invalidFormatEmail

        // then
        assertFalse(isFormatValid.value)
        composeTestRule
            .onNodeWithTag(SIGN_UP_BUTTON_TAG)
            .assertIsNotEnabled()
    }

    @Test
    fun `비밀번호의_길이가_올바르지_않으면_버튼이_비활성화된다`() {
        // given
        assertTrue(isFormatValid.value)
        composeTestRule
            .onNodeWithTag(SIGN_UP_BUTTON_TAG)
            .assertIsEnabled()

        // when
        password.value = invalidLengthPassword

        // then
        assertFalse(isFormatValid.value)
        composeTestRule
            .onNodeWithTag(SIGN_UP_BUTTON_TAG)
            .assertIsNotEnabled()
    }

    @Test
    fun `비밀번호의_형식이_올바르지_않으면_버튼이_비활성화된다`() {
        // given
        assertTrue(isFormatValid.value)
        composeTestRule
            .onNodeWithTag(SIGN_UP_BUTTON_TAG)
            .assertIsEnabled()

        // when
        password.value = invalidFormatPassword

        // then
        assertFalse(isFormatValid.value)
        composeTestRule
            .onNodeWithTag(SIGN_UP_BUTTON_TAG)
            .assertIsNotEnabled()
    }

    @Test
    fun `비밀번호_확인이_비밀번호와_동일하지_않으면_버튼이_비활성화된다`() {
        // given
        assertTrue(isFormatValid.value)
        composeTestRule
            .onNodeWithTag(SIGN_UP_BUTTON_TAG)
            .assertIsEnabled()

        // when
        passwordConfirm.value = mismatchPasswordConfirm

        // then
        assertFalse(isFormatValid.value)
        composeTestRule
            .onNodeWithTag(SIGN_UP_BUTTON_TAG)
    }

    companion object {
        private const val SIGN_UP_INPUTS_TAG = "SignUpInputs"
        private const val SIGN_UP_BUTTON_TAG = "SignUpButton"
    }
}
