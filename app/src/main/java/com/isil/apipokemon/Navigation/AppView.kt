package com.isil.apipokemon.Navigation

sealed class AppView(val route: String){
    object Pokemons: AppView("pokemons")
    object Detalle: AppView("detalle")
    object Pruebas: AppView("pruebas")
}