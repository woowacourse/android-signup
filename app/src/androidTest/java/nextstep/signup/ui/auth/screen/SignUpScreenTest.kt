package nextstep.signup.ui.auth.screen

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.isFocused
import androidx.compose.ui.test.isNotFocused
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performImeAction
import androidx.compose.ui.test.performTextInput
import nextstep.signup.R
import nextstep.signup.ui.auth.model.SignUpFormState
import org.junit.Rule
import org.junit.Test

class SignUpScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun composition후_유저_이름이_focus된다() {
        // given
        var nameFormLabel: String = ""
        composeTestRule.setContent {
            val (formState, onChangeFormState) = remember {
                mutableStateOf(SignUpFormState.empty())
            }
            nameFormLabel = stringResource(id = R.string.sign_up_user_name_form)
            SignUpScreen(
                signUpFormState = formState,
                onUserNameChange = {},
                onEmailChange = {},
                onPasswordChange = {},
                onPasswordConfirmChange = {},
                onDoneSignUp = {}
            )
        }

        // then
        composeTestRule.runOnIdle { }
        assert(nameFormLabel.isNotBlank())
        composeTestRule.onNodeWithText(nameFormLabel)
            .assert(isFocused())
    }

    @Test
    fun 외부_영역을_터치하면_유저_이름의_focus가_해제된다() {
        // given
        var nameFormLabel = ""
        var title = ""
        composeTestRule.setContent {
            val (formState, onChangeFormState) = remember {
                mutableStateOf(SignUpFormState.empty())
            }
            nameFormLabel = stringResource(id = R.string.sign_up_user_name_form)
            title = stringResource(id = R.string.sign_up_title)
            SignUpScreen(
                signUpFormState = formState,
                onUserNameChange = {},
                onEmailChange = {},
                onPasswordChange = {},
                onPasswordConfirmChange = {},
                onDoneSignUp = {}
            )
        }

        // when
        composeTestRule.onNodeWithText(title)
            .performClick()
        // then
        composeTestRule.onNodeWithText(nameFormLabel)
            .assert(isNotFocused())
    }

    @Test
    fun 유저_이름폼_IME버튼을_클릭하면_이메일_폼이_focus된다() {
        // given
        var nameFormLabel = ""
        var emailFormLabel = ""
        composeTestRule.setContent {
            val (formState, onChangeFormState) = remember {
                mutableStateOf(SignUpFormState.empty())
            }
            nameFormLabel = stringResource(id = R.string.sign_up_user_name_form)
            emailFormLabel = stringResource(id = R.string.sign_up_email_form)
            SignUpScreen(
                signUpFormState = formState,
                onUserNameChange = {},
                onEmailChange = {},
                onPasswordChange = {},
                onPasswordConfirmChange = {},
                onDoneSignUp = {}
            )
        }

        // when
        composeTestRule.onNodeWithText(nameFormLabel)
            .performImeAction()

        // then
        composeTestRule.onNodeWithText(nameFormLabel)
            .assert(isNotFocused())
        composeTestRule.onNodeWithText(emailFormLabel)
            .assert(isFocused())
    }

    @Test
    fun 패스워드_확인_폼이_활성화되있을때_IME버튼을_누르면_unFocus된다() {
        // given
        var passwordConfirmFormLabel = ""
        composeTestRule.setContent {
            val (formState, onChangeFormState) = remember {
                mutableStateOf(SignUpFormState.empty())
            }
            passwordConfirmFormLabel = stringResource(id = R.string.sign_up_password_confirm_form)
            SignUpScreen(
                signUpFormState = formState,
                onUserNameChange = {},
                onEmailChange = {},
                onPasswordChange = {},
                onPasswordConfirmChange = {},
                onDoneSignUp = {}
            )
        }

        // when
        composeTestRule.onNodeWithText(passwordConfirmFormLabel)
            .performTextInput("password")
        composeTestRule.onNodeWithText(passwordConfirmFormLabel)
            .performImeAction()

        // then
        composeTestRule.onNodeWithText(passwordConfirmFormLabel)
            .assert(isNotFocused())
    }

    @Test
    fun `회원가입_버튼이_활성화됐을때_누르면_스낵바_메세지가_뜬다`() {
        // given
        var passwordConfirmFormLabel = ""
        var snackBarMessage = ""
        composeTestRule.setContent {
            val (formState, onChangeFormState) = remember {
                mutableStateOf(SignUpFormState.empty())
            }
            passwordConfirmFormLabel = stringResource(id = R.string.sign_up_password_confirm_form)
            snackBarMessage = stringResource(id = R.string.sign_up_success)
            SignUpScreen(
                signUpFormState = formState,
                onUserNameChange = {},
                onEmailChange = {},
                onPasswordChange = {},
                onPasswordConfirmChange = {},
                onDoneSignUp = {}
            )
        }

        // when
        composeTestRule.onNodeWithText(passwordConfirmFormLabel)
            .performClick()
        // then
        composeTestRule.onNodeWithText(snackBarMessage)
            .isDisplayed()
    }
}
