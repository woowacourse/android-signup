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

class UsernameInputValidationTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val signUpFormState = mutableStateOf(SignUpFormState())

    @Before
    fun setUp() {
        signUpFormState.value = SignUpFormState()
        composeTestRule.setContent {
            PlainTextField(
                label = "Username",
                value = signUpFormState.value.username,
                isError = signUpFormState.value.usernameStatus is SignUpStatus.Error,
                errorMessage =
                    (signUpFormState.value.usernameStatus as? SignUpStatus.Error)?.message?.let {
                        stringResource(
                            id = it,
                        )
                    },
                onValueChange = {
                    signUpFormState.value = signUpFormState.value.copy(username = it)
                },
            )
        }
    }

    @Test
    fun validUsername_success() {
        // given
        val errorMessages =
            listOf(
                "이름은 2~5자여야 합니다.",
                "이름에는 숫자나 기호가 포함될 수 없습니다.",
            )

        // when
        signUpFormState.changeUsernameValue("abcde")

        // then
        errorMessages.forEach { errorMessage ->
            composeTestRule.nodeWithTextDoesNotExist(errorMessage)
        }
    }

    @Test
    fun invalidUsername_lessThan2Characters_error() {
        // when
        signUpFormState.changeUsernameValue(username = "a")

        // then
        composeTestRule.nodeWithTextExists("이름은 2~5자여야 합니다.")
    }

    @Test
    fun invalidUsername_moreThan5Characters_error() {
        // when
        signUpFormState.changeUsernameValue(username = "abcdef")

        // then
        composeTestRule.nodeWithTextExists("이름은 2~5자여야 합니다.")
    }

    @Test
    fun invalidUsername_containsNumbers_error() {
        // when
        signUpFormState.changeUsernameValue(username = "abc13")

        // then
        composeTestRule.nodeWithTextExists("이름에는 숫자나 기호가 포함될 수 없습니다.")
    }

    @Test
    fun invalidUsername_containsSigns_error() {
        // when
        signUpFormState.changeUsernameValue(username = "abc@#")

        // then
        composeTestRule.nodeWithTextExists("이름에는 숫자나 기호가 포함될 수 없습니다.")
    }

    private fun MutableState<SignUpFormState>.changeUsernameValue(username: String) {
        value = value.copy(username = username)
    }
}
