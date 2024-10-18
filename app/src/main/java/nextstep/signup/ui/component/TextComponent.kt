package nextstep.signup.ui.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TextComponent(
    modifier: Modifier = Modifier,
    description: String,
    style: TextStyle = MaterialTheme.typography.bodySmall,
) {
    Text(
        text = description,
        modifier = modifier,
        style = style,
    )
}

@Preview(showBackground = true)
@Composable
private fun TextPreview() {
    TextComponent(modifier = Modifier, description = "Compose 🚀", style = MaterialTheme.typography.titleLarge)
}
