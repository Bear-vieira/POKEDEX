package com.paulavieira.pokedex.ui.activities

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.paulavieira.pokedex.R
import com.paulavieira.pokedex.models.Elements
import com.paulavieira.pokedex.services.RetrofitInitializer
import com.paulavieira.pokedex.ui.adapter.Adapter_Water
import retrofit2.Call
import retrofit2.Response

class Activity_water: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_water)

        getLista()
    }

    fun getLista() {

        var s = RetrofitInitializer().getServiceElements()
        var call = s.getLista()

        call.enqueue(object : retrofit2.Callback<List<Elements>> {

            override fun onResponse(call: Call<List<Elements>>, response: Response<List<Elements>>) {

                if (response.code() == 200) {

                    response.body()?.let {
                        showLista(it)
                    }

                }

            }

            override fun onFailure(call: Call<List<Elements>>, t: Throwable) {

            }
        })

    }

    fun showLista(list: List<Elements>) {
        var lista = findViewById<ListView>(R.id.listFire)
        lista.adapter = Adapter_Water(this, list)
    }


}