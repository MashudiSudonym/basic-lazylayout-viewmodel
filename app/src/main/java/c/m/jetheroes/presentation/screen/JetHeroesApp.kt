package c.m.jetheroes.presentation.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import c.m.jetheroes.presentation.navigation.Screen
import c.m.jetheroes.presentation.ui.theme.JetHeroesTheme

@ExperimentalFoundationApi
@Composable
fun JetHeroesAppScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        modifier = modifier,
        floatingActionButton = {
            if (currentRoute == Screen.ListHeroes.route) {
                FloatingActionButton(onClick = {
                    navController.navigate(Screen.AboutMe.route)
                }) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = "about_page",
                        tint = Color.White,
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            modifier = modifier.padding(innerPadding),
            navController = navController,
            startDestination = Screen.ListHeroes.route,
        ) {
            composable(Screen.ListHeroes.route) {
                ListHeroesScreen(
                    navigateToHeroDetail = { heroId ->
                        navController.navigate(Screen.HeroDetail.createRoute(heroId))
                    },
                )
            }
            composable(
                Screen.HeroDetail.route,
                arguments = listOf(
                    navArgument("heroId") {
                        type = NavType.StringType
                    }
                )
            ) {
                val heroId = it.arguments?.getString("heroId") ?: ""

                HeroDetailScreen(
                    heroId = heroId,
                    navigateBack = { navController.navigateUp() })
            }
            composable(Screen.AboutMe.route) {
                AboutMeScreen(
                    navigateBack = { navController.navigateUp() }
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
private fun JetHeroesAppScreenPreview() {
    JetHeroesTheme {
        JetHeroesAppScreen()
    }
}