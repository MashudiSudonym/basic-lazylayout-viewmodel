package c.m.jetheroes.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import c.m.jetheroes.presentation.ui.theme.JetHeroesTheme
import coil.compose.AsyncImage

@Composable
fun AboutMeScreen(
    modifier: Modifier = Modifier,
    navigateBack: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(modifier = modifier) {
                IconButton(onClick = { navigateBack() }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AsyncImage(
                model = "https://avatars.githubusercontent.com/u/4616935?s=400&u=17ba25dcb13f9cc3a6d3cd0dd1001b0d07b824b4&v=4",
                contentDescription = null,
                modifier = Modifier
                    .padding(16.dp)
                    .size(256.dp)
                    .clip(CircleShape),
            )
            Text(
                text = "Muhamad Mashudi Ardi Winata",
                fontWeight = FontWeight.Medium,
                style = TextStyle(
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier.padding(16.dp),
            )
            Text(
                text = "muhamadmashudiardiwinata@gmail.com",
                style = TextStyle(
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier.padding(16.dp),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AboutMeScreenPreview() {
    JetHeroesTheme {
        AboutMeScreen(navigateBack = {})
    }
}