package com.isil.apipokemon.Models

import com.google.gson.annotations.SerializedName

data class PokemonModel(
    var listaPokemones: List<Pokemones>
)

data class Pokemones(

    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("type")
    var type: String,

    @SerializedName("imageUrl")
    var imageUrl: String
)

data class PokemonDetalle(

    @SerializedName("id")
    var id: Int = 0,

    @SerializedName("name")
    var name: String = "",

    @SerializedName("type")
    var type: String = "",

    @SerializedName("attack")
    var attack: Int = 0,

    @SerializedName("defense")
    var defense: Int = 0,

    @SerializedName("imageUrl")
    var imageUrl: String = "",

    @SerializedName("description")
    var description: String = ""

)

