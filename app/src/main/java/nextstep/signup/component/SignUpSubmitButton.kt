package nextstep.signup.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import nextstep.signup.R

@Composable
fun SignUpSubmitButton(modifier: Modifier, text: String, onClick: () -> Unit) {
    Button(
        modifier = modifier,
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.blue_50)),
        contentPadding = PaddingValues(vertical = 15.dp)
    ) {
        Text(text = text)
    }
}
