package br.com.senaijandira.cadastro

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        val MINIMO_CARACTERES_NOME = 3
        val MINIMO_CARACTERES_SENHA = 4
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btSalvar.setOnClickListener {

            val nome = etUserName.text.toString()
            val email = etEmail.text.toString()
            val senha = etPassword.text.toString()

            //validar nome
            if(!validarMinimoCaracteres(nome, MINIMO_CARACTERES_NOME)){
                etUserName.error = "Nome deve ter pelo menos ${MINIMO_CARACTERES_NOME} caracteres"
            }

            if(!validarTextoComArroba(email)){
                etEmail.error = "Email deve ter @"
            }

            if(validarMinimoCaracteres(senha, MINIMO_CARACTERES_SENHA)){
                etPassword.error = "Senha deve ter ${MINIMO_CARACTERES_SENHA} caracteres"
            }

            if(!textoContemNumero(senha)){
                etPassword.error = "Senha deve ter numero"
            }

            if(ehSequenciaNumerica(senha)){
                etPassword.error = "Senha não pode ser sequencia"
            }

        }
    }
}
