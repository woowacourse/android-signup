package nextstep.signup.ui.component

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.sp
import nextstep.signup.ui.theme.Blue50

@Composable
fun SubmitButton(
    modifier: Modifier = Modifier,
    text: String,
    onclick: () -> Unit,
    enabled: Boolean,
) {
    Button(
        modifier = modifier,
        onClick = {
            onclick()
        },
        enabled = enabled,
        colors =
            ButtonDefaults.buttonColors(
                containerColor = Blue50,
            ),
    ) {
        Text(
            text = text,
            fontSize = 14.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SubmitButtonPreview(
    @PreviewParameter(SubmitButtonPreviewParameterProvider::class) params: SubmitButtonParams,
) {
    SubmitButton(text = params.text, onclick = {}, enabled = params.enabled)
}

data class SubmitButtonParams(
    val text: String,
    val enabled: Boolean,
)

class SubmitButtonPreviewParameterProvider : PreviewParameterProvider<SubmitButtonParams> {
    override val values: Sequence<SubmitButtonParams> =
        sequenceOf(
            SubmitButtonParams(text = "클릭 가능", enabled = true),
            SubmitButtonParams(text = "클릭 불가능", enabled = false),
        )
}
