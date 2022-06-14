package com.paulavieira.pokedex.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ListView
import android.widget.Toast
import com.paulavieira.pokedex.R
import com.paulavieira.pokedex.models.Account
import com.paulavieira.pokedex.services.RetrofitInitializer
import com.paulavieira.pokedex.services.ServiceHome
import com.paulavieira.pokedex.ui.adapter.Adapter_Home
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var btnGo = findViewById<ImageButton>(R.id.btn_go)
        btnGo.setOnClickListener {
            GoClick()
        }
    }

    fun GoClick() {

        var intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }


}