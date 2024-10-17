package nextstep.signup.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.signup.R

@Composable
fun SignUpToast(
    message: String,
) {
    Box(
        modifier = Modifier
            .padding(top = 30.dp)
            .padding(horizontal = 20.dp)
            .background(
                color = Color.Green,
                shape = RoundedCornerShape(20.dp)
            )
            .fillMaxWidth()
            .padding(
                vertical = 15.dp,
                horizontal = 20.dp,
            )
    ) {
        Text(
            text = message,
            color = Color.Black,
            fontSize = 16.sp,
        )
    }
}

@Preview
@Composable
fun PreviewSignUpToast(){
    SignUpToast(stringResource(R.string.confirm_sign_up))
}
