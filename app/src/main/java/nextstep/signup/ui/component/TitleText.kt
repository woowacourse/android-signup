package nextstep.signup.ui.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import nextstep.signup.R


@Composable
fun TitleText(text:String){
    Text(
        text = text,
        fontSize = 26.sp,
        color = Color.Black,
        fontWeight = FontWeight.Bold,
    )
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
private fun TitleTextPreview(){
    TitleText("테스트")
}