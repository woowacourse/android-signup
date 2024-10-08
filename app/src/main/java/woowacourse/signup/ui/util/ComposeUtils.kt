package woowacourse.signup.ui.util

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import woowacourse.signup.ui.theme.SignupTheme

@Composable
fun FillMaxTheme(content: @Composable () -> Unit) {
    SignupTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            content()
        }
    }
}

@Composable
fun Space(dp: Int) {
    Spacer(modifier = Modifier.height(dp.dp))
}
