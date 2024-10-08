package nextstep.signup.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.signup.R
import nextstep.signup.componet.CustomButton
import nextstep.signup.componet.CustomText
import nextstep.signup.componet.CustomTextField
import nextstep.signup.ui.theme.Blue50

data class InputField(
    @StringRes val titleId: Int,
    val isPassword: Boolean = false,
)

@Composable
fun MainScreen() {
    val inputFields =
        listOf(
            InputField(R.string.username_input),
            InputField(R.string.email_input),
            InputField(R.string.password_input, isPassword = true),
            InputField(R.string.password_confirm_input, isPassword = true),
        )

    val inputStates = remember { inputFields.map { mutableStateOf("") } }

    Column {
        Spacer(modifier = Modifier.height(60.dp))
        CustomText(
            modifier = Modifier.fillMaxWidth(),
            titleResId = R.string.sign_up_title,
        )

        Spacer(modifier = Modifier.height(18.dp))
        inputFields.forEachIndexed { index, field ->
            CustomTextField(
                modifier = Modifier.padding(horizontal = 32.dp, vertical = 18.dp),
                value = inputStates[index].value,
                onValueChange = { newValue -> inputStates[index].value = newValue },
                labelResId = field.titleId,
                visualTransformation = if (field.isPassword) PasswordVisualTransformation() else VisualTransformation.None,
            )
        }

        Spacer(modifier = Modifier.height(24.dp))
        CustomButton(
            modifier = Modifier.padding(horizontal = 32.dp),
            shape = RoundedCornerShape(100.dp),
            buttonColors = ButtonDefaults.buttonColors(containerColor = Blue50),
            titleResId = R.string.sign_up_button,
            onClick = {},
        )
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}
