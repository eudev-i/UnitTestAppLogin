package br.com.senaijandira.cadastro.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.os.SystemClock
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class CadastroViewModel : ViewModel() {

    val loading = MutableLiveData<Boolean>()



    fun cadastrarUsuario(){

        loading.postValue(true)

        //EFETUAR O CADASTRO EM SI
        doAsync {
            SystemClock.sleep(2000)

            uiThread {
                cadastroUsuarioSucesso()
            }
        }
    }

    fun cadastroUsuarioSucesso(){

        loading.postValue(false)
    }
}