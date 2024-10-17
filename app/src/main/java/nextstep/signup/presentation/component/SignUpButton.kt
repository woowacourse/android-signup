package nextstep.signup.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import nextstep.signup.R

@Composable
fun SignUpButton(
    buttonText: String,
    isEnable: Boolean,
) {
    Button(
        onClick = {},
        modifier =
        Modifier
            .fillMaxWidth()
            .height(60.dp),
        colors =
        if (isEnable)
            ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.blue_50),
                contentColor = Color.White,
            )
        else
            ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.purple_700),
                contentColor = Color.White,
            ),
    ) {
        Text(text = buttonText)
    }
}
