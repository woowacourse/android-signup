package nextstep.signup.ui.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.signup.R

@Composable
fun TextButton(
    @StringRes stringRes: Int,
    enabled: Boolean,
    onClickEvent: () -> Unit = {},
) {
    Button(onClick = { onClickEvent() }, contentPadding = PaddingValues(120.dp, 15.dp), enabled = enabled) {
        Text(text = stringResource(stringRes))
    }
}

@Preview(showBackground = true)
@Composable
private fun ButtonPreview() {
    TextButton(R.string.sign_up_button_title, false)
}
