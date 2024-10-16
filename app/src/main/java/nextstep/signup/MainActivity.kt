package nextstep.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import nextstep.signup.ui.theme.SignupTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignupTheme {
                CheckerScreen()
            }
        }
    }
}

// 상태를 들고 있는 컴포저블, Stateful
@Composable
fun CheckerScreen() {
    val checked = remember { mutableStateOf(true) }

    CheckerView(checked = checked.value) {
        checked.value = !checked.value
    }
}

// 상태를 받아서 뷰를 노출하는 컴포저블(상태를 직접적으로 들고 있지 않은 컴포저블), Stateless
@Composable
fun CheckerView(checked: Boolean, onCheckedChange: () -> Unit) {
    Column {
        Checkbox(
            checked = checked,
            onCheckedChange = { onCheckedChange() }
        )
        if (checked) Text(text = "체크됨!!!")
        Text(text = "", modifier = Modifier.fillMaxWidth())
    }
}

@Preview(showBackground = true)
@Composable
private fun CheckerViewPreview() {
    CheckerView(
        checked = true,
        onCheckedChange = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun LoremIpsumPreview(
    @PreviewParameter(LoremIpsum::class) value: String,
) {
    Text(text = value)
}
