package nextstep.signup.ui.signup.composable.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import nextstep.signup.R

@Composable
fun SignUpTitle() {
    Text(
        text = stringResource(id = R.string.signup_title),
        fontWeight = FontWeight.Bold,
        fontSize = 26.sp,
        lineHeight = 20.sp,
    )
}
