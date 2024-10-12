package nextstep.signup.ui.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun TextButton(
    @StringRes stringRes: Int,
) {
    Button(onClick = {}, contentPadding = PaddingValues(120.dp, 15.dp)) {
        Text(text = stringResource(stringRes))
    }
}
