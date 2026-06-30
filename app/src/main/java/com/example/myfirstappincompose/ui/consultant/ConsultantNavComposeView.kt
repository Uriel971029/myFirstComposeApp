package com.example.myfirstappincompose.ui.consultant

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myfirstappincompose.ui.consultant.list.MyPokemonListComposeView

enum class ConsultantRoute(val route : String){
    LIST(route = "consultant/list"),
    DETAIL(route = "consultant/detail/{pokemonName}")
}

@Composable
fun ConsultantNavComposeView(
    innerPadding: PaddingValues
){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ConsultantRoute.LIST.route
    ){
      composable(ConsultantRoute.LIST.route) {
          MyPokemonListComposeView(
              modifier = Modifier.padding(innerPadding),
              onPokemonSelected = { name ->
                  navController.navigate("consultant/detail/$name")
              }
          )
      }
        composable(ConsultantRoute.DETAIL.route){ backStackEntry ->

            val pokemonName = backStackEntry.arguments?.getString("pokemonName").orEmpty()

            com.example.myfirstappincompose.ui.consultant.list.PokemonDetailComposeView(
                modifier = Modifier.padding(innerPadding),
                pokemonName = pokemonName
            )
        }
    }
}