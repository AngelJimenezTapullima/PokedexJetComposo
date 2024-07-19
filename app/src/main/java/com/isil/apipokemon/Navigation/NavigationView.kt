package com.isil.apipokemon.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.isil.apipokemon.ViewModel.PokemonViewModel
import com.isil.apipokemon.Views.PokemonDetailView
import com.isil.apipokemon.Views.PokemonView
import com.isil.apipokemon.Views.Pruebas

@Composable
fun NavigationView(modifier: Modifier, viewModel: PokemonViewModel){
    val NavController = rememberNavController()
    NavHost(navController = NavController, startDestination = AppView.Pokemons.route){
        composable(AppView.Pokemons.route){ PokemonView( NavController, viewModel) }
        composable(AppView.Pruebas.route){ Pruebas( NavController, viewModel ) }
        composable(
            route = AppView.Detalle.route + "/{id}",
            arguments = listOf(
                navArgument("id"){ type = NavType.IntType }
            )
        ){
            id ->
            id.arguments?.getInt("id")?.let {
                Id ->
                PokemonDetailView(
                    NavController = NavController,
                    viewModel = viewModel,
                    id = Id
                )
            }
        }
    }
}

