package com.paulavieira.pokedex.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.paulavieira.pokedex.R
import com.paulavieira.pokedex.models.Account
import com.paulavieira.pokedex.services.RetrofitInitializer
import retrofit2.Call
import retrofit2.Response

class SenhaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_senha)

        var btnEsqueceuSenha = findViewById<Button>(R.id.btnEnviar)
        btnEsqueceuSenha.setOnClickListener {
           EnvioClick()
        }
    }

    fun EnvioClick() {

        var email = findViewById<EditText>(R.id.email)


        var account = Account()
        account.email = email.text.toString()

        var s = RetrofitInitializer().serviceAccount()
        var call = s.create(account)

        call.enqueue(object : retrofit2.Callback<Account> {
            override fun onResponse(call: Call<Account>, response: Response<Account>) {
                if (response.code() == 200) {
                    Toast.makeText(this@SenhaActivity, "Nova senha enviada", Toast.LENGTH_LONG).show()
                    showLogin()
                }
            }

            override fun onFailure(call: Call<Account>, t: Throwable) {
                Toast.makeText(this@SenhaActivity, "Tente Novamente", Toast.LENGTH_LONG).show()
            }
        })

    }

    fun showLogin() {
        var intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}