package com.paulavieira.pokedex.services

import com.paulavieira.pokedex.models.Home
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface ServiceHome {
    @GET("e45cbe99-9752-49a7-9ded-4c36ca999a48")
    fun getHome(): Call<List<Home>>
}