package nextstep.signup.ui.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.sp

@Composable
fun HeaderText(
    modifier: Modifier = Modifier,
    text: String,
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold,
    )
}

@Preview(showBackground = true)
@Composable
fun HeaderTextPreview(
    @PreviewParameter(HeaderTextPreviewParameterProvider::class) text: String,
) {
    HeaderText(text = text)
}

class HeaderTextPreviewParameterProvider : PreviewParameterProvider<String> {
    override val values: Sequence<String> =
        sequenceOf(
            "채드",
            "심지",
        )
}
