package nextstep.signup.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.junit4.createComposeRule
import nextstep.signup.fixtures.nodeWithTextDoesNotExist
import nextstep.signup.fixtures.nodeWithTextExists
import nextstep.signup.ui.model.UserForm
import nextstep.signup.ui.model.SignUpStatus
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PasswordInputValidationTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val userForm = mutableStateOf(UserForm())

    @Before
    fun setUp() {
        userForm.value = UserForm()
        composeTestRule.setContent {
            PasswordTextField(
                label = "Password",
                value = userForm.value.password,
                isError = userForm.value.passwordStatus is SignUpStatus.Error,
                errorMessage =
                    (userForm.value.passwordStatus as? SignUpStatus.Error)?.message?.let {
                        stringResource(
                            id = it,
                        )
                    },
                onValueChange = {
                    userForm.changePasswordValue(password = it)
                },
            )
        }
    }

    @Test
    fun validPassword_success() {
        // given
        val errorMessages =
            listOf(
                "비밀번호는 8~16자여야 합니다.",
                "비밀번호는 영문과 숫자를 포함해야 합니다.",
            )

        // when
        userForm.changePasswordValue(password = "aaaaaa12")

        // then
        errorMessages.forEach { errorMessage ->
            composeTestRule.nodeWithTextDoesNotExist(errorMessage)
        }
    }

    @Test
    fun invalidPassword_lessThan8Characters_error() {
        // when
        userForm.changePasswordValue(password = "aaaaaa1")

        // then
        composeTestRule.nodeWithTextExists("비밀번호는 8~16자여야 합니다.")
    }

    @Test
    fun invalidPassword_moreThan16Characters_error() {
        // when
        userForm.changePasswordValue(password = "abcdefghijk123456")

        // then
        composeTestRule.nodeWithTextExists("비밀번호는 8~16자여야 합니다.")
    }

    @Test
    fun invalidPassword_doesNotContainNumber_error() {
        // when
        userForm.changePasswordValue(password = "abcdefgh")

        // then
        composeTestRule.nodeWithTextExists("비밀번호는 영문과 숫자를 포함해야 합니다.")
    }

    @Test
    fun invalidPassword_doesNotContainEnglishCharacter_error() {
        // when
        userForm.changePasswordValue("12345678")

        // then
        composeTestRule.nodeWithTextExists("비밀번호는 영문과 숫자를 포함해야 합니다.")
    }

    private fun MutableState<UserForm>.changePasswordValue(password: String) {
        value = value.copy(password = password)
    }
}
