package nextstep.signup.presentation.components.signup

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import nextstep.signup.R

@Composable
fun SignUpSnackbar(
    message: String,
    onDismiss: () -> Unit
) {
    Snackbar(
        action = {
            TextButton(onClick = onDismiss) {
                Text(stringResource(R.string.confirm_text))
            }
        },
        modifier = Modifier.padding(8.dp)
    ) {
        Text(text = message)
    }
}
