package nextstep.signup.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.junit4.createComposeRule
import nextstep.signup.fixtures.nodeWithTextDoesNotExist
import nextstep.signup.fixtures.nodeWithTextExists
import nextstep.signup.ui.model.SignUpFormState
import nextstep.signup.ui.model.SignUpStatus
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PasswordConfirmInputValidationTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val signUpFormState = mutableStateOf(SignUpFormState())

    @Before
    fun setUp() {
        signUpFormState.value = SignUpFormState(password = "password12")
        composeTestRule.setContent {
            PasswordTextField(
                label = "Password Confirmation",
                value = signUpFormState.value.passwordConfirmation,
                isError = signUpFormState.value.passwordConfirmationStatus is SignUpStatus.Error,
                errorMessage =
                    (signUpFormState.value.passwordConfirmationStatus as? SignUpStatus.Error)?.message?.let {
                        stringResource(
                            id = it,
                        )
                    },
                onValueChange = {
                    signUpFormState.changePasswordConfirmationValue(passwordConfirmation = it)
                },
            )
        }
    }

    @Test
    fun validPasswordConfirmation_success() {
        // given
        val errorMessage = "비밀번호가 일치하지 않습니다."

        // when
        signUpFormState.changePasswordConfirmationValue(passwordConfirmation = "password12")

        // then
        composeTestRule.nodeWithTextDoesNotExist(errorMessage)
    }

    @Test
    fun invalidPasswordConfirmation_unmatchedPassword_error() {
        // when
        signUpFormState.changePasswordConfirmationValue(passwordConfirmation = "password11")

        // then
        composeTestRule.nodeWithTextExists("비밀번호가 일치하지 않습니다.")
    }

    private fun MutableState<SignUpFormState>.changePasswordConfirmationValue(passwordConfirmation: String) {
        value = value.copy(passwordConfirmation = passwordConfirmation)
    }
}
