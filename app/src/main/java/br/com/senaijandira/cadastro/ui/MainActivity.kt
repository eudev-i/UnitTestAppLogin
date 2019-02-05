package br.com.senaijandira.cadastro.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import br.com.senaijandira.cadastro.R
import br.com.senaijandira.cadastro.viewmodel.CadastroViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        val MINIMO_CARACTERES_NOME = 3
        val MINIMO_CARACTERES_SENHA = 4
    }

    val viewModel by lazy {
        ViewModelProviders.of(this).get(CadastroViewModel::class.java)
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

            viewModel.cadastrarUsuario()

        }

        viewModel.loading.observe(this, Observer {
            updateLoading(it)
        })
    }

    fun updateLoading(loading:Boolean?){
        loading?.let{
            if(loading){
                btSalvar.visibility = View.GONE
                progressBar.visibility = View.VISIBLE
            }else{
                btSalvar.visibility = View.VISIBLE
                progressBar.visibility = View.GONE
            }
        }
    }
}
