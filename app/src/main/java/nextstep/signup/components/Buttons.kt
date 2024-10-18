package nextstep.signup.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import nextstep.signup.R

@Composable
fun DefaultButton(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues,
    enabled: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp)),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(Color.Blue),
        contentPadding = contentPadding
    ) {
        Text(text = stringResource(id = R.string.sign_up_sign_up_label))
    }
}
