package nextstep.signup.presentation.components.signup

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import nextstep.signup.R
import nextstep.signup.ui.theme.Blue50

@Composable
fun SignUpButton(
    availability: () -> Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = { onClick() },
        enabled = availability(),
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = Blue50
        )
    ) {
        Text(text = stringResource(R.string.sign_up_button), color = Color.White)
    }
}
