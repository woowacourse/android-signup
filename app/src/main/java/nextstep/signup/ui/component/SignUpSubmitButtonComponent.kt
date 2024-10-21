package nextstep.signup.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.signup.ui.model.SignUpState
import nextstep.signup.ui.theme.Blue50
import nextstep.signup.ui.theme.Gray50

@Composable
fun SignUpSubmitButtonComponent(
    signUpStates: List<SignUpState>,
    buttonText: String,
    onButtonClick: () -> Unit
) {
    val isValid = signUpStates.all { signUpState ->
        signUpState == SignUpState.Valid
    }

    Button(
        onClick = onButtonClick,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(100.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Blue50
        ),
        enabled = isValid
    ) {
        Text(
            text = buttonText,
            color = if (isValid) Color.White else Gray50,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 15.dp)
        )
    }
}

@Preview(
    backgroundColor = 0xFFFFFFFF,
    showBackground = true
)
@Composable
fun PreviewSubmitButtonComponent() {
    SignUpSubmitButtonComponent(
        signUpStates = listOf(),
        buttonText = "",
        onButtonClick = {}
    )
}
