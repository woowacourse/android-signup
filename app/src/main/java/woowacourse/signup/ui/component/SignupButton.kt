package woowacourse.signup.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import woowacourse.signup.ui.theme.Blue50

@Composable
fun SignupButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean,
    onClick: () -> Unit = {},
) {
    Button(
        onClick = { onClick() },
        colors =
            ButtonDefaults.buttonColors(
                containerColor = Blue50,
            ),
        modifier =
            modifier
                .fillMaxWidth(),
        enabled = enabled,
    ) {
        Text(
            text = text,
            fontSize = 14.sp,
            fontWeight = FontWeight.W500,
            modifier = Modifier.padding(vertical = 10.dp),
        )
    }
}
