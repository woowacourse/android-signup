package nextstep.signup.ui.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

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

@Preview(showBackground = true)
@Composable
private fun TextPreview() {
    TextComponent(modifier = Modifier, description = "Compose 🚀")
}
