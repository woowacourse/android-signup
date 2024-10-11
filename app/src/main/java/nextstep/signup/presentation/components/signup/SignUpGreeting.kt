package nextstep.signup.presentation.components.signup

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun SignUpGreeting(modifier: Modifier = Modifier) {
    Text(
        text = "Welcome to Compose 🚀",
        fontSize = 28.sp,
        style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
        modifier = modifier
    )
}
