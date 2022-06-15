package com.paulavieira.pokedex.ui.activities

import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.paulavieira.pokedex.R
import com.paulavieira.pokedex.models.Elements
import com.paulavieira.pokedex.models.Home
import com.paulavieira.pokedex.services.RetrofitInitializer
import com.paulavieira.pokedex.ui.adapter.Adapter_Grass
import retrofit2.Call
import retrofit2.Response

class Activity_grass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_grass)

        getLista()
    }

    fun getLista() {

        var s = RetrofitInitializer().getServiceElements()
        var call = s.getLista()

        call.enqueue(object : retrofit2.Callback<List<Elements>> {

            override fun onResponse(
                call: Call<List<Elements>>,
                response: Response<List<Elements>>
            ) {
                response.body()?.let {
                    showLista(it)
                }
            }

            override fun onFailure(call: Call<List<Elements>>, t: Throwable) {
                Toast.makeText(this@Activity_grass, "", Toast.LENGTH_LONG).show()
            }
        })

    }

    fun showLista(list: List<Elements>) {
        var list3 = list.filter {
            it.type  == "Grass"
        }
        var lista = findViewById<ListView>(R.id.listGrass)
        lista.adapter = Adapter_Grass(this, list3)
    }


}