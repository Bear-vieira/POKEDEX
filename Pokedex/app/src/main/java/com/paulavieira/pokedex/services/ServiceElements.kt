package com.paulavieira.pokedex.services

import com.paulavieira.pokedex.models.Elements
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface ServiceElements {

    @GET("813c2bcd-8c83-4361-ac93-191cf52c61c7")
    fun getLista(): Call<List<Elements>>
}
