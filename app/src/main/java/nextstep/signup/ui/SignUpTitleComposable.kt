package nextstep.signup.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.signup.R
import nextstep.signup.ui.component.TextComponent

@Composable
fun SignUpTitleComposable() {
    TextComponent(description = stringResource(R.string.main_greeting), style = MaterialTheme.typography.titleLarge)
    Spacer(modifier = Modifier.size(42.dp))
}

@Preview(showBackground = true)
@Composable
private fun SignUpTitleComposablePreview() {
    SignUpTitleComposable()
}
