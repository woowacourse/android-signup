package nextstep.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.signup.ui.CustomTextField

object TestFixture {
    const val TEST_TAG = "이름"
    const val FIRST_TEXT = "깜포즈"
    const val SECOND_TEXT = "끔포즈"
    const val PREVIEW_TEXT = "안녕 난 컴포즈야~"

    lateinit var USERNAME_LABEL: String
    lateinit var USERNAME_LENGTH_ERROR: String
    lateinit var USERNAME_FORMAT_ERROR: String

    @Composable
    fun InitializeStrings() {
        USERNAME_LABEL = stringResource(R.string.username)
        USERNAME_LENGTH_ERROR = stringResource(R.string.username_length_error)
        USERNAME_FORMAT_ERROR = stringResource(R.string.username_format_error)
    }

    @Composable
    fun MakeColumnText() {
        Column(
            modifier = Modifier.testTag(TEST_TAG)
        ) {
            TextComponent(text = FIRST_TEXT, color = Color.Cyan)
            TextComponent(text = SECOND_TEXT, color = Color.Yellow)
        }
    }

    @Composable
    fun TextComponent(text: String = PREVIEW_TEXT, color: Color = Color.Blue) {
        Text(
            text = text,
            color = color,
            style = TextStyle(
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif
            )
        )
    }

    @Composable
    fun ButtonComponent(
        buttonText: String = "클릭해주세요",
        onClickAction: () -> Unit = {},
        enabledState: MutableState<Boolean> = remember { mutableStateOf(true) },
        modifier: Modifier = Modifier
    ) {
        Button(
            onClick = onClickAction,
            enabled = enabledState.value,
            modifier = modifier.testTag("버튼")
        ) {
            Text(text = buttonText)
        }
    }

    @Composable
    fun TestCustomTextField(
        valueState: String,
        errorState: String,
        label: String,
        onValueChange: (String) -> Unit
    ) {
        Column {
            CustomTextField(
                value = valueState,
                onValueChange = {
                    onValueChange(it)
                },
                label = label,
                isError = errorState.isNotEmpty()
            )
            if (errorState.isNotEmpty()) {
                Text(
                    text = errorState,
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.padding(start = 24.dp)
                )
            }
        }
    }
}
