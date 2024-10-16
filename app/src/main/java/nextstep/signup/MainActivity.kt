package nextstep.signup

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloView("레아")
        }
    }
}

@Composable
fun HelloView(name: String) {
    Text(
        text = "$name 안녕하세요!",
        fontSize = 20.sp,
        color = Color.White,
        modifier = Modifier
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color.Red, Color.Green),
                    start = Offset.Zero,
                    end = Offset.Infinite,
                ),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(16.dp)
    )
}

// 리컴포지션 예시1
@Composable
fun Counter() {
    var number by remember { mutableStateOf(0) }

    Column {
        Text(text = "카운터 앱!")
        Button(onClick = { number++ }) {
            Text(text = "카운팅: ", fontWeight = FontWeight.Bold)
            Text(text = number.toString())
        }
    }
}

// 리컴포지션 예시2
@SuppressLint("UnrememberedMutableState")
@Composable
fun Checker() {
    val checked = mutableStateOf(false)
    Column {
        Checkbox(
            checked = checked.value,
            onCheckedChange = { checked.value = !checked.value }
        )
    }
}
