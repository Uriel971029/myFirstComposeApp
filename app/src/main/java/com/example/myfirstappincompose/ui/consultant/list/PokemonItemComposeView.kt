package com.example.myfirstappincompose.ui.consultant.list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstappincompose.data.remote.dto.PokemonResponse

@Composable
fun PokemonItemComposeView(pokemon : PokemonResponse, modifier: Modifier) {
    Card(modifier = modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp, vertical = 0.dp)
    ) {
        Text(
            modifier = modifier.padding(8.dp),
            text = "Nombre: ${pokemon.name}",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}



@Preview(showBackground = true, showSystemUi = true, backgroundColor = 0xFFFFFF)
@Composable
fun GreetingPreview() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        PokemonItemComposeView(
            pokemon = PokemonResponse(
                name = "Charizard",
                url = "link"
            ),
            modifier = Modifier.padding(innerPadding)
        )
    }
}