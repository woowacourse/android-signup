package nextstep.signup.ui.signup.component

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import nextstep.signup.ui.theme.Blue50

@Composable
fun SignUpButton(
    modifier: Modifier,
    text: String,
    onclick: () -> Unit,
) {
    Button(
        modifier = modifier,
        onClick = {
            onclick()
        },
        colors =
            ButtonDefaults.buttonColors(
                containerColor = Blue50,
            ),
    ) {
        Text(
            text = text,
            fontSize = 14.sp,
        )
    }
}
