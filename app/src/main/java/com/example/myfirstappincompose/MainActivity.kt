package com.example.myfirstappincompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myfirstappincompose.data.remote.dto.PokemonListResponse
import com.example.myfirstappincompose.data.remote.dto.PokemonResponse
import com.example.myfirstappincompose.data.remote.network.RetrofitClient
import com.example.myfirstappincompose.ui.theme.MyFirstAppInComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstAppInComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val pokemonList = remember {
        mutableStateOf(PokemonListResponse(results = emptyList()))
    }
    LaunchedEffect(Unit) {
       pokemonList.value = RetrofitClient.apiService.getPokemonList()
        Log.d("info", pokemonList.toString())
    }
    MyPokemonListComposeView(
        pokemonList = pokemonList.value.results,
        modifier = modifier
    )
}


@Composable
fun MyPokemonListComposeView(pokemonList: List<PokemonResponse>, modifier: Modifier) {
    LazyColumn(modifier = modifier) {
        items(items = pokemonList) { pokemon ->
            Text(text = pokemon.name)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, backgroundColor = 0xFFFFFF)
@Composable
fun GreetingPreview() {
    MyFirstAppInComposeTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Greeting(
                name = "Android",
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}