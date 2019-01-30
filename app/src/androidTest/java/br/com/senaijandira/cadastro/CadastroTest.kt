package br.com.senaijandira.cadastro

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.widget.EditText
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CadastroTest{

    @get:Rule
    val rule = ActivityTestRule(MainActivity::class.java)

    lateinit var activity : MainActivity

    @Before
    fun setUp(){
        activity = rule.activity
    }

    @Test
    fun loadActivitySucess(){
        val userName = activity.findViewById<EditText>(R.id.etUserName)
        val email = activity.findViewById<EditText>(R.id.etEmail)
        val password = activity.findViewById<EditText>(R.id.etPassword)

        Assert.assertThat(userName.hint.toString(), equalTo("Nome de usuário"))
        Assert.assertThat(email.hint.toString(), equalTo("E-Mail"))
        Assert.assertThat(password.hint.toString(), equalTo("Senha"))
    }



}