package com.isil.apipokemon.Network

import com.isil.apipokemon.Utils.Util
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URL

object RetrofitPokemon {
    val retrofit: APIPokemon by lazy {
        Retrofit
            .Builder()
            .baseUrl(Util.URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIPokemon::class.java)
    }
}

