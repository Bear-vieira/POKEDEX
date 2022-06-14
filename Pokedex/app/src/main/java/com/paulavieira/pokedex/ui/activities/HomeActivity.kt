package com.paulavieira.pokedex.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.core.content.ContextCompat.startActivity
import com.paulavieira.pokedex.R
import com.paulavieira.pokedex.models.Home
import com.paulavieira.pokedex.services.RetrofitInitializer
import com.paulavieira.pokedex.ui.adapter.Adapter_Home
import retrofit2.Call
import retrofit2.Response

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        getHome()
    }

    fun getHome() {

        var s = RetrofitInitializer().getServiceHome()
        var call = s.getHome()

        call.enqueue(object : retrofit2.Callback<List<Home>> {
            override fun onResponse(
                call: Call<List<Home>>,
                response: Response<List<Home>>
            ) {
                response.body()?.let {
                    showHome(it)
                }
            }

            override fun onFailure(call: Call<List<Home>>, t: Throwable) {

            }
        })

    }

    fun showHome(list: List<Home>) {
        var friends = findViewById<ListView>(R.id.listaPoke)
        friends.adapter = Adapter_Home(this, list)
    }

}




