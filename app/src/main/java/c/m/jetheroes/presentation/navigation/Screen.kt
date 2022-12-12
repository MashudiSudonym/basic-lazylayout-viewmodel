package c.m.jetheroes.presentation.navigation

sealed class Screen(val route: String) {
    object ListHeroes : Screen("list-heroes")
    object AboutMe : Screen("about-me")
    object HeroDetail : Screen("hero-detail/{heroId}") {
        fun createRoute(heroId: String) = "hero-detail/$heroId"
    }
}
