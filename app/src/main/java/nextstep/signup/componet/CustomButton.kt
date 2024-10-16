package nextstep.signup.componet

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.signup.R
import nextstep.signup.ui.theme.Blue50

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    shape: RoundedCornerShape = RoundedCornerShape(8.dp),
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    buttonTitle: String,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
        shape = shape,
        colors = buttonColors,
        enabled = enabled,
    ) {
        Text(
            text = buttonTitle,
            fontSize = 14.sp,
            fontWeight = FontWeight.W500,
            modifier = Modifier.padding(vertical = 15.dp),
        )
    }
}

@Preview
@Composable
fun CustomButtonPreView() {
    CustomButton(
        modifier = Modifier.padding(horizontal = 32.dp),
        shape = RoundedCornerShape(100.dp),
        buttonColors = ButtonDefaults.buttonColors(containerColor = Blue50),
        buttonTitle = stringResource(R.string.sign_up_button),
        onClick = {},
    )
}
