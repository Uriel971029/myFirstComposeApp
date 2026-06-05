package com.example.myfirstappincompose.ui.consultant.list.viewmodel

import android.app.Notification
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myfirstappincompose.data.remote.network.RetrofitClient
import com.example.myfirstappincompose.ui.consultant.list.interfaces.PokemonActions
import kotlinx.coroutines.launch

class PokemonListViewModel : ViewModel() {

    fun onAction(action : PokemonActions) {
        when(action) {
            PokemonActions.Init -> {
                setUpUI()
            }
        }
    }


    private fun setUpUI() {
        viewModelScope.launch {
            val response = RetrofitClient.apiService.getPokemonList()
        }
    }

}



/*

    Concurrencia

    1.- lista de usuarios (2 segundos)
    2.- lista de comida (2 segundos)


   Tiempo total : 4 segundos


   concurrencia --> asincronía --> paralelismo (hacer las cosas al mismo tiempo)

   1.- Lista de usuario y lista de comida


   Tiempo total: (2 segundos)

   Hilo : un espacio de memoria que le sede Android a un proceso


   Hilo Principal (dedicado a renderizar contenido visual) {
        MainActivity

        viewModelScope.launch {
            Consulta de servicios
        }
    }

 */