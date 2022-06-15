package com.paulavieira.pokedex.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.paulavieira.pokedex.R
import com.paulavieira.pokedex.models.Elements
import com.paulavieira.pokedex.services.RetrofitInitializer
import com.paulavieira.pokedex.ui.adapter.Adapter_Fire
import retrofit2.Call
import retrofit2.Response

class FireActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_fire)

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
                Toast.makeText(this@FireActivity, "", Toast.LENGTH_LONG).show()
            }
        })

    }

    fun showLista(list: List<Elements>) {

        var lista1 = list.filter {
            it.type1.type == "Fire"
        }

        var lista = findViewById<ListView>(R.id.listFire)
        lista.adapter = Adapter_Fire(this, lista1)


    }


}
