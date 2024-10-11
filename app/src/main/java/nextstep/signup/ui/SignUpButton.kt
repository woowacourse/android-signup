package nextstep.signup.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.signup.ui.theme.Blue50
import nextstep.signup.ui.theme.SignupTheme

@Composable
fun SignUpButton(
    modifier: Modifier = Modifier,
    title: String,
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(100.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Blue50),
        onClick = { },
    ) {
        Text(text = title)
    }
}

@Preview
@Composable
fun SignUpButtonPreview() {
    SignupTheme {
        SignUpButton(
            Modifier,
            "미리 보기 버튼"
        )
    }
}
