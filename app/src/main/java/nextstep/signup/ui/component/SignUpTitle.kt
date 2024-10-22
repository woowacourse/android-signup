package nextstep.signup.ui.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SignUpTitle(
    @StringRes titleId: Int,
    modifier: Modifier = Modifier,
) {
    Text(
        text = stringResource(titleId),
        fontSize = 28.sp,
        fontWeight = FontWeight.W700,
        modifier =
            modifier
                .wrapContentWidth()
                .padding(top = 33.0.dp, bottom = 42.0.dp),
    )
}
