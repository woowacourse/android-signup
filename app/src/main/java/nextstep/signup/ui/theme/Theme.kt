package nextstep.signup.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    onPrimary = PurpleGrey80,
    background = PurpleGrey40,
    surface = Color.Black,
    onSurface = Color.White,
    onSurfaceVariant = White,
    surfaceVariant = PurpleGrey80,
    error = Red60,
    onError = Red20
)

private val LightColorScheme = lightColorScheme(
    primary = Blue50,
    onPrimary = BlueGrey20,
    background = White,
    surface = Color.White,
    onSurface = Color.Black,
    onSurfaceVariant = Gray80,
    surfaceVariant = BlueGrey20,
    error = Red60,
    onError = Red20
)

@Composable
fun SignupTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
