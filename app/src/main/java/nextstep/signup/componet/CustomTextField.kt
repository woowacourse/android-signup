package nextstep.signup.componet

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.signup.R
import nextstep.signup.model.InputValidation
import nextstep.signup.ui.theme.Blue50

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    inputValidation: InputValidation,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    TextField(
        modifier = modifier.fillMaxWidth(),
        label = {
            Text(
                text = label,
                fontWeight = FontWeight.W400,
            )
        },
        value = value,
        onValueChange = onValueChange,
        textStyle =
            TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.W400,
            ),
        singleLine = true,
        colors =
            TextFieldDefaults.colors(
                focusedIndicatorColor = Blue50,
                focusedLabelColor = Blue50,
                cursorColor = Blue50,
            ),
        visualTransformation = visualTransformation,
        isError = inputValidation.isError,
        supportingText = {
            inputValidation.stringRes ?: return@TextField
            Text(text = stringResource(id = inputValidation.stringRes))
        },
    )
}

@Preview
@Composable
fun CustomTextFieldPreview() {
    CustomTextField(
        modifier = Modifier.padding(horizontal = 32.dp, vertical = 18.dp),
        value = "",
        onValueChange = { },
        label = stringResource(R.string.username_input),
        inputValidation = InputValidation(isError = false),
        visualTransformation = PasswordVisualTransformation(),
    )
}
