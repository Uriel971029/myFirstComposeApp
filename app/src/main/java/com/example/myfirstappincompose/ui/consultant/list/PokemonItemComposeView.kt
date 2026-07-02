package com.example.myfirstappincompose.ui.consultant.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstappincompose.R
import com.example.myfirstappincompose.data.remote.dto.PokemonResponse
import com.example.myfirstappincompose.ui.theme.RetroBorderDark

@Composable
fun PokemonItemComposeView( pokemon : PokemonResponse,
                            modifier: Modifier,
                            onPokemonClick: (String) -> Unit

){

        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
            .border(width = 3.dp, color = RetroBorderDark)
            .padding(16.dp)
        )
        {
            Image(
                painter = painterResource(id = R.drawable.bulbasaur),
                contentDescription = "Imagen",
                modifier = Modifier
                    .size(66.dp)

            )

            Column(modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),

            ){
                Text(
                    modifier = modifier
                        .padding(2.dp),
                    fontFamily = FontFamily.Monospace,
                    fontSize = 16.sp,
                    text = "Nombre: ${pokemon.name}".uppercase()

                )
                Text(
                    modifier = Modifier
                        .padding(2.dp)
                        .padding(bottom =16.dp),
                    color = Color(0xFF666666),
                    fontSize = 11.sp,
                    fontFamily = FontFamily.Monospace,
                    text = "URL: ${pokemon.url}".uppercase()
                )
                Button(onClick = {
                        onPokemonClick(pokemon.name)
                }
                ) {
                    Text("Continuar")
                }
            }
        }
}

@Preview(showBackground = true, showSystemUi = true, backgroundColor = 0xFFFFFFF)
@Composable
fun GreetingPreview() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        PokemonItemComposeView(
            pokemon = PokemonResponse(
                name = "Charizard",
                url = "Link"
            ),
            modifier = Modifier.padding(innerPadding),
            onPokemonClick = {}
        )
    }
}
