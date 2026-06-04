package com.example.myfirstappincompose.data.remote.api

import com.example.myfirstappincompose.data.remote.dto.PokemonListResponse
import retrofit2.http.GET

interface ApiService {
    @GET("pokemon")
    suspend fun getPokemonList() : PokemonListResponse
}