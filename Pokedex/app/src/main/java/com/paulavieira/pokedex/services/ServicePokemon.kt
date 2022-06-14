package com.paulavieira.pokedex.services

import com.paulavieira.pokedex.models.Pokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface ServicePokemon {

    @GET("e45cbe99-9752-49a7-9ded-4c36ca999a48")
    fun getPokemon(): Call<List<Pokemon>>
}