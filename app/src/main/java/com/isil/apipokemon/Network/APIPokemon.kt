package com.isil.apipokemon.Network

import com.isil.apipokemon.Models.PokemonDetalle
import com.isil.apipokemon.Models.PokemonModel
import com.isil.apipokemon.Models.Pokemones
import com.isil.apipokemon.Utils.Util
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface APIPokemon {
    @GET("pokemon.json")
    suspend fun getPokemons(): List<Pokemones>

    @GET("pokemon/{id}.json")
    suspend fun getDetallePokemon(
        @Path("id")id: Int
    ): Response<PokemonDetalle>



    //Clase
//    @GET("pokemon.json")
//    suspend fun getPokemones(): Response<PokemonModel>

//    @GET("pokemon/{id}.json")
//    suspend fun getDetalleId(
//        @Path("id")id: Int
//    ): Response<PokemonDetalle>

    companion object{
        private var apiPokemon: APIPokemon? = null
        fun getInstance(): APIPokemon{
            if (apiPokemon == null){
                apiPokemon =
                    Retrofit
                        .Builder()
                        .baseUrl(Util.URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(APIPokemon::class.java)
            }
            return apiPokemon!!
        }
    }
}