package nextstep.signup.componet

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import nextstep.signup.R
import nextstep.signup.model.UserName
import nextstep.signup.ui.SignUpState
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CustomTextFieldTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val tag = "tag"
    private var signUpState by mutableStateOf(SignUpState())

    @Before
    fun setup() {
        composeTestRule.setContent {
            CustomTextField(
                modifier = Modifier.testTag(tag),
                value = signUpState.username.value,
                onValueChange = { value ->
                    signUpState = signUpState.copy(username = UserName(value))
                },
                label = stringResource(R.string.username_input),
                inputValidation = signUpState.username.validate(),
            )
        }
    }

    @Test
    fun `CustomTextField에_값이_정상적으로_입력된다`() {
        // given & when
        val inputText = "하하핳"
        composeTestRule
            .onNodeWithTag(tag)
            .performTextInput(inputText)

        // then
        composeTestRule
            .onNodeWithTag(tag)
            .assert(hasText(inputText))
    }

    @Test
    fun `사용자_이름은_2에서_5자여야_한다`() {
        // when
        signUpState = signUpState.copy(username = UserName("김컴포즈"))

        // then
        composeTestRule
            .onNodeWithText("이름은 2~5자여야 합니다.")
            .assertDoesNotExist()
    }

    @Test
    fun `사용자_이름이_2에서_5자가_아니면_에러메시지가_노출된다`() {
        // when
        signUpState = signUpState.copy(username = UserName("김컴포즈입니다"))

        // then
        composeTestRule
            .onNodeWithText("이름은 2~5자여야 합니다.")
            .assertExists()
    }
}
