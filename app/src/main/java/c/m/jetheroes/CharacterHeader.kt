package c.m.jetheroes

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import c.m.jetheroes.ui.theme.JetHeroesTheme

@Composable
fun CharacterHeader(
    modifier: Modifier = Modifier,
    char: Char,
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colors.primary,
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            text = char.toString(),
            fontWeight = FontWeight.Black,
            color = Color.White,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CharacterHeaderPreview() {
    JetHeroesTheme {
        CharacterHeader(char = Char(1))
    }
}