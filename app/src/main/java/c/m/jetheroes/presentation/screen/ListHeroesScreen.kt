package c.m.jetheroes.presentation.screen

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import c.m.jetheroes.data.HeroRepository
import c.m.jetheroes.presentation.component.CharacterHeader
import c.m.jetheroes.presentation.component.HeroListItem
import c.m.jetheroes.presentation.component.ScrollToTopButton
import c.m.jetheroes.presentation.component.SearchBar
import c.m.jetheroes.presentation.ui.theme.JetHeroesTheme
import c.m.jetheroes.presentation.viewmodel.JetHeroesViewModel
import c.m.jetheroes.presentation.viewmodel.ViewModelFactory
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListHeroesScreen(
    modifier: Modifier = Modifier,
    viewModel: JetHeroesViewModel = viewModel(factory = ViewModelFactory(HeroRepository())),
    navigateToHeroDetail: (String) -> Unit,
) {
    val groupedHeroes by viewModel.groupedHeroes.collectAsState()
    val query by viewModel.query

    Box(modifier = modifier) {
        val scope = rememberCoroutineScope()
        val listState = rememberLazyListState()
        val showButton: Boolean by remember {
            derivedStateOf { listState.firstVisibleItemIndex > 0 }
        }

        LazyColumn(
            state = listState,
            contentPadding = PaddingValues(bottom = 80.dp),
        ) {
            item {
                SearchBar(
                    modifier = Modifier.background(MaterialTheme.colors.primary),
                    query = query,
                    onQueryChange = viewModel::search,
                )
            }

            groupedHeroes.forEach { (initial, heroes) ->
                stickyHeader { CharacterHeader(char = initial) }

                items(heroes, key = { it.id }) { hero ->
                    HeroListItem(
                        modifier = Modifier
                            .fillMaxWidth()
                            .animateItemPlacement(tween(durationMillis = 100)),
                        id = hero.id,
                        name = hero.name,
                        photoUrl = hero.photoUrl,
                        navigateToHeroDetail = navigateToHeroDetail,
                    )
                }
            }
        }

        AnimatedVisibility(
            modifier = Modifier
                .padding(bottom = 30.dp)
                .align(Alignment.BottomCenter),
            visible = showButton,
            enter = fadeIn() + slideInVertically(),
            exit = fadeOut() + slideOutVertically()
        ) {
            ScrollToTopButton(onClick = {
                scope.launch {
                    listState.scrollToItem(index = 0)
                }
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ListHeroesScreenPreview() {
    JetHeroesTheme {
        ListHeroesScreen(
            navigateToHeroDetail = {}
        )
    }
}