package nextstep.signup.ui.component

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import nextstep.signup.ui.theme.Blue50
import nextstep.signup.ui.theme.BlueGray

@Composable
fun SignUpInformationTextField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    isValid: Boolean,
    errorMessage: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    TextField(
        modifier = modifier,
        label = { Text(label) },
        value = value,
        onValueChange = onValueChange,
        isError = value.isNotEmpty() && !isValid,
        supportingText = { if (value.isNotEmpty()) Text(errorMessage) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        visualTransformation = visualTransformation,
        colors =
            TextFieldDefaults.colors(
                focusedContainerColor = BlueGray,
                unfocusedContainerColor = BlueGray,
                focusedIndicatorColor = Blue50,
                focusedLabelColor = Blue50,
                cursorColor = Blue50,
            ),
    )
}

@Preview
@Composable
fun SignUpInformationTextFieldPreview(
    @PreviewParameter(SignUpInformationPreviewParameterProvider::class) params: SignUpInformationTextFieldParams,
) {
    SignUpInformationTextField(
        label = "",
        value = params.value,
        onValueChange = {},
        isValid = params.isValid,
        errorMessage = params.errorMessage,
    )
}

data class SignUpInformationTextFieldParams(
    val value: String,
    val isValid: Boolean,
    val errorMessage: String,
)

class SignUpInformationPreviewParameterProvider : PreviewParameterProvider<SignUpInformationTextFieldParams> {
    override val values: Sequence<SignUpInformationTextFieldParams> =
        sequenceOf(
            SignUpInformationTextFieldParams(value = "유효한 입력", isValid = true, errorMessage = ""),
            SignUpInformationTextFieldParams(
                value = "유효하지 않은 입력",
                isValid = false,
                errorMessage = "에러 메시지",
            ),
        )
}
