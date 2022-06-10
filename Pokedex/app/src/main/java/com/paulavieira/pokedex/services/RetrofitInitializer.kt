package com.paulavieira.pokedex.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    val URL = "https://pokeapi.co/api/v2/pokemon/ditto" //exemplo de API, não sei se é o link certo

    val retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getServicePokemon(): ServicePokemon{
        return retrofit.create((ServicePokemon::class.java))
    }
}
