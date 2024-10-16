package nextstep.signup.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TextComponent(
    modifier: Modifier = Modifier,
    description: String,
) {
    Text(
        text = description,
        modifier = modifier,
        style = MaterialTheme.typography.titleLarge,
    )
}
