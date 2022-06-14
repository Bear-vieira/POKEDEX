package com.paulavieira.pokedex.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    val URL = "https://run.mocky.io/v3/"

    val retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getServicePokemon(): ServicePokemon{
        return retrofit.create((ServicePokemon::class.java))
    }
    fun getServiceHome(): ServiceHome{
        return retrofit.create((ServiceHome::class.java))
    }

    fun getServiceElements(): ServiceElements{
        return retrofit.create((ServiceElements::class.java))
    }

    fun serviceAccount(): ServiceAccount {
        return retrofit.create(ServiceAccount::class.java)
    }

}
