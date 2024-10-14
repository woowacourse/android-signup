package nextstep.signup.ui.interaction

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.signup.ui.theme.SignupTheme

@Composable
fun Modifier.clearFocusWith(focusManager: FocusManager, onFocus: (FocusManager) -> Unit = {}) =
    this.pointerInput(Unit) {
        detectTapGestures(onTap = {
            focusManager.clearFocus()
            onFocus(focusManager)
        })
    }

@Preview
@Composable
private fun Preview() {
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    SignupTheme {
        LaunchedEffect(key1 = Unit) {
            focusRequester.requestFocus()
        }
        Column(
            modifier = Modifier
                .clearFocusWith(focusManager)
                .padding(100.dp)
        ) {
            TextField(
                modifier = Modifier.focusRequester(focusRequester),
                value = "안녕",
                onValueChange = {}
            )
        }
    }
}
