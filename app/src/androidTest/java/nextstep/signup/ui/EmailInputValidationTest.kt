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

class EmailInputValidationTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val signUpFormState = mutableStateOf(SignUpFormState())

    @Before
    fun setUp() {
        signUpFormState.value = SignUpFormState()
        composeTestRule.setContent {
            EmailTextField(
                label = "Email",
                value = signUpFormState.value.email,
                isError = signUpFormState.value.emailStatus is SignUpStatus.Error,
                errorMessage = (signUpFormState.value.emailStatus as? SignUpStatus.Error)?.message?.let {
                    stringResource(
                        id = it
                    )
                },
                onValueChange = {
                    signUpFormState.changeEmailValue(email = it)
                },
            )
        }
    }

    @Test
    fun validEmail_success() {
        // given
        val errorMessage = "이메일 형식이 올바르지 않습니다."

        // when
        signUpFormState.changeEmailValue(email = "abcde@gmail.com")

        // then
        composeTestRule.nodeWithTextDoesNotExist(errorMessage)
    }

    @Test
    fun invalidEmail_inappropriateFormat_error() {
        // given
        val invalidEmails = listOf("kmkim", "kmkim@", "kmkim@kr", "kmkim@kr.")

        // when & then
        invalidEmails.forEach {
            signUpFormState.changeEmailValue(email = it)
            composeTestRule.nodeWithTextExists(text = "이메일 형식이 올바르지 않습니다.")
        }
    }

    private fun MutableState<SignUpFormState>.changeEmailValue(email: String) {
        value = value.copy(email = email)
    }
}
