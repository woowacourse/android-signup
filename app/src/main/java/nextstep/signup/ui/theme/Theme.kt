package nextstep.signup.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = GreenDark,
    onPrimary = White,
    primaryContainer = Green,
    secondary = Green,
    tertiary = Gray,
    surface = White,
    onSurface = Black,
)

private val DarkColorScheme = darkColorScheme(
    primary = Green,
    onPrimary = White,
    primaryContainer = GreenLight,
    secondary = GreenLight,
    tertiary = Gray,
    surface = Black,
    onSurface = White,
)

@Composable
fun SignUpTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme =
        if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
