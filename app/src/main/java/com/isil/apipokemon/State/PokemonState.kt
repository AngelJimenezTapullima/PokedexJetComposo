package com.isil.apipokemon.State

import com.isil.apipokemon.Models.PokemonDetalle
import com.isil.apipokemon.Models.PokemonModel
import com.isil.apipokemon.Models.Pokemones

data class PokemonState(
    val Pokemons: List<Pokemones> = emptyList(),
    val isLoading: Boolean = false,
    val detallePokemon: PokemonDetalle = PokemonDetalle()
)
