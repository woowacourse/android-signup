package nextstep.signup.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun SignUpTitle(modifier: Modifier = Modifier, title: String) {
    Text(
        modifier = modifier,
        text = title,
        style = androidx.compose.ui.text.TextStyle(
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )
    )
}
