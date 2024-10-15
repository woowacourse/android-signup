package nextstep.signup.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.junit4.createComposeRule
import nextstep.signup.fixtures.nodeWithTextDoesNotExist
import nextstep.signup.fixtures.nodeWithTextExists
import nextstep.signup.ui.model.SignUpStatus
import nextstep.signup.ui.model.UserForm
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class EmailInputValidationTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val userForm = mutableStateOf(UserForm())

    @Before
    fun setUp() {
        userForm.value = UserForm()
        composeTestRule.setContent {
            EmailTextField(
                label = "Email",
                value = userForm.value.email,
                isError = userForm.value.emailStatus is SignUpStatus.Error,
                errorMessage =
                    (userForm.value.emailStatus as? SignUpStatus.Error)?.message?.let {
                        stringResource(
                            id = it,
                        )
                    },
                onValueChange = {
                    userForm.changeEmailValue(email = it)
                },
            )
        }
    }

    @Test
    fun validEmail_success() {
        // given
        val errorMessage = "이메일 형식이 올바르지 않습니다."

        // when
        userForm.changeEmailValue(email = "abcde@gmail.com")

        // then
        composeTestRule.nodeWithTextDoesNotExist(errorMessage)
    }

    @Test
    fun invalidEmail_inappropriateFormat_error() {
        // given
        val invalidEmails =
            listOf("kmkim", "@gmail.com", "kmkim@", "kmkim@kr", "kmkim@kr.", "kmkim@co.k")

        // when & then
        invalidEmails.forEach {
            userForm.changeEmailValue(email = it)
            composeTestRule.nodeWithTextExists(text = "이메일 형식이 올바르지 않습니다.")
        }
    }

    private fun MutableState<UserForm>.changeEmailValue(email: String) {
        value = value.copy(email = email)
    }
}
