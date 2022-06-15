package com.paulavieira.pokedex.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
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

        var btnFire = findViewById<Button>(R.id.btnFire)
        btnFire.setOnClickListener {
            var intent = Intent(this,FireActivity::class.java)
            startActivity(intent)

        }
        var btnWater = findViewById<Button>(R.id.btnWater)
        btnWater.setOnClickListener {
            var intent = Intent(this,Activity_water::class.java)
            startActivity(intent)

        }
        var btnGrass = findViewById<Button>(R.id.btnGrass)
        btnGrass.setOnClickListener {
            var intent = Intent(this,Activity_grass::class.java)
            startActivity(intent)

        }
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
                Toast.makeText(this@HomeActivity, "", Toast.LENGTH_LONG).show()
            }
        })

    }

    fun showHome(list: List<Home>) {
        var home = findViewById<ListView>(R.id.listaPoke)
        home.adapter = Adapter_Home(this, list)
    }



}




