package nextstep.signup

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.ui.signup.SignUpTextField
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class InputValidationTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private val username = mutableStateOf("")

    @Before
    fun setup() {
        composeTestRule.setContent {
            UsernameTextField(username = username)
        }
    }

    @Test
    fun 사용자_이름은_2에서_5자여야_한다() {
        // when
        username.value = "김컴포즈"

        // then
        composeTestRule
            .onNodeWithText(USERNAME_LENGTH_ERROR)
            .assertDoesNotExist()
    }

    @Test
    fun 사용자_이름이_2에서_5자가_아니면_에러메시지가_노출된다() {
        // when
        username.value = "김컴포즈입니다"

        // then
        composeTestRule
            .onNodeWithText(USERNAME_LENGTH_ERROR)
            .assertExists()
    }

    @Test
    fun 사용자의_이름은_한글이거나_영어여야_한다() {
        // when
        username.value = "%%#@!"

        //then
        composeTestRule
            .onNodeWithText(USERNAME_CHARACTER_ERROR)
            .assertExists()
    }

    companion object {
        private const val USERNAME_LENGTH_ERROR = "이름은 2~5자여야 합니다."
        private const val USERNAME_CHARACTER_ERROR = "이름에는 숫자나 기호가 포함될 수 없습니다."
    }
}

@Composable
fun UsernameTextField(
    username: MutableState<String>,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit = {},
) {
    val lengthValidation = LengthValidation(2..5, stringResource(R.string.username_length_error))
    val characterValidation = RegexValidation("[a-zA-Z가-힣]+".toRegex(), stringResource(R.string.username_character_error))
    val compositeValidation = CompositeValidation(lengthValidation, characterValidation)
    SignUpTextField(
        modifier = modifier,
        label = stringResource(R.string.username),
        text = username,
        onValueChange = onValueChange,
        isError = !compositeValidation.validate(username.value),
        errorMessage = compositeValidation.errorMessage(username.value)
    )
}

interface Validation {
    fun validate(text: String): Boolean
    fun errorMessage(text: String): String
}

class CompositeValidation(
    private vararg val validations: Validation
) : Validation {
    override fun validate(text: String): Boolean =
        validations.all { it.validate(text) }

    override fun errorMessage(text: String): String =
        filterUnpassedValidations(text).joinToString(separator = "\n") { it.errorMessage(text) }

    private fun filterUnpassedValidations(text: String): List<Validation> =
        validations.filter { !it.validate(text) }
}

class LengthValidation(
    private val range: IntRange,
    private val errorMessage: String,
) : Validation {
    override fun validate(text: String): Boolean =
        text.length in range

    override fun errorMessage(text: String): String = errorMessage
}

class RegexValidation(
    private val regex: Regex,
    private val errorMessage: String,
) : Validation {
    override fun validate(text: String): Boolean =
        regex.matches(text)

    override fun errorMessage(text: String): String = errorMessage
}
