package nextstep.signup.ui

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.unit.sp
import nextstep.signup.ui.model.UserForm
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ButtonOnSignUpValidationTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val userForm = mutableStateOf(UserForm())

    @Before
    fun setUp() {
        composeTestRule.setContent {
            DefaultButton(
                text = "Sign Up",
                enabled = userForm.value.formValid,
                onClick = {},
                fontSize = 12.sp,
            )
        }
    }

    @Test
    fun formValid_buttonEnabled() {
        // when
        userForm.value =
            UserForm(
                username = "abcde",
                email = "kmkim@pengcook.com",
                password = "abcd1234",
                passwordConfirmation = "abcd1234",
            )

        // then
        composeTestRule
            .onNodeWithText("Sign Up")
            .assertIsEnabled()
    }

    @Test
    fun formNotValid_buttonDisabled() {
        // when
        userForm.value =
            UserForm(
                username = "abcdef",
                email = "kmkim@pengcook.c",
                password = "abcd1234",
                passwordConfirmation = "abcd1235",
            )

        // then
        composeTestRule
            .onNodeWithText("Sign Up")
            .assertIsNotEnabled()
    }
}
