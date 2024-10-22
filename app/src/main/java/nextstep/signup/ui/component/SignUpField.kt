package nextstep.signup.ui.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import nextstep.signup.ui.model.SignUpResult
import nextstep.signup.ui.theme.Blue50

@Composable
fun SignUpField(
    @StringRes labelId: Int,
    value: String,
    signUpResult: SignUpResult,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    hidden: Boolean = false,
) {
    val textColor = if (signUpResult.isValid) Blue50 else Color.Red

    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        supportingText = {
            Text(
                text = signUpResult.errorMessage?.let { stringResource(it) } ?: "",
                color = textColor,
            )
        },
        colors =
            TextFieldDefaults.colors(
                focusedIndicatorColor = textColor,
                focusedLabelColor = textColor,
            ),
        maxLines = 1,
        label = { Text(text = stringResource(labelId)) },
        visualTransformation =
            if (!hidden) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
        modifier =
            modifier
                .fillMaxWidth()
                .padding(bottom = 36.dp),
    )
}
