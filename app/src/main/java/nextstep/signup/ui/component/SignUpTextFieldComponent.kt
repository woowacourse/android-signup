package nextstep.signup.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.signup.R
import nextstep.signup.ui.domain.SignUpModel
import nextstep.signup.ui.domain.SignUpState
import nextstep.signup.ui.domain.Username
import nextstep.signup.ui.theme.Blue50
import nextstep.signup.ui.theme.BlueGray20
import nextstep.signup.ui.theme.Gray50

@Composable
fun TextFieldComponent(
    signUpModel: SignUpModel,
    onTextChange: (newText: String) -> Unit,
    labelText: String,
    isPassword: Boolean = false,
    visualTransformation: VisualTransformation = PasswordVisualTransformation(),
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default.copy(
        keyboardType = KeyboardType.Password
    )
) {
    Column(
        modifier = Modifier
            .padding(vertical = 18.dp)
    ) {
        TextField(
            value = signUpModel.text,
            onValueChange = onTextChange,
            label = { Text(text = labelText) },
            modifier = Modifier
                .background(color = BlueGray20)
                .fillMaxWidth(),
            singleLine = true,
            isError = signUpModel.validState() is SignUpState.InValid,
            colors = TextFieldDefaults.colors(
                focusedLabelColor = Blue50,
                unfocusedLabelColor = Gray50,
                unfocusedContainerColor = BlueGray20,
                focusedContainerColor = BlueGray20,
                focusedIndicatorColor = Blue50,
                unfocusedIndicatorColor = Color.Black
            ),
            textStyle = TextStyle(
                color = Gray50,
                fontSize = 16.sp
            ),
            supportingText = {
                val signUpStateText = when (signUpModel.validState()) {
                    is SignUpState.Valid -> ""
                    SignUpState.InValid.Confirm -> stringResource(R.string.error_confirm)
                    SignUpState.InValid.Email -> stringResource(R.string.error_email)
                    SignUpState.InValid.PasswordLength -> stringResource(R.string.error_password_length)
                    SignUpState.InValid.PasswordType -> stringResource(R.string.error_password_type)
                    SignUpState.InValid.UserNameLength -> stringResource(R.string.error_username_length)
                    SignUpState.InValid.UserNameType -> stringResource(R.string.error_username_type)
                }
                Text(
                    modifier = Modifier.padding(start = 16.dp),
                    fontSize = 12.sp,
                    text = signUpStateText,
                    color = Color.Red,
                )
            },
            visualTransformation = if (isPassword) visualTransformation else VisualTransformation.None,
            keyboardOptions = if (isPassword) keyboardOptions else KeyboardOptions.Default
        )
    }
}

@Preview(
    backgroundColor = 0xFFFFFFFF,
    showBackground = true
)
@Composable
fun PreviewTextFieldComponent() {
    TextFieldComponent(
        signUpModel = Username(),
        onTextChange = {},
        labelText = "",
    )
}
