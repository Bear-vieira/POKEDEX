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

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var btnRegister = findViewById<Button>(R.id.btnCadastrar) // Botão de cadastro
        btnRegister.setOnClickListener {
            registerClick()
        }
    }

     fun registerClick() {

        var email = findViewById<EditText>(R.id.email)
        var password = findViewById<EditText>(R.id.senha)

        var account = Account()
        account.email = email.text.toString()
        account.password = password.text.toString()

        var s = RetrofitInitializer().serviceAccount()
        var call = s.create(account)

        call.enqueue(object : retrofit2.Callback<Account> {
            override fun onResponse(call: Call<Account>, response: Response<Account>) {
                if (response.code() == 200) {
                    Toast.makeText(this@RegisterActivity, "Conta criada com sucesso!", Toast.LENGTH_LONG).show()
                    showLogin()
                }
            }

            override fun onFailure(call: Call<Account>, t: Throwable) {
                Toast.makeText(this@RegisterActivity, "Ops", Toast.LENGTH_LONG).show()
            }
        })

    }

    fun showLogin() {
        var intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}