package br.com.senaijandira.cadastro.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.os.SystemClock
import br.com.senaijandira.cadastro.model.Usuario
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class CadastroViewModel : ViewModel() {

    val loading = MutableLiveData<Boolean>()

    val error = MutableLiveData<Boolean>()

    fun cadastrarUsuario(user:Usuario){

        loading.postValue(true)

        error.postValue(false)

        //EFETUAR O CADASTRO EM SI
        doAsync {
            SystemClock.sleep(2000)

            uiThread {
               // cadastroUsuarioSucesso()
                error.postValue(true)
            }
        }
    }

    fun cadastroUsuarioSucesso(){

        loading.postValue(false)
    }
}