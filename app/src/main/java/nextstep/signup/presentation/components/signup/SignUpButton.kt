package nextstep.signup.presentation.components.signup

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import nextstep.signup.ui.theme.Blue50

@Composable
fun SignUpButton(
    text: String = "Sign Up",
    availability: () -> Boolean
) {
    Button(
        onClick = { /*TODO  Logic for after Sign Up*/ },
        enabled = availability(),
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Blue50
        )
    ) {
        Text(text = text, color = Color.White)
    }
}
