package nextstep.signup.ui.signupform

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.signup.ui.theme.SignupTheme

@Composable
fun ConfirmButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {},
) {
    Button(
        onClick = onClick,
    ) {
        Text(
            text = text,
            fontSize = 14.sp,
            modifier = modifier.padding(15.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ConfirmButtonPreview() {
    SignupTheme {
        ConfirmButton(text = "Preview")
    }
}
