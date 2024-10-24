package nextstep.signup.ui.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.signup.R
import nextstep.signup.ui.theme.Blue50

@Composable
fun ButtonComponent(
    modifier: Modifier = Modifier,
    enabled: Boolean = false,
    description: String,
) {
    Button(
        onClick = {},
        modifier = modifier.fillMaxWidth(),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(containerColor = Blue50),
        contentPadding = PaddingValues(vertical = 15.dp),
    ) {
        Text(text = description)
    }
}

@Preview(showBackground = true)
@Composable
private fun ButtonPreview() {
    ButtonComponent(description = stringResource(id = R.string.main_sign_up))
}
