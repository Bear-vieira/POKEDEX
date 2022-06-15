package com.paulavieira.pokedex.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.paulavieira.pokedex.R
import com.paulavieira.pokedex.models.Account
import com.paulavieira.pokedex.services.RetrofitInitializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var btnLogin = findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            login()
        }
        var btncadastro= findViewById<TextView>(R.id.btnCadastro)
        btncadastro.setOnClickListener {
            var intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }
        var btnEsqueceuSenha= findViewById<TextView>(R.id.btnEsqueceuSenha)
        btnEsqueceuSenha.setOnClickListener {
            var intent = Intent(this,SenhaActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun login() {
        var s = RetrofitInitializer().serviceAccount()

        var account = Account()
        var login = findViewById<EditText>(R.id.email)
        var password = findViewById<EditText>(R.id.senha)
        account.email = login.text.toString()
        account.password = password.text.toString()

        var call = s.auth(account)

        call.enqueue(object : Callback<Account> {
            override fun onResponse(call: Call<Account>, response: Response<Account>) {

                if (response.code() == 200) {

                    response.body()?.let {
                        showPokemon(it)
                    }

                } else {
                    Toast.makeText(
                        this@LoginActivity,
                        "Usuário ou Senha Inválidos",
                        Toast.LENGTH_LONG
                    ).show()
                }

            }

            override fun onFailure(call: Call<Account>, t: Throwable) {
                Toast.makeText(
                    this@LoginActivity,
                    "Ops",
                    Toast.LENGTH_LONG
                ).show()
            }
        })

    }

    fun showPokemon(account: Account) {
        var intent = Intent(this, HomeActivity::class.java)
        intent.putExtra("token", account.token)
        startActivity(intent)
    }
}