package com.example.myfirstappincompose.ui.consultant.list

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PokemonDetailComposeView(modifier: Modifier, pokemonName: String){

    Card(modifier = modifier
        .border(width = 1.dp, color = Color.Black)
    ) {
            Text(
                text = "POKEMON: ${pokemonName.uppercase()}",
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                fontSize = 16.sp,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
            Text(
                text = "Detalles: ",
                modifier = Modifier
                    .padding(16.dp),
            )


        }
    }

@Preview(showSystemUi = true)
@Composable
fun DetailPreview(){
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        PokemonDetailComposeView(
            pokemonName = "NombrePokemon",
            modifier = Modifier.padding(innerPadding)
        )
    }
}