package nextstep.signup.ui.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import nextstep.signup.ui.theme.Typography

@Composable
fun TitleText(
    @StringRes stringRes: Int,
) {
    Text(
        text = stringResource(stringRes),
        style = Typography.titleLarge,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(0.dp, 42.dp),
    )
}
