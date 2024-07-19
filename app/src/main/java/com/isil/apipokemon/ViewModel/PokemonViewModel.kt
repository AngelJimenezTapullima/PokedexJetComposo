package com.isil.apipokemon.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.isil.apipokemon.Models.PokemonModel
import com.isil.apipokemon.Models.Pokemones
import com.isil.apipokemon.Network.APIPokemon
import com.isil.apipokemon.Network.RetrofitPokemon
import com.isil.apipokemon.State.PokemonState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PokemonViewModel: ViewModel() {

    private val repository = Repository()
    var id by mutableStateOf(0)

    var state by mutableStateOf(PokemonState())
        private set
    var response: List<Pokemones> by mutableStateOf(listOf())
        private set

    init {
        mostrarPokemon()
    }

    fun mostrarPokemon() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true
            )
            val interfacePokemon = APIPokemon.getInstance()
            val postPokemon = interfacePokemon.getPokemons()
            response = postPokemon
            state = state.copy(
                isLoading = false,
                Pokemons = response
            )
        }
    }

    fun mostrarPokemonbyId(){
        viewModelScope.launch {
            val response = repository.getDetallesId(id = id)
            state = state.copy(
                detallePokemon = response.body()!!
            )
        }
    }

    //clase
//    private val _pokemones = MutableStateFlow<List<Pokemones>>(emptyList())
//    val pokemones = _pokemones.asStateFlow()
//
//    init {
//        mostrarPokemones()
//    }
//
//    private fun mostrarPokemones() {
//        viewModelScope.launch {
//            val response = RetrofitPokemon.retrofit.getPokemones()
//            _pokemones.value = response.body()?.listaPokemones ?: emptyList()
//        }
//    }
}
