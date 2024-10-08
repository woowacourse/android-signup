package nextstep.signup.componet

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
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
    @StringRes titleResId: Int,
) {
    Text(
        modifier = modifier,
        text = stringResource(id = titleResId),
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
        titleResId = R.string.sign_up_title,
    )
}
