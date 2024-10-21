package nextstep.signup.ui.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.signup.ui.theme.Blue50

@Composable
fun SignUpButton(
    @StringRes textId: Int,
    enabled: Boolean,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = {},
        enabled = enabled,
        colors =
            ButtonColors(
                containerColor = Blue50,
                contentColor = Color.White,
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.White,
            ),
        modifier =
            modifier
                .fillMaxWidth()
                .height(50.dp),
    ) {
        Text(text = stringResource(textId), fontSize = 14.sp)
    }
}
