package com.paulavieira.pokedex.services

import com.paulavieira.pokedex.models.Pokemon
import retrofit2.Call
import retrofit2.http.GET

interface ServicePokemon {

    @GET("POKEMON")
    fun getPokemon(): Call<List<Pokemon>>
}