package com.example.myfirstappincompose.ui.consultant.list

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myfirstappincompose.data.remote.dto.PokemonListResponse
import com.example.myfirstappincompose.data.remote.network.RetrofitClient


@Composable
fun MyPokemonListComposeView(modifier: Modifier,
                             onPokemonSelected: (String) -> Unit) {
    val pokemonList = remember {
        mutableStateOf(PokemonListResponse(results = emptyList()))
    }
    LaunchedEffect(Unit) {
        pokemonList.value = RetrofitClient.apiService.getPokemonList()
        Log.d("info", pokemonList.toString())
    }

    LazyColumn(modifier = modifier) {
        items(items = pokemonList.value.results) { pokemon ->
            PokemonItemComposeView(pokemon = pokemon,
                modifier = modifier,
                onPokemonClick = { name ->
                    onPokemonSelected(name)
                }
            )
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ListPreview() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        MyPokemonListComposeView(
            modifier = Modifier.padding(innerPadding),
            onPokemonSelected = {}
        )
    }
}