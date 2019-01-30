package br.com.senaijandira.cadastro

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.widget.Button
import android.widget.EditText
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val rule = ActivityTestRule(MainActivity::class.java)

    lateinit var activity: MainActivity

    @Before
    fun setUp(){
        activity = rule.activity
    }

    @Test
    fun activityCarregaCorretamente(){

        val userName = activity.findViewById<EditText>(R.id.etUserName)
        val email = activity.findViewById<EditText>(R.id.etEmail)
        val senha = activity.findViewById<EditText>(R.id.etPassword)

        Assert.assertThat(userName.hint.toString(), equalTo("Nome de usuário"))
        Assert.assertThat(email.hint.toString(), equalTo("E-Mail"))
        Assert.assertThat(senha.hint.toString(), equalTo("Senha"))

    }

    @Test
    fun botaoCarrregaCorretamente(){
        //VERIFICAR SE O BOTÃO ESTA CARREGADO NA TELA
        //E SE ELE POSSUI O TEXTO: SALVAL

        val btnSalvar = activity.findViewById<Button>(R.id.btSalvar)

        Assert.assertThat(btnSalvar.text.toString(), equalTo("Salvar"))
    }
}