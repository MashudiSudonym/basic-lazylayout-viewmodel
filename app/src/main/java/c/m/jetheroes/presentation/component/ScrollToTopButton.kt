package c.m.jetheroes.presentation.component

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import c.m.jetheroes.presentation.ui.theme.JetHeroesTheme

@Composable
fun ScrollToTopButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(
        modifier = modifier
            .shadow(elevation = 10.dp, shape = CircleShape)
            .clip(CircleShape)
            .size(56.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White,
            contentColor = MaterialTheme.colors.primary,
        )
    ) {
        Icon(
            imageVector = Icons.Filled.KeyboardArrowUp,
            contentDescription = null,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ScrollToTopButtonPreview() {
    JetHeroesTheme {
        ScrollToTopButton(onClick = {})
    }
}