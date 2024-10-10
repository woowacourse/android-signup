package nextstep.signup.ui.common.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.signup.ui.theme.DisabledStateColor
import nextstep.signup.ui.theme.EnabledStateColor
import nextstep.signup.ui.theme.SignupTheme
import nextstep.signup.ui.theme.White

@Composable
fun StateButton(
    text: String,
    onClick: () -> Unit,
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .requiredHeight(50.dp),
        colors = ButtonColors(
            containerColor = EnabledStateColor,
            contentColor = White,
            disabledContainerColor = DisabledStateColor,
            disabledContentColor = White,
        ),
        onClick = { onClick() },
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            lineHeight = 20.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonPreview() {
    SignupTheme {
        StateButton("dlrjqhkfk~") {}
    }
}
