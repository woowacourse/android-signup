package nextstep.signup

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.unit.dp
import nextstep.signup.components.DefaultButton
import nextstep.signup.state.EmailState
import nextstep.signup.state.InputValidationResult.Valid
import nextstep.signup.state.PasswordConfirmState
import nextstep.signup.state.PasswordState
import nextstep.signup.state.UsernameState
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SignUpButtonTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private var usernameState = mutableStateOf(UsernameState())
    private var emailState = mutableStateOf(EmailState())
    private var passwordState = mutableStateOf(PasswordState())
    private var passwordConfirmState = mutableStateOf(PasswordConfirmState())
    private var isSignUpEnabled = mutableStateOf(
        usernameState.value.validate() == Valid &&
            emailState.value.validate() == Valid &&
            passwordState.value.validate() == Valid &&
            passwordConfirmState.value.validate("a1234567") == Valid
    )
    private val button = SemanticsMatcher.expectValue(
        SemanticsProperties.Role,
        Role.Button
    )

    @Before
    fun setup() {
        composeTestRule.setContent {
            DefaultButton(
                contentPadding = PaddingValues(16.dp),
                enabled = isSignUpEnabled.value
            ) {}
        }
    }

    @Test
    fun 모든_필드가_에러_없이_채워진_경우에_회원가입란이_활성화된다() {
        // when
        usernameState.value = usernameState.value.copy(username = "abcd")
        emailState.value = emailState.value.copy(email = "a@a.com")
        passwordState.value = passwordState.value.copy(password = "a1234567")
        passwordConfirmState.value = passwordConfirmState.value.copy(password = "a1234567")
        isSignUpEnabled.value = usernameState.value.validate() == Valid &&
            emailState.value.validate() == Valid &&
            passwordState.value.validate() == Valid &&
            passwordConfirmState.value.validate(passwordState.value.password) == Valid

        composeTestRule.onNode(button, useUnmergedTree = true)
            .assertIsEnabled()
    }

    @Test
    fun 필드가_에러가_있는_경우에_회원가입란이_비활성화된다() {
        // when
        usernameState.value = usernameState.value.copy(username = "")
        emailState.value = emailState.value.copy(email = "")
        passwordState.value = passwordState.value.copy(password = "")
        passwordConfirmState.value = passwordConfirmState.value.copy(password = "")
        isSignUpEnabled.value = usernameState.value.validate() == Valid &&
            emailState.value.validate() == Valid &&
            passwordState.value.validate() == Valid &&
            passwordConfirmState.value.validate(passwordState.value.password) == Valid

        // then
        composeTestRule.onNode(button, useUnmergedTree = true)
            .assertIsNotEnabled()
    }
}
