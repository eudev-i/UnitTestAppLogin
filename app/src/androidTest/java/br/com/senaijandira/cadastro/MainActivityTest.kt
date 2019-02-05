package br.com.senaijandira.cadastro

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.widget.Button
import android.widget.EditText
import br.com.senaijandira.cadastro.ui.MainActivity
import org.hamcrest.CoreMatchers.equalTo
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
    fun a_activityCarregaCorretamente(){

        val userName = activity.findViewById<EditText>(R.id.etUserName)
        val email = activity.findViewById<EditText>(R.id.etEmail)
        val senha = activity.findViewById<EditText>(R.id.etPassword)

        Assert.assertThat(userName.hint.toString(), equalTo("Nome de usuário"))
        Assert.assertThat(email.hint.toString(), equalTo("E-Mail"))
        Assert.assertThat(senha.hint.toString(), equalTo("Senha"))

    }

    @Test
    fun b_botaoCarrregaCorretamente(){
        //VERIFICAR SE O BOTÃO ESTA CARREGADO NA TELA
        //E SE ELE POSSUI O TEXTO: SALVAL

        val btnSalvar = activity.findViewById<Button>(R.id.btSalvar)

        Assert.assertThat(btnSalvar.text.toString(), equalTo("Salvar"))
    }

    @Test
    fun c_testeNomeComTresCaracteres(){

        //ACESSAR O COMPONENTE DA TELA COM DETERMINADO HINT
        val userName = onView(withHint("Nome de usuário"))

        //ESCREVER O TEXTO NA CAIXINHA
        userName.perform(typeText("al"))

        //CLICA NO BOTÃO COM TEXTO 'Salvar'
        onView(withText("Salvar")).perform(click())

        val textError = "Nome deve ter pelo menos ${MainActivity.MINIMO_CARACTERES_NOME} caracteres"

        userName.check(matches(hasErrorText(textError)))
    }

    @Test
    fun d_testeEmailComArroba(){

        //ACESSAR O COMPONENTE DA TELA COM DETERMINADO HINT
        val email = onView(withHint("E-Mail"))

        //ESCREVER O TEXTO NA CAIXINHA
        email.perform(typeText("vi.com"))

        //CLICA NO BOTÃO COM TEXTO 'Salvar'
        onView(withText("Salvar")).perform(click())

        val textError = "Email deve ter @"

        email.check(matches(hasErrorText(textError)))
    }

    @Test
    fun e_senhaMinimoQuatroCaracteres(){

        //ACESSAR O COMPONENENTE DA TELA COM DETERMINADO HINT
        val senha = onView(withHint("Senha"))

        //ESCREVER O TEXTO NA CAIXINHA
        senha.perform(typeText("5283"))

        //CLICA NO BOTÃO
        onView(withText("Salvar")).perform(click())

        val textError = "Senha deve ter ${MainActivity.MINIMO_CARACTERES_SENHA} caracteres"

        senha.check(matches(hasErrorText(textError)))
    }

    @Test
    fun f_senhaComNumero(){

        //ACESSAR O COMPONENTE DA TELA COM DETERMINADO HINT
        val senha = onView(withHint("Senha"))

        //ESCREVER O TEXTO NA CAIXINHA
        senha.perform(typeText("estoucomsono"))

        //CLICA NO BOTÃO
        onView(withText("Salvar")).perform(click())

        val textError = "Senha deve ter numero"

        senha.check(matches(hasErrorText(textError)))
    }

    @Test
    fun g_senhaSemSequencia(){

        //ACESSAR O COMPONENTE DA TELA COM DETERMINADO HINT
        val senha = onView(withHint("Senha"))

        //ESCREVER O TEXTO NA CAIXINHA
        senha.perform(typeText("12345"))

        //CLICA NO BOTÃO
        onView(withText("Salvar")).perform(click())

        val textError = "Senha não pode ser sequencia"

        senha.check(matches(hasErrorText(textError)))
    }
}