package c.m.jetheroes.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import c.m.jetheroes.data.HeroRepository
import c.m.jetheroes.presentation.ui.theme.JetHeroesTheme
import c.m.jetheroes.presentation.viewmodel.JetHeroesViewModel
import c.m.jetheroes.presentation.viewmodel.ViewModelFactory
import coil.compose.AsyncImage

@Composable
fun HeroDetailScreen(
    modifier: Modifier = Modifier,
    heroId: String,
    viewModel: JetHeroesViewModel = viewModel(factory = ViewModelFactory(HeroRepository())),
    navigateBack: () -> Unit,
) {
    val heroById by viewModel.heroById.collectAsState()

    viewModel.getHeroById(heroId)

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
                model = heroById.photoUrl,
                contentDescription = null,
                modifier = Modifier
                    .size(256.dp)
                    .padding(16.dp),
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = heroById.name,
                fontWeight = FontWeight.Medium,
                style = TextStyle(
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier.padding(16.dp),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HeroDetailScreenPreview() {
    JetHeroesTheme {
        HeroDetailScreen(heroId = "", navigateBack = {})
    }
}