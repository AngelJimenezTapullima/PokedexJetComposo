package com.isil.apipokemon.ViewModel

import androidx.lifecycle.viewmodel.ktx.R
import com.isil.apipokemon.Models.PokemonDetalle
import com.isil.apipokemon.Network.RetrofitPokemon
import retrofit2.Response

class Repository {

    suspend fun getDetallesId(id: Int): Response<PokemonDetalle> {
        return RetrofitPokemon.retrofit.getDetallePokemon(id = id)
    }

}

