package nextstep.signup.presentation.componet

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import nextstep.signup.R

@Composable
fun CustomText(
    modifier: Modifier = Modifier,
    title: String,
) {
    Text(
        modifier = modifier,
        text = title,
        fontSize = 26.sp,
        color = Color.Black,
        fontWeight = FontWeight.W700,
        textAlign = TextAlign.Center,
    )
}

@Preview
@Composable
fun CustomTextPreview() {
    CustomText(
        modifier = Modifier.fillMaxWidth(),
        title = stringResource(id = R.string.sign_up_title),
    )
}
