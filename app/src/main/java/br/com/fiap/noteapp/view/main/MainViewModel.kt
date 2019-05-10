package br.com.fiap.noteapp.view.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.fiap.noteapp.model.Nota
import br.com.fiap.noteapp.repository.NotaRepository

class MainViewModel: ViewModel() {

    val notas: MutableLiveData<List<Nota>> = MutableLiveData()
    val mensagemErro: MutableLiveData<String> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()

    fun buscarNotas() {
        isLoading.value = true

        val notaRepository = NotaRepository()

        notaRepository.getNotas({
            notas.value = it
            isLoading.value = false
        },{
            mensagemErro.value = it?.message
            isLoading.value = false
        })
    }

}