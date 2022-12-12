package c.m.jetheroes.data

import c.m.jetheroes.model.Hero
import c.m.jetheroes.model.HeroesData

class HeroRepository {
    fun getHeroes(): List<Hero> {
        return HeroesData.heroes
    }

    fun searchHeroes(query: String): List<Hero> {
        return HeroesData.heroes.filter {
            it.name.contains(query, ignoreCase = true)
        }
    }

    fun getHeroById(id: String): Hero {
        return HeroesData.heroes.filter {
            it.id.contains(id, ignoreCase = true)
        }[0]
    }
}