package c.m.jetheroes.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import c.m.jetheroes.presentation.ui.theme.JetHeroesTheme
import coil.compose.AsyncImage

@Composable
fun HeroListItem(
    modifier: Modifier = Modifier,
    name: String,
    photoUrl: String,
) {
    Row(
        modifier = modifier.clickable {},
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AsyncImage(
            modifier = Modifier
                .padding(8.dp)
                .size(60.dp)
                .clip(CircleShape),
            model = photoUrl,
            contentDescription = null,
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1F)
                .padding(start = 16.dp),
            text = name,
            fontWeight = FontWeight.Medium,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HeroListItemPreview() {
    JetHeroesTheme {
        HeroListItem(
            name = "H.O.S Cokroaminoto",
            photoUrl = "",
        )
    }
}