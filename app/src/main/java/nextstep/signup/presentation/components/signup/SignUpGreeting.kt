package nextstep.signup.presentation.components.signup

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import nextstep.signup.R

@Composable
fun SignUpGreeting(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = R.string.sign_up_greeting),
        fontSize = 28.sp,
        style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
        modifier = modifier
    )
}
